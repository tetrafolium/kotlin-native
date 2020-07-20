import auxiliaryCppSources.*
import kotlinx.cinterop.*
import kotlin.test.*

fun main() {
    assertEquals(name()!!.toKString(), "Hello from C++")
}
