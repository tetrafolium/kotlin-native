import cvalues.*
import kotlinx.cinterop.*
import kotlin.test.*

fun main() {
    assertTrue(isNullString(null))
    assertTrue(isNullWString(null))
    assertFalse(isNullString("a"))
    assertFalse(isNullWString("b"))
}
