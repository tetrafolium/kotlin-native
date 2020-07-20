import kotlinx.cinterop.*
import mangling.*
import kotlin.test.*

fun main() {
    companion = _Companion.`Companion$`
    assertEquals(_Companion.`Companion$`, companion)
}
