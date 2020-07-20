import kotlinx.cinterop.*
import kotlin.native.concurrent.*

fun main() {
    val worker = Worker.start()
    // Make sure worker is initialized.
    worker.execute(TransferMode.SAFE, {}, {}).result
    StableRef.create(Any())
}
