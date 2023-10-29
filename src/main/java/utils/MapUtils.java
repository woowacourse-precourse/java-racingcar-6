package utils;

import java.util.Collections;
import java.util.Map;

public class <K, V extends Comparable<? super V>> Happy {
    public static V getMaxVaule(Map<K, V> map) {
        return Collections.max(map.values());
    }

//    public static <K, V extends Comparable<? super V>> getKeysForValue(Map<K, V> map, V value) {
//
//        return
//    }
}
