package study;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {
    @Test
    void HashMap_put_테스트() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("rukka", 1);

        assertThat(map.get("rukka")).isEqualTo(1);
    }

    @Test
    void HashMap_반복문_테스트() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("rukka", 1);
        map.put("choi", 2);
        map.put("jaemin", 3);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            assertThat(map.get(key)).isEqualTo(value);
        }
    }

    @Test
    void HashMap_replace_테스트() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("rukka", 1);
        map.replace("rukka", 2);

        assertThat(map.get("rukka")).isEqualTo(2);
    }
}
