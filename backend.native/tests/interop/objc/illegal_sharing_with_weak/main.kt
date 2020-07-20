import kotlinx.cinterop.autoreleasepool
import objclib.*
import kotlin.native.concurrent.*

fun main() {
    autoreleasepool {
        run()
    }
}

private class NSObjectImpl : NSObject() {
    var x = 111
}

fun run() = withWorker {
    val obj = NSObjectImpl()
    setObject(obj)

    println("Before")
    val isAlive = try {
        execute(TransferMode.SAFE, {}) {
            isObjectAliveShouldCrash()
        }.result
    } catch (e: Throwable) {
        false
    }
    println("After $isAlive")
}
