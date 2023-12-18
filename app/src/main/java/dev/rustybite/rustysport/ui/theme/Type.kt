package dev.rustybite.rustysport.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.rustybite.rustysport.R


//private val ubuntuLight = FontFamily(Font(R.font.ubuntu_light))
private val ubuntuMedium = FontFamily(Font(R.font.ubuntu_medium))
private val ubuntuRegular = FontFamily(Font(R.font.ubuntu_regular))

val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = ubuntuRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.3.sp
        ),
        bodyMedium = TextStyle(
                fontFamily = ubuntuRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.3.sp
        ),
        bodySmall = TextStyle(
                fontFamily = ubuntuRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.3.sp
        ),
        titleLarge = TextStyle(
                fontFamily = ubuntuRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
                fontFamily = ubuntuRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        ),
        titleSmall = TextStyle(
                fontFamily = ubuntuRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
        ),
        labelLarge = TextStyle(
                fontFamily = ubuntuMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
        ),
        labelMedium = TextStyle(
                fontFamily = ubuntuMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
        ),
        labelSmall = TextStyle(
                fontFamily = ubuntuMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
        ),
)