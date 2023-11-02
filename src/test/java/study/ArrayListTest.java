package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {

    private List<String> list;
    private List<String> list2;

    @BeforeEach
    @Test
    void init() {
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list.add("1");
        list.add("2");
        list2.add("new");
        list2.add("word");
    }

    @DisplayName("ArrayList 추가")
    @Test
    void arrayList_add_test() {
        assertThat(list.add("3")).isEqualTo(true);
    }

    @DisplayName("리스트 size 테스트")
    @Test
    void arrayList_size_test() {
        assertThat(list.size()).isEqualTo(2);
    }

    @DisplayName("리스트 get 테스트")
    @Test
    void arrayList_get_test() {
        assertThat(list.get(0)).isEqualTo("1");
    }

    @DisplayName("리스트 contains 테스트")
    @Test
    void arrayList_contains_test() {
        assertThat(list.contains("4")).isEqualTo(false);
    }


    @DisplayName("리스트 set 테스트")
    @Test
    void arrayList_set_test() {
        assertThat(list.set(0, "5")).isEqualTo("1");
    }

    @DisplayName("리스트 remove 테스트")
    @Test
    void arrayList_remove_test() {
        assertThat(list.remove(0)).isEqualTo("1");
    }

    @DisplayName("리스트 addall 테스트")
    @Test
    void arrayList_allAll_test() {
        assertThat(list.addAll(1, list2)).isEqualTo(true);
    }

    @DisplayName("리스트 hash 테스트")
    @Test
    void arrayList_hash_test() {
        assertThat(list.hashCode() == list.hashCode()).isTrue();
        assertThat(list.hashCode() == list2.hashCode()).isFalse();
    }

    @DisplayName("리스트 toArray 테스트")
    @Test
    void arrayList_toArray_test() {
        list.addAll(1,list2);
        assertThat(list.toArray()).isEqualTo(new String[]{"1", "new", "word", "2"});
    }


}
