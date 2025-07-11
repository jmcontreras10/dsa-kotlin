package org.example.algorithms.graphs

//  Using Matrix Adjacency
fun dfs (graph: Array<BooleanArray>): List<Int> {
    if (graph.isEmpty()) return listOf()
    val visited = Array(graph.size) {false}
    val ans = mutableListOf<Int>()

    fun visit (current: Int) {
        if (!visited[current]) {
            visited[current] = true
            ans.add(current)
            for ((child, isConnection) in graph[current].withIndex()) {
                if (isConnection) { // current has a child
                    visit(child)
                }
            }
        }
    }
    for (i in graph.indices) {
        visit(i)
    }
    return ans
}