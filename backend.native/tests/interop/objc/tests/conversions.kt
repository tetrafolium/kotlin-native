import kotlinx.cinterop.*
import objcTests.*
import kotlin.test.*

@Test fun testConversions() {
    testMethodsOfAny(emptyList<Nothing>(), NSArray())
    testMethodsOfAny(listOf(1, "foo"), nsArrayOf(1, "foo"))
    testMethodsOfAny(42, NSNumber.numberWithInt(42), 17)
    testMethodsOfAny(true, NSNumber.numberWithBool(true), false)
}

private fun testMethodsOfAny(kotlinObject: Any, equalNsObject: NSObject, otherObject: Any = Any()) {
    assertEquals(kotlinObject.hashCode(), equalNsObject.hashCode())
    assertEquals(kotlinObject.toString(), equalNsObject.toString())
    assertEquals(kotlinObject, equalNsObject)
    assertEquals(equalNsObject, kotlinObject)
    assertNotEquals(equalNsObject, otherObject)
}
