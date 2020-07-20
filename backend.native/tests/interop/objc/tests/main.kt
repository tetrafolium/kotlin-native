import kotlinx.cinterop.autoreleasepool
import kotlin.native.internal.test.testLauncherEntryPoint
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    autoreleasepool {
        val exitCode = testLauncherEntryPoint(args)
        // Note: this test runner checks for memory leaks after successful execution, unlike standard one.
        if (exitCode != 0) exitProcess(exitCode)
    }
}
