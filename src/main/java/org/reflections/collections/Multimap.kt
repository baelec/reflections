package org.reflections.collections

import java.util.*

class Multimap<K, V> {
  protected val map = HashMap<K, MutableSet<V>>()
  fun get(key: K) : Set<V>? = map[key]
  fun put(key: K, value: V): Boolean {
    val submap = map.getOrPut(key, { HashSet() })
    val origSize = submap.size
    submap.add(value)
    return origSize != submap.size
  }

  fun asMap(): Map<K, Collection<V>> = map

  fun size() = map.size

  fun isEmpty() = map.isEmpty()
  fun keySet(): Set<K> {
    return map.keys ?: emptySet()
  }

  fun values(): Collection<V> {
    val list = arrayListOf<V>()
    for (value in this.map.values) {
      list.addAll(value)
    }
    return list
  }

  fun entries(): Collection<Map.Entry<K, V>> {
    val list = arrayListOf<Map.Entry<K, V>>()
    this.map.entries.forEach { topEntry ->
      val key = topEntry.key
      val values = topEntry.value
      values.forEach {value ->
        val entry = object : Map.Entry<K, V> {
          override val key: K = key
          override val value: V = value
        }
        list.add(entry)
      }
    }

    return list
  }

  fun putAll(mmap: Multimap<K, V>) {
    mmap.map.forEach { t, u ->
      this.map.put(t, u)
    }
  }
}

class HashMultimap<K, V> {
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

  fun values(): Collection<V> {
    val list = arrayListOf<V>()
    for (value in this.map.values) {
      list.addAll(value)
    }
    return list
  }
}