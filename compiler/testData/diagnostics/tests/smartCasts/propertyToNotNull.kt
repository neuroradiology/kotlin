// !WITH_NEW_INFERENCE
class Immutable(val x: String?) {
    fun foo(): String {
        if (x != null) return <!DEBUG_INFO_SMARTCAST!>x<!>
        return ""
    }
}

class Mutable(var y: String?) {
    fun foo(): String {
        if (y != null) return <!NI;TYPE_MISMATCH, SMARTCAST_IMPOSSIBLE!>y<!>
        return ""
    }
}