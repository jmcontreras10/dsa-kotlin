package org.example.algorithms.graphs

import org.example.dataStructures.queue.Queue

//  Using Matrix Adjacency
fun bfs(grap: Array<BooleanArray>): List<Int> {
    if(grap.isEmpty()) return emptyList()
    val visited = Array(grap.size) {false}
    val ans = mutableListOf<Int>()
    val queue = Queue<Int>()

    queue.enqueue(0)

    while (queue.size > 0) {
        val current = queue.dequeue()!!
        if (!visited[current]) {
            visited[current] = true
            ans.add(current)
            for ((child, isConnection) in grap[current].withIndex()) {
                if (isConnection) { // Is current connected with child?
                    queue.enqueue(child)
                }
            }
        }
    }
    return ans
}