package org.reflections.collections

import java.util.*

class Multimap<K, V> {
  private val map = HashMap<K, MutableSet<V>>()
  fun get(key: K) : Set<V>? = map[key]
  fun put(key: K, value: V) {
    map.getOrPut(key, { HashSet() }).add(value)
  }

  fun asMap(): Map<K, Collection<V>> = map

  fun size() = map.size

  fun isEmpty() = map.isEmpty()
  fun keySet(): Set<K> {
    return map.keys
  }

  fun entries() = map.entries
}