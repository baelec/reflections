@file:JvmName("Predicates")

package org.reflections.predicates

import java.util.*
import java.util.function.Predicate

fun <T> and(predicates: Array<Predicate<in T>>): Predicate<T> {
  return Predicate { value -> Arrays.stream(predicates).allMatch { it.test(value)} }
}