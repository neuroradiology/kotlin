// WITH_RUNTIME

fun test(list: List<Int>) {
    val sumByDouble: Double = list.<caret>filter { it > 1 }.sumByDouble { it.toDouble() }
}