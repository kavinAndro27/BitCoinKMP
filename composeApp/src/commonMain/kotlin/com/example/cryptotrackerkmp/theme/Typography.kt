import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cryptotrackerkmp.Res
import com.example.cryptotrackerkmp.space_mono_bold
import com.example.cryptotrackerkmp.space_mono_bold_italic
import com.example.cryptotrackerkmp.space_mono_italic
import com.example.cryptotrackerkmp.space_mono_regular
import org.jetbrains.compose.resources.Font


val SpaceMonoFontFamily
    @Composable get() = FontFamily(
        Font(
            Res.font.space_mono_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            Res.font.space_mono_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            Res.font.space_mono_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            Res.font.space_mono_bold_italic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),
    )


// Global typography used by AppTheme (shared for Android + iOS)
val AppTypography
    @Composable get() = Typography(
        displayLarge = TextStyle(
            fontFamily = SpaceMonoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = TextStyle(
            fontFamily = SpaceMonoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
            fontFamily = SpaceMonoFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.1.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = SpaceMonoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.1.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = SpaceMonoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        labelLarge = TextStyle(
            fontFamily = SpaceMonoFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        )
    )

