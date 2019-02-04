package org.jetbrains.kotlin.konan.file

import java.net.URI
import java.nio.file.*

private val File.zipUri: URI
    get() = URI.create("jar:${this.toPath().toUri()}")

fun File.zipFileSystem(mutable: Boolean = false): FileSystem {
    val zipUri = this.zipUri
    val attributes = hashMapOf("create" to mutable.toString())
    return try {
        FileSystems.newFileSystem(zipUri, attributes, null)
    } catch (e: FileSystemAlreadyExistsException) {
        FileSystems.getFileSystem(zipUri)
    }
}

fun FileSystem.file(file: File) = File(this.getPath(file.path))

fun FileSystem.file(path: String) = File(this.getPath(path))

private fun File.toPath() = Paths.get(this.path)

fun File.zipDirAs(unixFile: File) {
    unixFile.withMutableZipFileSystem() {
        this.recursiveCopyTo(it.file("/"))
    }
}

fun Path.unzipTo(directory: Path) {
    val zipUri = URI.create("jar:" + this.toUri())
    FileSystems.newFileSystem(zipUri, emptyMap<String, Any?>(), null).use { zipfs ->
        val zipPath = zipfs.getPath("/")
        zipPath.recursiveCopyTo(directory)
    }
}

fun <T> File.withZipFileSystem(mutable: Boolean = false, action: (FileSystem) -> T): T {
    val zipFileSystem = this.zipFileSystem(mutable)
    return try {
        action(zipFileSystem)
    } finally {
        zipFileSystem.close()
    }
}

fun <T> File.withZipFileSystem(action: (FileSystem) -> T): T
        = this.withZipFileSystem(false, action)

fun <T> File.withMutableZipFileSystem(action: (FileSystem) -> T): T
        = this.withZipFileSystem(true, action)