import kotlinx.cinterop.*
import objcTests.*
import kotlin.test.*

@Test fun testExceptions() {
    assertFailsWith<MyException> {
        ExceptionThrowerManager.throwExceptionWith(object : NSObject(), ExceptionThrowerProtocol {
            override fun throwException() {
                throw MyException()
            }
        })
    }
}

private class MyException : Throwable()
