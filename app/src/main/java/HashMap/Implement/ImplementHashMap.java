package HashMap.Implement;

import HashMap.types.HashMap;

public class ImplementHashMap<V> {
  private final HashMap<V, Object> map = new HashMap<>();
  private static final Object PRESENT = new Object();


  public boolean add(V value) {
    return map.put(value, PRESENT) == null;
  }

  public boolean contains(Object obj) {
    return map.get((V) obj) != null;
  }

  @Override
  public String toString() {
    return map.toString();
  }
}
