package org.example.dataStructures.heap

class Heap<T>(
    private val compare: (a: T, b: T) -> Int
): IHeap<T> {
    private val heap = arrayListOf<T>()
    var size = 0

    override fun add(element: T) {
        var curr = size
        heap.add(element)
        size++
        while (compare(heap[curr], heap[curr/2]) < 0) {
            swap(curr, curr/2)
            curr /= 2
        }
    }

    override fun top(): T? {
        if (size == -0) return null
        return heap[0]
    }

    override fun getTop(): T? {
        if (size == 0) return null
        val removed = heap[0]
        swap(0, size - 1)
        heap.removeAt(size - 1)
        size--
        heapify(0)
        return removed
    }

    private fun swap(i: Int, j: Int ){
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    private fun heapify(rootIndex: Int) {
        val left = (2*rootIndex) + 1
        val right = (2*rootIndex) + 2
        var toMove = rootIndex

        if (left <= size - 1 && compare(heap[rootIndex], heap[left]) > 0) {
            toMove = left
        }
        if (right <= size - 1 && compare(heap[toMove], heap[right]) > 0) {
            toMove = right
        }
        if (toMove != rootIndex) {
            swap(rootIndex, toMove)
            heapify(toMove)
        }
    }
}