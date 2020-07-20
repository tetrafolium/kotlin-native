/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package kotlin.collections

actual class HashSet<E> internal constructor(
    private val backing: HashMap<E, *>
) : MutableSet<E>, kotlin.native.internal.KonanSet<E>, AbstractMutableSet<E>() {

    actual constructor() : this(HashMap<E, Nothing>())

    actual constructor(initialCapacity: Int) : this(HashMap<E, Nothing>(initialCapacity))

    actual constructor(elements: Collection<E>) : this(elements.size) {
        addAll(elements)
    }

    // This implementation doesn't use a loadFactor
    actual constructor(initialCapacity: Int, loadFactor: Float) : this(initialCapacity)

    @PublishedApi
    internal fun build(): Set<E> {
        backing.build()
        return this
    }

    actual override val size: Int get() = backing.size
    actual override fun isEmpty(): Boolean = backing.isEmpty()
    actual override fun contains(element: E): Boolean = backing.containsKey(element)
    override fun getElement(element: E): E? = backing.getKey(element)
    actual override fun clear() = backing.clear()
    actual override fun add(element: E): Boolean = backing.addKey(element) >= 0
    actual override fun remove(element: E): Boolean = backing.removeKey(element) >= 0
    actual override fun iterator(): MutableIterator<E> = backing.keysIterator()

    actual override fun addAll(elements: Collection<E>): Boolean {
        backing.checkIsMutable()
        return super.addAll(elements)
    }

    actual override fun removeAll(elements: Collection<E>): Boolean {
        backing.checkIsMutable()
        return super.removeAll(elements)
    }

    actual override fun retainAll(elements: Collection<E>): Boolean {
        backing.checkIsMutable()
        return super.retainAll(elements)
    }
}

// This hash set keeps insertion order.
actual typealias LinkedHashSet<V> = HashSet<V>
