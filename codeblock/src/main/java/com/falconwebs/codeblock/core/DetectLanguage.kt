package com.falconwebs.codeblock.core

private data class LanguageProfile(
    val syntax: LanguageSyntax,
    val indicators: List<String>,
    val weight: Int = 1
)

private val profiles = listOf(
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "Kotlin",
            keywords = listOf(
                "fun", "val", "var", "data class", "object", "companion", "suspend",
                "override", "sealed", "when", "is", "as", "by", "init", "constructor",
                "lateinit", "lazy"
            ),
            commentPattern = """//.*|/\*[\s\S]*?\*/""",
            stringPattern = """"(?:[^"\\]|\\.)*""""
        ),
        indicators = listOf(
            "fun ", "val ", "var ", "data class", "companion object",
            "suspend fun", "override fun", "println("
        ),
        weight = 2
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "Java",
            keywords = listOf(
                "public", "private", "protected", "class", "interface", "void",
                "int", "long", "boolean", "static", "final", "new", "extends",
                "implements", "return", "import", "package", "throws", "try", "catch", "finally"
            )
        ),
        indicators = listOf(
            "public class", "System.out", "void main", "@Override", "ArrayList<", "HashMap<"
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "Python",
            keywords = listOf(
                "def", "class", "import", "from", "if", "elif", "else", "for",
                "while", "return", "yield", "lambda", "with", "as", "pass", "raise",
                "except", "try", "finally", "and", "or", "not", "in", "is",
                "None", "True", "False"
            ),
            stringPattern = """"(?:[^"\\]|\\.)*"|'(?:[^'\\]|\\.)*'""",
            commentPattern = """#.*"""
        ),
        indicators = listOf(
            "def ", "import ", "print(", "elif ", "None", "self.", "__init__"
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "JavaScript",
            keywords = listOf(
                "const", "let", "var", "function", "return", "if", "else", "for",
                "while", "class", "extends", "import", "export", "default", "async",
                "await", "typeof", "instanceof", "new", "this", "null", "undefined",
                "true", "false"
            )
        ),
        indicators = listOf(
            "const ", "let ", "=>", "console.log", "document.", "require(",
            "module.exports", "useState(", "useEffect("
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "TypeScript",
            keywords = listOf(
                "const", "let", "var", "function", "return", "interface", "type",
                "enum", "class", "extends", "implements", "import", "export", "async",
                "await", "typeof", "keyof", "readonly", "private", "public", "protected",
                "as", "is"
            )
        ),
        indicators = listOf(
            ": string", ": number", ": boolean", "interface ", "type ",
            "implements ", "<T>", "readonly "
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "C++",
            keywords = listOf(
                "int", "double", "float", "char", "bool", "void", "auto", "const",
                "return", "if", "else", "for", "while", "class", "struct", "namespace",
                "using", "public", "private", "protected", "virtual", "override",
                "template", "nullptr"
            )
        ),
        indicators = listOf(
            "#include", "std::", "cout<<", "cin>>", "nullptr", "int main("
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "Rust",
            keywords = listOf(
                "fn", "let", "mut", "pub", "use", "mod", "struct", "enum", "impl",
                "trait", "for", "while", "loop", "if", "else", "match", "return",
                "self", "Self", "Vec", "Option", "Result", "Some", "None", "Ok",
                "Err", "move", "async", "await"
            ),
            commentPattern = """//.*|/\*[\s\S]*?\*/"""
        ),
        indicators = listOf(
            "fn main", "let mut", "println!", "impl ", "pub fn", "::new("
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "Go",
            keywords = listOf(
                "func", "var", "const", "type", "struct", "interface", "map",
                "chan", "go", "defer", "select", "case", "default", "return",
                "if", "else", "for", "range", "package", "import", "nil", "true",
                "false", "error"
            ),
            commentPattern = """//.*"""
        ),
        indicators = listOf(
            "func ", "package ", ":=", "fmt.", "chan ", "defer "
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "SQL",
            keywords = listOf(
                "SELECT", "FROM", "WHERE", "INSERT", "UPDATE", "DELETE", "CREATE",
                "TABLE", "INDEX", "DROP", "ALTER", "JOIN", "LEFT", "RIGHT", "INNER",
                "ON", "AS", "AND", "OR", "NOT", "NULL", "PRIMARY", "KEY", "FOREIGN",
                "REFERENCES", "GROUP", "BY", "ORDER", "HAVING", "LIMIT", "DISTINCT",
                "COUNT", "SUM", "AVG", "MAX", "MIN"
            ),
            commentPattern = """--.*|/\*[\s\S]*?\*/""",
            stringPattern = """"[^"]*"|'[^']*'"""
        ),
        indicators = listOf(
            "SELECT ", "FROM ", "WHERE ", "INSERT INTO", "CREATE TABLE"
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "XML/HTML",
            keywords = emptyList(),
            stringPattern = """"[^"]*"|'[^']*'""",
            commentPattern = """<!--[\s\S]*?-->""",
            typePattern = """</?[a-zA-Z][a-zA-Z0-9]*"""
        ),
        indicators = listOf(
            "<!DOCTYPE", "<html", "<div", "<body", "<?xml", "<root", "</"
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "JSON",
            keywords = listOf("true", "false", "null"),
            stringPattern = """"[^"\\]*(?:\\.[^"\\]*)*""""
        ),
        indicators = listOf(
            "{\"", "\":", "[{", "\": {", "\": ["
        )
    ),
    LanguageProfile(
        syntax = LanguageSyntax(
            name = "Shell",
            keywords = listOf(
                "if", "then", "else", "fi", "for", "do", "done", "while",
                "case", "esac", "function", "return", "export", "local", "echo", "exit"
            ),
            commentPattern = """#.*""",
            stringPattern = """"[^"]*"|'[^']*'"""
        ),
        indicators = listOf(
            "#!/bin/bash", "#!/bin/sh", "echo ", "export ", "sudo ", "apt-get"
        )
    )
)

fun detectLanguage(code: String): LanguageSyntax {
    val scores = profiles.map { profile ->
        val score = profile.indicators.count { code.contains(it) } * profile.weight
        profile.syntax to score
    }
    return scores.maxByOrNull { it.second }
        ?.takeIf { it.second > 0 }
        ?.first
        ?: LanguageSyntax("Plain Text")
}