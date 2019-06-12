@file:JvmName("ObjectArrays")

package org.reflections.collections

public inline fun <T> concat(a0: Array<T>, a1: Array<T>): ArrayList<out T>? {
  val a2 = arrayListOf(*a0)
  a2.addAll(a1)
  return a2
}