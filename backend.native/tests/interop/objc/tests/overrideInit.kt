import kotlinx.cinterop.*
import objcTests.*
import kotlin.test.*

@Test fun testOverrideInit() {
    assertEquals(42, (TestOverrideInitImpl.createWithValue(42) as TestOverrideInitImpl).value)
}

private class TestOverrideInitImpl @OverrideInit constructor(val value: Int) : TestOverrideInit(value) {
    companion object : TestOverrideInitMeta()
}
