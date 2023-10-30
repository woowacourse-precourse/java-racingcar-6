package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MapUtilsTest {

    @Test
    void 주어진_String_Integer_맵에서_최대_value_반환() {
        //given
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("phobi", 1);
        map1.put("woni", 2);
        //when
        int result = MapUtils.getMaxValue(map1);
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 일반화된_맵에서_최대_value_반환() {
        //given
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("phobi", "A");
        map2.put("woni", "Z");
        //when
        String result = MapUtils.getMaxValue(map2);
        //then
        assertThat(result).isEqualTo("Z");
    }

    @Test
    void 주어진_String_Integer_맵에서_최대_value_key_List_반환() {
        //given
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("phobi", 1);
        map3.put("woni", 2);
        map3.put("kim", 3);
        map3.put("seong", 3);
        map3.put("han", 3);
        //when
        List<String> result = MapUtils.getKeysForValue(map3, 3);
        //then
        assertThat(result).contains("kim", "seong", "han");
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 일반화된_맵에서_최대_value_key_List_반환() {
        //given
        HashMap<String, String> map4 = new HashMap<>();
        map4.put("phobi", "A");
        map4.put("woni", "Z");
        map4.put("kim", "K");
        map4.put("seong", "Z");
        map4.put("han", "B");
        //when
        List<String> result = MapUtils.getKeysForValue(map4, "Z");
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains("woni", "seong");
    }

}
