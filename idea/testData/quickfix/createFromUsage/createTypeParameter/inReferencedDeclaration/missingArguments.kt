// "Create type parameter in class 'X'" "false"
// ERROR: 2 type arguments expected for class X<T, U>
class X<T, U>
fun Y(x: X<<caret>String>) {}