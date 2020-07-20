import kotlinx.cinterop.*
import objcTests.*
import kotlin.test.*

@Test fun testCustomString() {
    assertFalse(customStringDeallocated)

    fun test() = autoreleasepool {
        val str: String = createCustomString(321)
        assertEquals("321", str)
        assertEquals("CustomString", str.objCClassName)
        assertEquals(321, getCustomStringValue(str))
    }

    test()
    kotlin.native.internal.GC.collect()
    assertTrue(customStringDeallocated)
}

private val Any.objCClassName: String
    get() = object_getClassName(this)!!.toKString()
