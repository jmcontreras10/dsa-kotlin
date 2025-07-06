package org.example.dataStructures.list

class LinkedList<T>: IList<T> {
    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null
    var size = 0

    override fun add(item: T) {
        if(head == null) {
            head = ListNode(item)
            tail = head
            size++
            return
        }
        tail?.next = ListNode(item)
        tail = tail?.next
        size++
    }

    override fun removeFirstThat(matcher: (item: T?) -> Boolean): T? {
        var current = head
        val removed: T?
        if (matcher(current?.value)){
            removed = current?.value
            head = head?.next
            size--
            return removed
        }

        while (current?.next != null) {
            if (matcher(current.next?.value)){
                removed = current.next?.value
                current.next = current.next?.next
                size--
                return removed
            }
            current = current.next
        }
        return null
    }

    override fun removeAllThat(matcher: (item: T?) -> Boolean): Int {
        var removed = 0
        while(matcher(head?.value)) {
            head = head?.next
            removed++
        }

        var current: ListNode<T>? = head
        while(current?.next!= null) {
            if(matcher(current.next?.value)){
                current.next = current.next?.next
                removed++
            } else {
                current = current.next
            }
        }
        size -= removed
        return removed
    }

    override fun get(index: Int): T? {
        if (index < 0 || index >= size) return null
        if (index == size -1) {
            return tail?.value
        }
        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        return current?.value
    }

    override fun find(matcher: (T?) -> Boolean): T? {
        var current = head
        while(current != null) {
            if (matcher(current.value)) {
                return current.value
            }
            current = current.next
        }
        return null
    }

    override fun iterator(): Iterator<T> {
        return object: Iterator<T> {
            private var current = head
            override fun hasNext(): Boolean {
                return current?.next != null
            }

            override fun next(): T {
                val curr = current?.value
                current = current?.next
                return curr!!
            }

        }
    }
}