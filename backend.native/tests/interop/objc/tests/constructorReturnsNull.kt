import kotlinx.cinterop.*
import objcTests.*
import kotlin.test.*

@Test fun testConstructorReturnsNull() {
    assertFailsWith<NullPointerException>() {
        TestConstructorReturnsNull()
    }
}
