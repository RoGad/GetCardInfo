import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CardNumberVisual : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val original = text.text.replace(" ", "")
        val formatted = original.chunked(4).joinToString(" ")

        return TransformedText(
            AnnotatedString(formatted),
            CardOffsetMapping(original, formatted)
        )
    }

    private class CardOffsetMapping(
        private val original: String,
        private val formatted: String
    ) : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            var transformedOffset = offset
            for (i in 1..offset) {
                if (i % 4 == 0 && i < original.length) {
                    transformedOffset++
                }
            }
            return transformedOffset
        }

        override fun transformedToOriginal(offset: Int): Int {
            return offset - formatted.take(offset).count { it == ' ' }
        }
    }
}
