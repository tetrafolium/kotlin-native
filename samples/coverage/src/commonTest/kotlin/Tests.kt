import kotlin.test.Test

class CoverageTests {
    @Test
    fun testHello() {
        main()
    }

    @Test
    fun testA() {
        val a = A()
        a.f()
    }
}