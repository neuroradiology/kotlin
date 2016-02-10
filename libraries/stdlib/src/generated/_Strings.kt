@file:kotlin.jvm.JvmMultifileClass
@file:kotlin.jvm.JvmName("StringsKt")

package kotlin.text

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import kotlin.comparisons.*
import java.util.*

import java.util.Collections // TODO: it's temporary while we have java.util.Collections in js

/**
 * Returns a character at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this char sequence.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.elementAt(index: Int): Char {
    return get(index)
}

/**
 * Returns a character at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this char sequence.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.elementAtOrElse(index: Int, defaultValue: (Int) -> Char): Char {
    return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
}

/**
 * Returns a character at the given [index] or `null` if the [index] is out of bounds of this char sequence.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.elementAtOrNull(index: Int): Char? {
    return this.getOrNull(index)
}

/**
 * Returns the first character matching the given [predicate], or `null` if no such character was found.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.find(predicate: (Char) -> Boolean): Char? {
    return firstOrNull(predicate)
}

/**
 * Returns the last character matching the given [predicate], or `null` if no such character was found.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.findLast(predicate: (Char) -> Boolean): Char? {
    return lastOrNull(predicate)
}

/**
 * Returns first character.
 * @throws [NoSuchElementException] if the char sequence is empty.
 */
public fun CharSequence.first(): Char {
    if (isEmpty())
        throw NoSuchElementException("Collection is empty.")
    return this[0]
}

/**
 * Returns the first character matching the given [predicate].
 * @throws [NoSuchElementException] if no such character is found.
 */
public inline fun CharSequence.first(predicate: (Char) -> Boolean): Char {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("No element matching predicate was found.")
}

/**
 * Returns the first character, or `null` if the char sequence is empty.
 */
public fun CharSequence.firstOrNull(): Char? {
    return if (isEmpty()) null else this[0]
}

/**
 * Returns the first character matching the given [predicate], or `null` if character was not found.
 */
public inline fun CharSequence.firstOrNull(predicate: (Char) -> Boolean): Char? {
    for (element in this) if (predicate(element)) return element
    return null
}

/**
 * Returns a character at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this char sequence.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.getOrElse(index: Int, defaultValue: (Int) -> Char): Char {
    return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
}

/**
 * Returns a character at the given [index] or `null` if the [index] is out of bounds of this char sequence.
 */
public fun CharSequence.getOrNull(index: Int): Char? {
    return if (index >= 0 && index <= lastIndex) get(index) else null
}

/**
 * Returns index of the first character matching the given [predicate], or -1 if the char sequence does not contain such character.
 */
public inline fun CharSequence.indexOfFirst(predicate: (Char) -> Boolean): Int {
    for (index in indices) {
        if (predicate(this[index])) {
            return index
        }
    }
    return -1
}

/**
 * Returns index of the last character matching the given [predicate], or -1 if the char sequence does not contain such character.
 */
public inline fun CharSequence.indexOfLast(predicate: (Char) -> Boolean): Int {
    for (index in indices.reversed()) {
        if (predicate(this[index])) {
            return index
        }
    }
    return -1
}

/**
 * Returns the last character.
 * @throws [NoSuchElementException] if the char sequence is empty.
 */
public fun CharSequence.last(): Char {
    if (isEmpty())
        throw NoSuchElementException("Collection is empty.")
    return this[lastIndex]
}

/**
 * Returns the last character matching the given [predicate].
 * @throws [NoSuchElementException] if no such character is found.
 */
public inline fun CharSequence.last(predicate: (Char) -> Boolean): Char {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Collection doesn't contain any element matching the predicate.")
}

/**
 * Returns the last character, or `null` if the char sequence is empty.
 */
public fun CharSequence.lastOrNull(): Char? {
    return if (isEmpty()) null else this[length - 1]
}

/**
 * Returns the last character matching the given [predicate], or `null` if no such character was found.
 */
