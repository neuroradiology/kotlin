// WITH_RUNTIME
// INTENTION_TEXT: "Replace with 'filter{}.forEach{}'"
// INTENTION_TEXT_2: "Replace with 'asSequence().filter{}.forEach{}'"
fun foo(list: List<String?>){
    <caret>for (l in list) {
        if (l == null) continue
        if (l.startsWith("IMG:"))
            println(l)
    }
}