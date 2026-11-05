package pmdm.seeshow.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pmdm.seeshow.R

// Figtree
val Figtree = FontFamily(
    Font(R.font.figtree_regular, FontWeight.Normal),
    Font(R.font.figtree_medium, FontWeight.Medium),
    Font(R.font.figtree_semibold, FontWeight.SemiBold),
    Font(R.font.figtree_bold, FontWeight.Bold)
)

// Source Serif 4
val SourceSerif = FontFamily(
    Font(R.font.source_serif_4_regular, FontWeight.Normal),
    Font(R.font.source_serif_4_medium, FontWeight.Medium),
    Font(R.font.source_serif_4_semibold, FontWeight.SemiBold),
    Font(R.font.source_serif_4_bold, FontWeight.Bold)
)

val AppTypography = Typography(
    // 1. TÍTULO GIGANTE (Ej: "Severance" o los títulos de las series)
    headlineLarge = TextStyle(
        fontFamily = SourceSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),

    // 2. TÍTULOS DE SECCIÓN (Ej: "Reparto", "También te puede gustar")
    titleLarge = TextStyle(
        fontFamily = SourceSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),

    // 3. SUBTÍTULOS (Ej: "The We We Are", "T1 · E09")
    titleMedium = TextStyle(
        fontFamily = SourceSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),

    // 4. TEXTO NORMAL (Ej: Sinopsis, textos de los botones, "Adam Scott")
    bodyMedium = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    // 5. TEXTO PEQUEÑO (Ej: "40 min", "2022", textos secundarios)
    bodySmall = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),

    // 6. ETIQUETAS / BOTONES (Para la barra de navegación o chips)
    labelMedium = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    // 7. ETIQUETAS / BOTONES pequeños
    labelSmall = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )

)