public inline fun CharSequence.lastOrNull(predicate: (Char) -> Boolean): Char? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/**
 * Returns the single character, or throws an exception if the char sequence is empty or has more than one character.
 */
public fun CharSequence.single(): Char {
    return when (length) {
        0 -> throw NoSuchElementException("Collection is empty.")
        1 -> this[0]
        else -> throw IllegalArgumentException("Collection has more than one element.")
    }
}

/**
 * Returns the single character matching the given [predicate], or throws exception if there is no or more than one matching character.
 */
public inline fun CharSequence.single(predicate: (Char) -> Boolean): Char {
    var single: Char? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Collection contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Collection doesn't contain any element matching predicate.")
    return single as Char
}

/**
 * Returns single character, or `null` if the char sequence is empty or has more than one character.
 */
public fun CharSequence.singleOrNull(): Char? {
    return if (length == 1) this[0] else null
}

/**
 * Returns the single character matching the given [predicate], or `null` if character was not found or more than one character was found.
 */
public inline fun CharSequence.singleOrNull(predicate: (Char) -> Boolean): Char? {
    var single: Char? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/**
 * Returns a subsequence of this char sequence with the first [n] characters removed.
 */
public fun CharSequence.drop(n: Int): CharSequence {
    require(n >= 0, { "Requested character count $n is less than zero." })
    return subSequence(n.coerceAtMost(length), length)
}

/**
 * Returns a string with the first [n] characters removed.
 */
public fun String.drop(n: Int): String {
    require(n >= 0, { "Requested character count $n is less than zero." })
    return substring(n.coerceAtMost(length))
}

/**
 * Returns a subsequence of this char sequence with the last [n] characters removed.
 */
public fun CharSequence.dropLast(n: Int): CharSequence {
    require(n >= 0, { "Requested character count $n is less than zero." })
    return take((length - n).coerceAtLeast(0))
}

/**
 * Returns a string with the last [n] characters removed.
 */
public fun String.dropLast(n: Int): String {
    require(n >= 0, { "Requested character count $n is less than zero." })
    return take((length - n).coerceAtLeast(0))
}

/**
 * Returns a subsequence of this char sequence containing all characters except last characters that satisfy the given [predicate].
 */
public inline fun CharSequence.dropLastWhile(predicate: (Char) -> Boolean): CharSequence {
    for (index in this.indices.reversed())
        if (!predicate(this[index]))
            return subSequence(0, index + 1)
    return ""
}

/**
 * Returns a string containing all characters except last characters that satisfy the given [predicate].
 */
public inline fun String.dropLastWhile(predicate: (Char) -> Boolean): String {
    for (index in this.indices.reversed())
        if (!predicate(this[index]))
            return substring(0, index + 1)
    return ""
}

/**
 * Returns a subsequence of this char sequence containing all characters except first characters that satisfy the given [predicate].
 */
public inline fun CharSequence.dropWhile(predicate: (Char) -> Boolean): CharSequence {
    for (index in this.indices)
        if (!predicate(this[index]))
            return subSequence(index, length)
    return ""
}

/**
 * Returns a string containing all characters except first characters that satisfy the given [predicate].
 */
public inline fun String.dropWhile(predicate: (Char) -> Boolean): String {
    for (index in this.indices)
        if (!predicate(this[index]))
            return substring(index)
    return ""
}

/**
 * Returns a char sequence containing only those characters from the original char sequence that match the given [predicate].
 */
public inline fun CharSequence.filter(predicate: (Char) -> Boolean): CharSequence {
    return filterTo(StringBuilder(), predicate)
}

/**
 * Returns a string containing only those characters from the original string that match the given [predicate].
 */
public inline fun String.filter(predicate: (Char) -> Boolean): String {
    return filterTo(StringBuilder(), predicate).toString()
}

/**
 * Returns a char sequence containing only those characters from the original char sequence that match the given [predicate].
 */
public inline fun CharSequence.filterIndexed(predicate: (Int, Char) -> Boolean): CharSequence {
    return filterIndexedTo(StringBuilder(), predicate)
}

/**
 * Returns a string containing only those characters from the original string that match the given [predicate].
 */
public inline fun String.filterIndexed(predicate: (Int, Char) -> Boolean): String {
    return filterIndexedTo(StringBuilder(), predicate).toString()
}

/**
 * Appends all characters matching the given [predicate] to the given [destination].
 */
public inline fun <C : Appendable> CharSequence.filterIndexedTo(destination: C, predicate: (Int, Char) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.append(element)
    }
    return destination
}

