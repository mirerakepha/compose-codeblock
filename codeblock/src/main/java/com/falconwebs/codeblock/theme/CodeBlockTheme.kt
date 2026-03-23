package com.falconwebs.codeblock.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class CodeBlockTheme(
    val background: Color,
    val textColor: Color,
    val copyButtonColor: Color,
    val syntaxColors: Map<String, Color> = mapOf()
) {
    companion object {

        // ── Adaptive ─

        @Composable
        fun adaptive(): CodeBlockTheme =
            if (isSystemInDarkTheme()) darkAdaptive() else lightAdaptive()

        @Composable
        fun fromMaterialTheme(colorScheme: ColorScheme): CodeBlockTheme {
            return CodeBlockTheme(
                background    = colorScheme.surfaceVariant,
                textColor     = colorScheme.onSurface,
                copyButtonColor = colorScheme.primary,
                syntaxColors  = if (isSystemInDarkTheme()) Syntax.catppuccinDark() else Syntax.githubLight()
            )
        }

        // ── Dark themes ──

        /** Catppuccin Mocha */
        fun darkAdaptive() = CodeBlockTheme(
            background      = Color(0xFF1E1E2E),
            textColor       = Color(0xFFCDD6F4),
            copyButtonColor = Color(0xFFCBA6F7),
            syntaxColors    = Syntax.catppuccinDark()
        )

        fun dracula() = CodeBlockTheme(
            background      = Color(0xFF282A36),
            textColor       = Color(0xFFF8F8F2),
            copyButtonColor = Color(0xFFFF79C6),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFFFF79C6),
                "string"   to Color(0xFFF1FA8C),
                "comment"  to Color(0xFF6272A4),
                "number"   to Color(0xFFBD93F9),
                "function" to Color(0xFF50FA7B),
                "type"     to Color(0xFF8BE9FD),
                "bracket"  to Color(0xFFF8F8F2),
                "operator" to Color(0xFFFF79C6)
            )
        )

        fun oneDarkPro() = CodeBlockTheme(
            background      = Color(0xFF282C34),
            textColor       = Color(0xFFABB2BF),
            copyButtonColor = Color(0xFF61AFEF),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFFC678DD),
                "string"   to Color(0xFF98C379),
                "comment"  to Color(0xFF5C6370),
                "number"   to Color(0xFFD19A66),
                "function" to Color(0xFF61AFEF),
                "type"     to Color(0xFFE5C07B),
                "bracket"  to Color(0xFF56B6C2),
                "operator" to Color(0xFF56B6C2)
            )
        )

        /** Tokyo Night */
        fun tokyoNight() = CodeBlockTheme(
            background      = Color(0xFF1A1B26),
            textColor       = Color(0xFFC0CAF5),
            copyButtonColor = Color(0xFF7AA2F7),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF9D7CD8),
                "string"   to Color(0xFF9ECE6A),
                "comment"  to Color(0xFF565F89),
                "number"   to Color(0xFFFF9E64),
                "function" to Color(0xFF7AA2F7),
                "type"     to Color(0xFF2AC3DE),
                "bracket"  to Color(0xFF89DDFF),
                "operator" to Color(0xFF89DDFF)
            )
        )

        fun tokyoNightLight() = CodeBlockTheme(
            background      = Color(0xFFD5D6DB),
            textColor       = Color(0xFF343B59),
            copyButtonColor = Color(0xFF34548A),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF5A4A78),
                "string"   to Color(0xFF485E30),
                "comment"  to Color(0xFF9699A3),
                "number"   to Color(0xFF965027),
                "function" to Color(0xFF34548A),
                "type"     to Color(0xFF0F4B6E),
                "bracket"  to Color(0xFF0F4B6E),
                "operator" to Color(0xFF5A4A78)
            )
        )

        /** Nord Dark */
        fun nord() = CodeBlockTheme(
            background      = Color(0xFF2E3440),
            textColor       = Color(0xFFD8DEE9),
            copyButtonColor = Color(0xFF88C0D0),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF81A1C1),
                "string"   to Color(0xFFA3BE8C),
                "comment"  to Color(0xFF616E88),
                "number"   to Color(0xFFB48EAD),
                "function" to Color(0xFF88C0D0),
                "type"     to Color(0xFF8FBCBB),
                "bracket"  to Color(0xFF81A1C1),
                "operator" to Color(0xFF81A1C1)
            )
        )

        fun nordLight() = CodeBlockTheme(
            background      = Color(0xFFECEFF4),
            textColor       = Color(0xFF2E3440),
            copyButtonColor = Color(0xFF5E81AC),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF5E81AC),
                "string"   to Color(0xFF4C7A2F),
                "comment"  to Color(0xFF9099AA),
                "number"   to Color(0xFF7B4E9E),
                "function" to Color(0xFF4C7A8B),
                "type"     to Color(0xFF2E6B6B),
                "bracket"  to Color(0xFF5E81AC),
                "operator" to Color(0xFF5E81AC)
            )
        )

        fun monokai() = CodeBlockTheme(
            background      = Color(0xFF272822),
            textColor       = Color(0xFFF8F8F2),
            copyButtonColor = Color(0xFFA6E22E),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFFF92672),
                "string"   to Color(0xFFE6DB74),
                "comment"  to Color(0xFF75715E),
                "number"   to Color(0xFFAE81FF),
                "function" to Color(0xFFA6E22E),
                "type"     to Color(0xFF66D9E8),
                "bracket"  to Color(0xFFF8F8F2),
                "operator" to Color(0xFFF92672)
            )
        )

        fun solarizedDark() = CodeBlockTheme(
            background      = Color(0xFF002B36),
            textColor       = Color(0xFF839496),
            copyButtonColor = Color(0xFF268BD2),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF859900),
                "string"   to Color(0xFF2AA198),
                "comment"  to Color(0xFF586E75),
                "number"   to Color(0xFFD33682),
                "function" to Color(0xFF268BD2),
                "type"     to Color(0xFFB58900),
                "bracket"  to Color(0xFF93A1A1),
                "operator" to Color(0xFF859900)
            )
        )

        fun solarizedLight() = CodeBlockTheme(
            background      = Color(0xFFFDF6E3),
            textColor       = Color(0xFF657B83),
            copyButtonColor = Color(0xFF268BD2),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF859900),
                "string"   to Color(0xFF2AA198),
                "comment"  to Color(0xFF93A1A1),
                "number"   to Color(0xFFD33682),
                "function" to Color(0xFF268BD2),
                "type"     to Color(0xFFB58900),
                "bracket"  to Color(0xFF657B83),
                "operator" to Color(0xFF859900)
            )
        )

        fun gruvboxDark() = CodeBlockTheme(
            background      = Color(0xFF282828),
            textColor       = Color(0xFFEBDBB2),
            copyButtonColor = Color(0xFF83A598),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFFFB4934),
                "string"   to Color(0xFFB8BB26),
                "comment"  to Color(0xFF928374),
                "number"   to Color(0xFFD3869B),
                "function" to Color(0xFF83A598),
                "type"     to Color(0xFFFABD2F),
                "bracket"  to Color(0xFFFE8019),
                "operator" to Color(0xFFFB4934)
            )
        )

        fun gruvboxLight() = CodeBlockTheme(
            background      = Color(0xFFFBF1C7),
            textColor       = Color(0xFF3C3836),
            copyButtonColor = Color(0xFF076678),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF9D0006),
                "string"   to Color(0xFF79740E),
                "comment"  to Color(0xFF928374),
                "number"   to Color(0xFF8F3F71),
                "function" to Color(0xFF076678),
                "type"     to Color(0xFFB57614),
                "bracket"  to Color(0xFFAF3A03),
                "operator" to Color(0xFF9D0006)
            )
        )

        /** GitHub Light */
        fun lightAdaptive() = CodeBlockTheme(
            background      = Color(0xFFF6F8FA),
            textColor       = Color(0xFF24292E),
            copyButtonColor = Color(0xFF0969DA),
            syntaxColors    = Syntax.githubLight()
        )

        fun githubLight() = lightAdaptive()

        fun githubDark() = CodeBlockTheme(
            background      = Color(0xFF0D1117),
            textColor       = Color(0xFFE6EDF3),
            copyButtonColor = Color(0xFF58A6FF),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFFFF7B72),
                "string"   to Color(0xFFA5D6FF),
                "comment"  to Color(0xFF8B949E),
                "number"   to Color(0xFF79C0FF),
                "function" to Color(0xFFD2A8FF),
                "type"     to Color(0xFFFFA657),
                "bracket"  to Color(0xFFE6EDF3),
                "operator" to Color(0xFFFF7B72)
            )
        )

        /** High Contrast Dark */
        fun highContrast() = CodeBlockTheme(
            background      = Color(0xFF000000),
            textColor       = Color(0xFFFFFFFF),
            copyButtonColor = Color(0xFF00FF00),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF569CD6),
                "string"   to Color(0xFFCE9178),
                "comment"  to Color(0xFF6A9955),
                "number"   to Color(0xFFB5CEA8),
                "function" to Color(0xFFDCDCAA),
                "type"     to Color(0xFF4EC9B0),
                "bracket"  to Color(0xFFFFD700),
                "operator" to Color(0xFF569CD6)
            )
        )

        /** High Contrast Light */
        fun highContrastLight() = CodeBlockTheme(
            background      = Color(0xFFFFFFFF),
            textColor       = Color(0xFF000000),
            copyButtonColor = Color(0xFF0000CC),
            syntaxColors    = mapOf(
                "keyword"  to Color(0xFF0000FF),
                "string"   to Color(0xFF811F3F),
                "comment"  to Color(0xFF008000),
                "number"   to Color(0xFF098658),
                "function" to Color(0xFF795E26),
                "type"     to Color(0xFF267F99),
                "bracket"  to Color(0xFF000000),
                "operator" to Color(0xFF0000FF)
            )
        )
    }
}

// ── Shared base palettes ──
private object Syntax {
    fun catppuccinDark() = mapOf(
        "keyword"  to Color(0xFFCBA6F7),
        "string"   to Color(0xFFA6E3A1),
        "comment"  to Color(0xFF6C7086),
        "number"   to Color(0xFFFAB387),
        "function" to Color(0xFF89DCEB),
        "type"     to Color(0xFF89B4FA),
        "bracket"  to Color(0xFF94E2D5),
        "operator" to Color(0xFFCBA6F7)
    )

    fun githubLight() = mapOf(
        "keyword"  to Color(0xFFD73A49),
        "string"   to Color(0xFF032F62),
        "comment"  to Color(0xFF6A737D),
        "number"   to Color(0xFF005CC5),
        "function" to Color(0xFF6F42C1),
        "type"     to Color(0xFF22863A),
        "bracket"  to Color(0xFF24292E),
        "operator" to Color(0xFFD73A49)
    )
}