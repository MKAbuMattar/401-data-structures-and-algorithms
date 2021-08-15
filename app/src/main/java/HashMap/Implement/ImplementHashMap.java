package HashMap.Implement;

import HashMap.types.HashMap;

public class ImplementHashMap<V> {
  private HashMap<V, Object> table = new HashMap<>();
  private static final Object PRESENT = new Object();


  public boolean add(V value) {
    return table.put(value, PRESENT) == null;
  }

  public boolean contains(Object obj) {
    return table.get((V) obj) != null;
  }

  @Override
  public String toString() {
    return table.toString();
  }
}
