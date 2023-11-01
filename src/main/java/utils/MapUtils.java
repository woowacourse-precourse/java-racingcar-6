package utils;

import java.util.*;

public class MapUtils {
    public static <K, V extends Comparable<? super V>> V getMaxValue(Map<K, V> map) {
        return Collections.max(map.values());
    }

    public static <K, V> List<K> getKeysForValue(Map<K, V> map, V value) {
        List<K> keys = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
