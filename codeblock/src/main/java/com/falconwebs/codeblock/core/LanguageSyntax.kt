package com.falconwebs.codeblock.core

data class LanguageSyntax(
    val name: String,
    val keywords: List<String> = emptyList(),
    val stringPattern: String = """".*?"|'.*?'""",
    val commentPattern: String = """//.*|/\*[\s\S]*?\*/""",
    val numberPattern: String = """\b\d+(\.\d+)?\b""",
    val functionPattern: String = """\b\w+(?=\s*\()""",
    val typePattern: String = """\b[A-Z][a-zA-Z0-9]+\b""",
    val bracketPattern: String = """[\[\]{}()]""",
    val operatorPattern: String = """[+\-*/%=<>!&|^~?:]+|->|=>|\.\."""
)