import kotlinx.cinterop.*
import mangling2.*
import kotlin.test.*

fun main() {
    val mangled = `Companion$`.Two
    assertEquals(`Companion$`.Two, mangled)
}
