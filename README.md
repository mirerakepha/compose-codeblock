# CodeBlock for Jetpack Compose

[![](https://jitpack.io/v/mirerakepha/compose-codeblock.svg)](https://jitpack.io/#mirerakepha/compose-codeblock)

A zero-config syntax highlighting code block component for Jetpack Compose.
Auto-detects the programming language and adapts to your app's light/dark theme.

---

## Sample Previews
| Light Theme | Dark Theme |
|---|---|
| ![Screenshot_20260323-164211](https://github.com/user-attachments/assets/9ad61beb-cb2f-4ea4-9e82-b0168e7a4731) | ![Screenshot_20260323-164242](https://github.com/user-attachments/assets/3691ecba-3799-4cbd-b195-de58924be1ba) |

---

| Dracula | One Dark Pro | Tokyo Night |
|---|---|---|
| ![Screenshot_20260323-133434](https://github.com/user-attachments/assets/f79ca451-667f-44a6-afd2-9cc939053f0a) | ![Screenshot_20260323-132853](https://github.com/user-attachments/assets/8bf7518d-99b8-423a-a427-6259dba5e4a3) | ![Screenshot_20260323-132943](https://github.com/user-attachments/assets/86f5fafb-2935-4c5f-b08b-e52d286ccfc6) |

| GitHub Light | Nord | Gruvbox Dark |
|---|---|---|
| ![Screenshot_20260323-133049](https://github.com/user-attachments/assets/15f095cf-30fe-4167-8d79-ca2d34873045) | ![Screenshot_20260323-133128](https://github.com/user-attachments/assets/4c42692d-f036-4374-9711-16a286db6015) | ![Screenshot_20260323-133246](https://github.com/user-attachments/assets/bb453e42-1336-412c-8a6f-835502408193) |

---

## Setup

### 1. Add JitPack to your `settings.gradle.kts`
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        // add jitpack here 👇🏽
        maven { url = uri("https://jitpack.io") }
    }
}
```

Or if you're using `settings.gradle` (Groovy):
```groovy
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        // add jitpack here 👇🏽
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add the dependency
```kotlin
dependencies {
    implementation("com.github.mirerakepha:compose-codeblock:{LAST-RELEASE}")
}
```

---

## Usage

### Imports
```kotlin
import com.falconwebs.codeblock.core.CodeBlock
import com.falconwebs.codeblock.theme.CodeBlockTheme
```

### Zero config — auto adapts to your app's dark/light theme
```kotlin
CodeBlock(code = myCode)
```

### With an explicit theme
```kotlin
CodeBlock(
    code = myCode,
    theme = CodeBlockTheme.dracula()
)
```

### Tied to your own dark/light toggle
```kotlin
CodeBlock(
    code = myCode,
    theme = if (isDarkTheme) CodeBlockTheme.oneDarkPro() else CodeBlockTheme.githubLight()
)
```

### All options
```kotlin
CodeBlock(
    code            = myCode,
    theme           = CodeBlockTheme.tokyoNight(),
    showCopyButton  = true,                        
    showLanguageLabel = true,                     
    modifier        = Modifier.fillMaxWidth()
)
```

---

## Available Themes

### Dark

| Function | Based on |
|---|---|
| `CodeBlockTheme.darkAdaptive()` | Catppuccin Mocha |
| `CodeBlockTheme.dracula()` | Dracula |
| `CodeBlockTheme.oneDarkPro()` | One Dark Pro |
| `CodeBlockTheme.tokyoNight()` | Tokyo Night |
| `CodeBlockTheme.nord()` | Nord |
| `CodeBlockTheme.monokai()` | Monokai |
| `CodeBlockTheme.gruvboxDark()` | Gruvbox Dark |
| `CodeBlockTheme.solarizedDark()` | Solarized Dark |
| `CodeBlockTheme.githubDark()` | GitHub Dark |
| `CodeBlockTheme.highContrast()` | High Contrast Dark |

### Light

| Function | Based on |
|---|---|
| `CodeBlockTheme.lightAdaptive()` | GitHub Light |
| `CodeBlockTheme.githubLight()` | GitHub Light |
| `CodeBlockTheme.tokyoNightLight()` | Tokyo Night Light |
| `CodeBlockTheme.nordLight()` | Nord Light |
| `CodeBlockTheme.gruvboxLight()` | Gruvbox Light |
| `CodeBlockTheme.solarizedLight()` | Solarized Light |
| `CodeBlockTheme.highContrastLight()` | High Contrast Light |

### Adaptive (reads system theme automatically)
```kotlin
// Reads isSystemInDarkTheme() automatically
CodeBlockTheme.adaptive()

// Reads your MaterialTheme colorScheme
CodeBlockTheme.fromMaterialTheme(MaterialTheme.colorScheme)
```

---

## Supported Languages

Auto-detected from code content — no configuration needed.

`Kotlin` · `Java` · `Python` · `JavaScript` · `TypeScript` · `C++` · `Rust` · `Go` · `SQL` · `XML/HTML` · `JSON` · `Shell`

---

## Requirements

- `minSdk 24`
- Jetpack Compose
- Material3

---

## License
```
MIT License
Copyright (c) 2026 mirerakepha
```
