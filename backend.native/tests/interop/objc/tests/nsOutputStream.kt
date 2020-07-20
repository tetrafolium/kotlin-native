import kotlinx.cinterop.*
import objcTests.*
import kotlin.test.*

@Test fun testNSOutputStreamToMemoryConstructor() {
    val stream: Any = NSOutputStream(toMemory = Unit)
    assertTrue(stream is NSOutputStream)
}
