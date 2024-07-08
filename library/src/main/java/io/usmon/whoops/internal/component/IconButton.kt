package io.usmon.whoops.internal.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * A filled button with an icon and text.
 *
 * @param icon The image vector to be used for the icon.
 * @param text The text to be displayed on the button.
 * @param onClick The callback to be invoked when the button is clicked.
 * @param modifier The modifier to be applied to the button.
 * @param enabled Whether the button is enabled.
 * @param contentDescription The content description for the icon.
 */
@Composable
internal fun IconButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = text,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
    )
    {
        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = icon,
            contentDescription = contentDescription
        )
        Text(
            modifier = Modifier.padding(start = 6.dp),
            text = text
        )
    }
}