package com.falconwebs.codeblock.core

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.falconwebs.codeblock.theme.CodeBlockTheme

@Composable
fun CodeBlock(
    code: String,
    modifier: Modifier = Modifier,
    theme: CodeBlockTheme? = null,
    showCopyButton: Boolean = true,
    showLanguageLabel: Boolean = true,
) {
    val colorScheme = MaterialTheme.colorScheme
    val resolvedTheme = theme ?: CodeBlockTheme.fromMaterialTheme(colorScheme)

    val scrollState = rememberScrollState()
    val clipboardManager = LocalClipboardManager.current

    // Cache detection — avoids re-running on every recomposition
    val language = remember(code) { detectLanguage(code) }
    val highlightedCode = remember(code, resolvedTheme, language) {
        highlightCode(code, resolvedTheme, language)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(resolvedTheme.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showLanguageLabel) {
                Text(
                    text = language.name,
                    color = resolvedTheme.copyButtonColor.copy(alpha = 0.8f),
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 0.5.sp
                )
            } else {
                Spacer(Modifier.width(1.dp))
            }

            if (showCopyButton) {
                TextButton(
                    onClick = { clipboardManager.setText(AnnotatedString(code)) },
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                ) {
                    Text(
                        text = "Copy",
                        color = resolvedTheme.copyButtonColor,
                        fontSize = 11.sp
                    )
                }
            }
        }

        //divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(resolvedTheme.textColor.copy(alpha = 0.08f))
        )

        //code area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .padding(12.dp)
        ) {
            SelectionContainer {
                Text(
                    text = highlightedCode,
                    fontSize = 13.sp,
                    fontFamily = FontFamily.Monospace,
                    lineHeight = 20.sp
                )
            }
        }
    }
}