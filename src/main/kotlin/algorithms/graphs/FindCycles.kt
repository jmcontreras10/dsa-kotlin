package org.example.algorithms.graphs

fun findCycles(tasksDependencies: Array<BooleanArray>): Array<IntArray> {
    val visited = mutableSetOf<Int>()
    val ans = mutableListOf<IntArray>()

    for (index in tasksDependencies.indices) {
        val currAns = mutableListOf<Int>()

        if (!visited.contains(index)) {
            findCycle(index, tasksDependencies, visited, ans, currAns)
        }
    }
    return ans.toTypedArray()
}

fun findCycle(
    current: Int,
    tasksDependencies: Array<BooleanArray>,
    visited: MutableSet<Int>,
    ans: MutableList<IntArray>,
    currAns: MutableList<Int>
) {
    if (visited.contains(current)) {
        ans.add(currAns.toIntArray())
        return
    }

    currAns.add(current)
    visited.add(current)
    for ((childIndex, childTaskDependency) in tasksDependencies[current].withIndex()) {
        if (childTaskDependency) {
            findCycle(childIndex, tasksDependencies, visited, ans, currAns)
        }
    }
    currAns.removeLast()
}