/**
 * Returns a char sequence containing only those characters from the original char sequence that do not match the given [predicate].
 */
public inline fun CharSequence.filterNot(predicate: (Char) -> Boolean): CharSequence {
    return filterNotTo(StringBuilder(), predicate)
}

/**
 * Returns a string containing only those characters from the original string that do not match the given [predicate].
 */
public inline fun String.filterNot(predicate: (Char) -> Boolean): String {
    return filterNotTo(StringBuilder(), predicate).toString()
}

/**
 * Appends all characters not matching the given [predicate] to the given [destination].
 */
public inline fun <C : Appendable> CharSequence.filterNotTo(destination: C, predicate: (Char) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.append(element)
    return destination
}

/**
 * Appends all characters matching the given [predicate] to the given [destination].
 */
public inline fun <C : Appendable> CharSequence.filterTo(destination: C, predicate: (Char) -> Boolean): C {
    for (index in 0..length - 1) {
        val element = get(index)
        if (predicate(element)) destination.append(element)
    }
    return destination
}

/**
 * Returns a char sequence containing characters of the original char sequence at the specified range of [indices].
 */
public fun CharSequence.slice(indices: IntRange): CharSequence {
    if (indices.isEmpty()) return ""
    return subSequence(indices)
}

/**
 * Returns a string containing characters of the original string at the specified range of [indices].
 */
public fun String.slice(indices: IntRange): String {
    if (indices.isEmpty()) return ""
    return substring(indices)
}

/**
 * Returns a char sequence containing characters of the original char sequence at specified [indices].
 */
public fun CharSequence.slice(indices: Iterable<Int>): CharSequence {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return ""
    val result = StringBuilder(size)
    for (i in indices) {
        result.append(get(i))
    }
    return result
}

/**
 * Returns a string containing characters of the original string at specified [indices].
 */
@kotlin.internal.InlineOnly
public inline fun String.slice(indices: Iterable<Int>): String {
    return (this as CharSequence).slice(indices).toString()
}

/**
 * Returns a subsequence of this char sequence containing the first [n] characters from this char sequence, or the entire char sequence if this char sequence is shorter.
 */
public fun CharSequence.take(n: Int): CharSequence {
    require(n >= 0, { "Requested character count $n is less than zero." })
    return subSequence(0, n.coerceAtMost(length))
}

/**
 * Returns a string containing the first [n] characters from this string, or the entire string if this string is shorter.
 */
public fun String.take(n: Int): String {
    require(n >= 0, { "Requested character count $n is less than zero." })
    return substring(0, n.coerceAtMost(length))
}

/**
 * Returns a subsequence of this char sequence containing the last [n] characters from this char sequence, or the entire char sequence if this char sequence is shorter.
 */
public fun CharSequence.takeLast(n: Int): CharSequence {
    require(n >= 0, { "Requested character count $n is less than zero." })
    val length = length
    return subSequence(length - n.coerceAtMost(length), length)
}

/**
 * Returns a string containing the last [n] characters from this string, or the entire string if this string is shorter.
 */
public fun String.takeLast(n: Int): String {
    require(n >= 0, { "Requested character count $n is less than zero." })
    val length = length
    return substring(length - n.coerceAtMost(length))
}

/**
 * Returns a subsequence of this char sequence containing last characters that satisfy the given [predicate].
 */
