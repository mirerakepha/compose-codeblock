package com.falconwebs.codeblock.core

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import com.falconwebs.codeblock.theme.CodeBlockTheme

private enum class TokenType {
    COMMENT, STRING, KEYWORD, NUMBER, FUNCTION, TYPE, BRACKET, OPERATOR, PLAIN
}

private data class Token(val value: String, val start: Int, val end: Int, val type: TokenType)

fun highlightCode(
    code: String,
    theme: CodeBlockTheme,
    language: LanguageSyntax
): AnnotatedString {

    val patterns = buildList {
        // Order matters: comments and strings first to prevent keywords inside them being matched
        add(TokenType.COMMENT  to language.commentPattern.toRegex(RegexOption.MULTILINE))
        add(TokenType.STRING   to language.stringPattern.toRegex())
        if (language.keywords.isNotEmpty()) {
            val escaped = language.keywords.sortedByDescending { it.length }
                .joinToString("|") { Regex.escape(it) }
            add(TokenType.KEYWORD  to Regex("(?<![\\w.])($escaped)(?![\\w])"))
        }
        add(TokenType.NUMBER   to language.numberPattern.toRegex())
        add(TokenType.FUNCTION to language.functionPattern.toRegex())
        add(TokenType.TYPE     to language.typePattern.toRegex())
        add(TokenType.BRACKET  to language.bracketPattern.toRegex())
        add(TokenType.OPERATOR to language.operatorPattern.toRegex())
    }

    // Find all matches, pick the earliest+longest at each position
    val tokens = mutableListOf<Token>()
    var cursor = 0

    while (cursor < code.length) {
        var bestToken: Token? = null

        for ((type, regex) in patterns) {
            val match = regex.find(code, cursor) ?: continue
            if (match.range.first > (bestToken?.start ?: Int.MAX_VALUE)) continue
            if (match.range.first == (bestToken?.start ?: Int.MAX_VALUE) &&
                match.value.length <= (bestToken?.value?.length ?: 0)) continue
            bestToken = Token(match.value, match.range.first, match.range.last + 1, type)
        }

        if (bestToken == null) {
            cursor++
            continue
        }

        if (bestToken.start > cursor) {
            tokens.add(Token(code.substring(cursor, bestToken.start), cursor, bestToken.start, TokenType.PLAIN))
        }

        tokens.add(bestToken)
        cursor = bestToken.end
    }

    if (cursor < code.length) {
        tokens.add(Token(code.substring(cursor), cursor, code.length, TokenType.PLAIN))
    }

    return buildAnnotatedString {
        for (token in tokens) {
            val style = when (token.type) {
                TokenType.COMMENT  -> SpanStyle(
                    color = theme.syntaxColors["comment"] ?: theme.textColor,
                    fontStyle = FontStyle.Italic
                )
                TokenType.STRING   -> SpanStyle(
                    color = theme.syntaxColors["string"] ?: theme.textColor
                )
                TokenType.KEYWORD  -> SpanStyle(
                    color = theme.syntaxColors["keyword"] ?: theme.textColor,
                    fontWeight = FontWeight.Bold
                )
                TokenType.NUMBER   -> SpanStyle(
                    color = theme.syntaxColors["number"] ?: theme.textColor
                )
                TokenType.FUNCTION -> SpanStyle(
                    color = theme.syntaxColors["function"] ?: theme.textColor
                )
                TokenType.TYPE     -> SpanStyle(
                    color = theme.syntaxColors["type"] ?: theme.textColor
                )
                TokenType.BRACKET  -> SpanStyle(
                    color = theme.syntaxColors["bracket"] ?: theme.textColor,
                    fontWeight = FontWeight.Bold
                )
                TokenType.OPERATOR -> SpanStyle(
                    color = theme.syntaxColors["operator"] ?: theme.textColor
                )
                TokenType.PLAIN    -> SpanStyle(
                    color = theme.textColor
                )
            }
            pushStyle(style)
            append(token.value)
            pop()
        }
    }
}