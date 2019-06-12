@file:JvmName("Lists")

package org.reflections.collections

import java.util.*
import kotlin.collections.ArrayList

fun <T> newArrayList(): ArrayList<T> = newArrayList()

fun <T> newArrayList(iterable: Iterable<T>): ArrayList<T> = newArrayList(iterable)


fun <T> newArrayList(vararg values: T): ArrayList<T> {
  val list = arrayListOf<T>()
  for (value in values) {
    list.add(value)
  }
  return list
}

fun <T> newLinkedList(): LinkedList<T> = newLinkedList()

fun <T> newLinkedList(iterable: Iterable<T>): ArrayList<T> = newLinkedList(iterable)
