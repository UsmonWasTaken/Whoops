package io.usmon.whoops.internal.util

import androidx.compose.ui.graphics.Color

internal object ColorUtils {
    /**
     * Applies the given alpha value to this color.
     *
     * The alpha value should be between 0.0 (transparent) and 1.0 (opaque).
     *
     * @param alpha The alpha value to apply.
     * @return A new color with the applied alpha value.
     */
    fun Color.applyAlpha(alpha: Float): Color {
        return this.copy(alpha = alpha)
    }
}