public inline fun CharSequence.takeLastWhile(predicate: (Char) -> Boolean): CharSequence {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return subSequence(index + 1, length)
        }
    }
    return subSequence(0, length)
}

/**
 * Returns a string containing last characters that satisfy the given [predicate].
 */
public inline fun String.takeLastWhile(predicate: (Char) -> Boolean): String {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return substring(index + 1)
        }
    }
    return this
}

/**
 * Returns a subsequence of this char sequence containing the first characters that satisfy the given [predicate].
 */
public inline fun CharSequence.takeWhile(predicate: (Char) -> Boolean): CharSequence {
    for (index in 0..length - 1)
        if (!predicate(get(index))) {
            return subSequence(0, index)
        }
    return subSequence(0, length)
}

/**
 * Returns a string containing the first characters that satisfy the given [predicate].
 */
public inline fun String.takeWhile(predicate: (Char) -> Boolean): String {
    for (index in 0..length - 1)
        if (!predicate(get(index))) {
            return substring(0, index)
        }
    return this
}

/**
 * Returns a char sequence with characters in reversed order.
 */
public fun CharSequence.reversed(): CharSequence {
    return StringBuilder(this).reverse()
}

/**
 * Returns a string with characters in reversed order.
 */
@kotlin.internal.InlineOnly
public inline fun String.reversed(): String {
    return (this as CharSequence).reversed().toString()
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to characters of the given char sequence.
 * If any of two pairs would have the same key the last one gets added to the map.
 */
public inline fun <K, V> CharSequence.associate(transform: (Char) -> Pair<K, V>): Map<K, V> {
    @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
    val capacity = mapCapacity(length).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing the characters from the given char sequence indexed by the key
 * returned from [keySelector] function applied to each character.
 * If any two characters would have the same key returned by [keySelector] the last one gets added to the map.
 */
public inline fun <K> CharSequence.associateBy(keySelector: (Char) -> K): Map<K, Char> {
    @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
    val capacity = mapCapacity(length).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Char>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to characters of the given char sequence.
 * If any two characters would have the same key returned by [keySelector] the last one gets added to the map.
 */
public inline fun <K, V> CharSequence.associateBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, V> {
    @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
    val capacity = mapCapacity(length).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each character of the given char sequence
 * and value is the character itself.
 * If any two characters would have the same key returned by [keySelector] the last one gets added to the map.
 */
public inline fun <K, M : MutableMap<in K, in Char>> CharSequence.associateByTo(destination: M, keySelector: (Char) -> K): M {
    for (element in this) {
        destination.put(keySelector(element), element)
    }
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to characters of the given char sequence.
 * If any two characters would have the same key returned by [keySelector] the last one gets added to the map.
 */
public inline fun <K, V, M : MutableMap<in K, in V>> CharSequence.associateByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
    for (element in this) {
        destination.put(keySelector(element), valueTransform(element))
    }
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each character of the given char sequence.
 * If any of two pairs would have the same key the last one gets added to the map.
 */
public inline fun <K, V, M : MutableMap<in K, in V>> CharSequence.associateTo(destination: M, transform: (Char) -> Pair<K, V>): M {
    for (element in this) {
        destination += transform(element)
    }
    return destination
}

/**
 * Appends all characters to the given [destination] collection.
 */
public fun <C : MutableCollection<in Char>> CharSequence.toCollection(destination: C): C {
    for (item in this) {
        destination.add(item)
    }
    return destination
}

/**
 * Returns a [HashSet] of all characters.
 */
public fun CharSequence.toHashSet(): HashSet<Char> {
    return toCollection(HashSet<Char>(mapCapacity(length)))
}

/**
 * Returns a [List] containing all characters.
 */
public fun CharSequence.toList(): List<Char> {
    return when (length) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> this.toMutableList()
    }
}

/**
 * Returns a [MutableList] filled with all characters of this char sequence.
 */
public fun CharSequence.toMutableList(): MutableList<Char> {
    return toCollection(ArrayList<Char>(length))
}

/**
 * Returns a [Set] of all characters.
 */
public fun CharSequence.toSet(): Set<Char> {
    return toCollection(LinkedHashSet<Char>(mapCapacity(length)))
}

/**
 * Returns a [SortedSet] of all characters.
 */
public fun CharSequence.toSortedSet(): SortedSet<Char> {
    return toCollection(TreeSet<Char>())
}

/**
 * Returns a single list of all elements yielded from results of [transform] function being invoked on each character of original char sequence.
 */
public inline fun <R> CharSequence.flatMap(transform: (Char) -> Iterable<R>): List<R> {
    return flatMapTo(ArrayList<R>(), transform)
}

/**
 * Appends all elements yielded from results of [transform] function being invoked on each character of original char sequence, to the given [destination].
 */
public inline fun <R, C : MutableCollection<in R>> CharSequence.flatMapTo(destination: C, transform: (Char) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/**
 * Groups characters of the original char sequence by the key returned by the given [keySelector] function
 * applied to each character and returns a map where each group key is associated with a list of corresponding characters.
 * @sample test.collections.CollectionTest.groupBy
 */
public inline fun <K> CharSequence.groupBy(keySelector: (Char) -> K): Map<K, List<Char>> {
    return groupByTo(LinkedHashMap<K, MutableList<Char>>(), keySelector)
}

/**
 * Groups values returned by the [valueTransform] function applied to each character of the original char sequence
 * by the key returned by the given [keySelector] function applied to the character
 * and returns a map where each group key is associated with a list of corresponding values.
 * @sample test.collections.CollectionTest.groupByKeysAndValues
 */
public inline fun <K, V> CharSequence.groupBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, List<V>> {
    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
}

/**
 * Groups characters of the original char sequence by the key returned by the given [keySelector] function
 * applied to each character and puts to the [destination] map each group key associated with a list of corresponding characters.
 * @return The [destination] map.
 * @sample test.collections.CollectionTest.groupBy
 */
public inline fun <K, M : MutableMap<in K, MutableList<Char>>> CharSequence.groupByTo(destination: M, keySelector: (Char) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Char>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each character of the original char sequence
 * by the key returned by the given [keySelector] function applied to the character
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * @return The [destination] map.
 * @sample test.collections.CollectionTest.groupByKeysAndValues
 */
public inline fun <K, V, M : MutableMap<in K, MutableList<V>>> CharSequence.groupByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Returns a list containing the results of applying the given [transform] function
 * to each character in the original char sequence.
 */
public inline fun <R> CharSequence.map(transform: (Char) -> R): List<R> {
    return mapTo(ArrayList<R>(length), transform)
}

/**
 * Returns a list containing the results of applying the given [transform] function
 * to each character and its index in the original char sequence.
 */
public inline fun <R> CharSequence.mapIndexed(transform: (Int, Char) -> R): List<R> {
    return mapIndexedTo(ArrayList<R>(length), transform)
}

/**
 * Returns a list containing only the non-null results of applying the given [transform] function
 * to each character and its index in the original char sequence.
 */
public inline fun <R : Any> CharSequence.mapIndexedNotNull(transform: (Int, Char) -> R?): List<R> {
    return mapIndexedNotNullTo(ArrayList<R>(), transform)
}

/**
 * Applies the given [transform] function to each character and its index in the original char sequence
 * and appends only the non-null results to the given [destination].
 */
public inline fun <R : Any, C : MutableCollection<in R>> CharSequence.mapIndexedNotNullTo(destination: C, transform: (Int, Char) -> R?): C {
    forEachIndexed { index, element -> transform(index, element)?.let { destination.add(it) } }
    return destination
}

/**
 * Applies the given [transform] function to each character and its index in the original char sequence
 * and appends the results to the given [destination].
 */
public inline fun <R, C : MutableCollection<in R>> CharSequence.mapIndexedTo(destination: C, transform: (Int, Char) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}

/**
 * Returns a list containing only the non-null results of applying the given [transform] function
 * to each character in the original char sequence.
 */
public inline fun <R : Any> CharSequence.mapNotNull(transform: (Char) -> R?): List<R> {
    return mapNotNullTo(ArrayList<R>(), transform)
}

/**
 * Applies the given [transform] function to each character in the original char sequence
 * and appends only the non-null results to the given [destination].
 */
public inline fun <R : Any, C : MutableCollection<in R>> CharSequence.mapNotNullTo(destination: C, transform: (Char) -> R?): C {
    forEach { element -> transform(element)?.let { destination.add(it) } }
    return destination
}

/**
 * Applies the given [transform] function to each character of the original char sequence
 * and appends the results to the given [destination].
 */
public inline fun <R, C : MutableCollection<in R>> CharSequence.mapTo(destination: C, transform: (Char) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}

/**
 * Returns a lazy [Iterable] of [IndexedValue] for each character of the original char sequence.
 */
public fun CharSequence.withIndex(): Iterable<IndexedValue<Char>> {
    return IndexingIterable { iterator() }
}

/**
 * Returns `true` if all characters match the given [predicate].
 */
public inline fun CharSequence.all(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/**
 * Returns `true` if char sequence has at least one character.
 */
public fun CharSequence.any(): Boolean {
    for (element in this) return true
    return false
}

/**
 * Returns `true` if at least one character matches the given [predicate].
 */
public inline fun CharSequence.any(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/**
 * Returns the length of this char sequence.
 */
@kotlin.internal.InlineOnly
public inline fun CharSequence.count(): Int {
    return length
}

/**
 * Returns the number of characters matching the given [predicate].
 */
public inline fun CharSequence.count(predicate: (Char) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each character.
 */
public inline fun <R> CharSequence.fold(initial: R, operation: (R, Char) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each character with its index in the original char sequence.
 */
public inline fun <R> CharSequence.foldIndexed(initial: R, operation: (Int, R, Char) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left to each character and current accumulator value.
 */
public inline fun <R> CharSequence.foldRight(initial: R, operation: (Char, R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each character with its index in the original char sequence and current accumulator value.
 */
public inline fun <R> CharSequence.foldRightIndexed(initial: R, operation: (Int, Char, R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Performs the given [action] on each character.
 */
public inline fun CharSequence.forEach(action: (Char) -> Unit): Unit {
    for (element in this) action(element)
}

/**
 * Performs the given [action] on each character, providing sequential index with the character.
 */
public inline fun CharSequence.forEachIndexed(action: (Int, Char) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/**
 * Returns the largest character or `null` if there are no characters.
 */
public fun CharSequence.max(): Char? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/**
 * Returns the first character yielding the largest value of the given function or `null` if there are no characters.
 */
public inline fun <R : Comparable<R>> CharSequence.maxBy(selector: (Char) -> R): Char? {
    if (isEmpty()) return null
    var maxElem = this[0]
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/**
 * Returns the first character having the largest value according to the provided [comparator] or `null` if there are no characters.
 */
public fun CharSequence.maxWith(comparator: Comparator<in Char>): Char? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/**
 * Returns the smallest character or `null` if there are no characters.
 */
public fun CharSequence.min(): Char? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/**
 * Returns the first character yielding the smallest value of the given function or `null` if there are no characters.
 */
public inline fun <R : Comparable<R>> CharSequence.minBy(selector: (Char) -> R): Char? {
    if (isEmpty()) return null
    var minElem = this[0]
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/**
 * Returns the first character having the smallest value according to the provided [comparator] or `null` if there are no characters.
 */
public fun CharSequence.minWith(comparator: Comparator<in Char>): Char? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/**
 * Returns `true` if the char sequence has no characters.
 */
public fun CharSequence.none(): Boolean {
    for (element in this) return false
    return true
}

/**
 * Returns `true` if no characters match the given [predicate].
 */
public inline fun CharSequence.none(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/**
 * Accumulates value starting with the first character and applying [operation] from left to right to current accumulator value and each character.
 */
public inline fun CharSequence.reduce(operation: (Char, Char) -> Char): Char {
    if (isEmpty())
        throw UnsupportedOperationException("Empty char sequence can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}

/**
 * Accumulates value starting with the first character and applying [operation] from left to right
 * to current accumulator value and each character with its index in the original char sequence.
 */
public inline fun CharSequence.reduceIndexed(operation: (Int, Char, Char) -> Char): Char {
    if (isEmpty())
        throw UnsupportedOperationException("Empty char sequence can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(index, accumulator, this[index])
    }
    return accumulator
}

/**
 * Accumulates value starting with last character and applying [operation] from right to left to each character and current accumulator value.
 */
public inline fun CharSequence.reduceRight(operation: (Char, Char) -> Char): Char {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty iterable can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

/**
 * Accumulates value starting with last character and applying [operation] from right to left
 * to each character with its index in the original char sequence and current accumulator value.
 */
public inline fun CharSequence.reduceRightIndexed(operation: (Int, Char, Char) -> Char): Char {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty char sequence can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Returns the sum of all values produced by [selector] function applied to each character in the char sequence.
 */
public inline fun CharSequence.sumBy(selector: (Char) -> Int): Int {
    var sum: Int = 0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

/**
 * Returns the sum of all values produced by [selector] function applied to each character in the char sequence.
 */
public inline fun CharSequence.sumByDouble(selector: (Char) -> Double): Double {
    var sum: Double = 0.0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

/**
 * Splits the original char sequence into pair of char sequences,
 * where *first* char sequence contains characters for which [predicate] yielded `true`,
 * while *second* char sequence contains characters for which [predicate] yielded `false`.
 */
public inline fun CharSequence.partition(predicate: (Char) -> Boolean): Pair<CharSequence, CharSequence> {
    val first = StringBuilder()
    val second = StringBuilder()
    for (element in this) {
        if (predicate(element)) {
            first.append(element)
        } else {
            second.append(element)
        }
    }
    return Pair(first, second)
}

/**
 * Splits the original string into pair of strings,
 * where *first* string contains characters for which [predicate] yielded `true`,
 * while *second* string contains characters for which [predicate] yielded `false`.
 */
public inline fun String.partition(predicate: (Char) -> Boolean): Pair<String, String> {
    val first = StringBuilder()
    val second = StringBuilder()
    for (element in this) {
        if (predicate(element)) {
            first.append(element)
        } else {
            second.append(element)
        }
    }
    return Pair(first.toString(), second.toString())
}

/**
 * Returns a list of pairs built from characters of both char sequences with same indexes. List has length of shortest char sequence.
 */
public infix fun CharSequence.zip(other: CharSequence): List<Pair<Char, Char>> {
    return zip(other) { c1, c2 -> c1 to c2 }
}

/**
 * Returns a list of values built from characters of both char sequences with same indexes using provided [transform]. List has length of shortest char sequence.
 */
public inline fun <V> CharSequence.zip(other: CharSequence, transform: (Char, Char) -> V): List<V> {
    val length = Math.min(this.length, other.length)
    val list = ArrayList<V>(length)
    for (i in 0..length-1) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Creates an [Iterable] instance that wraps the original char sequence returning its characters when being iterated.
 */
public fun CharSequence.asIterable(): Iterable<Char> {
    if (this is String && isEmpty()) return emptyList()
    return Iterable { this.iterator() }
}

/**
 * Creates a [Sequence] instance that wraps the original char sequence returning its characters when being iterated.
 */
public fun CharSequence.asSequence(): Sequence<Char> {
    if (this is String && isEmpty()) return emptySequence()
    return Sequence { this.iterator() }
}

