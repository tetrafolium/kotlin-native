import kotlinx.cinterop.*
import objcTests.*
import kotlin.native.concurrent.*

fun Worker.runInWorker(block: () -> Unit) {
    block.freeze()
    val future = this.execute(TransferMode.SAFE, { block }) {
        it()
    }
    future.result // Throws on failure.
}

fun nsArrayOf(vararg elements: Any): NSArray = NSMutableArray().apply {
    elements.forEach {
        this.addObject(it as ObjCObject)
    }
}
