package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {
    @Test
    public void arrayList_단위테스트() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("1");
        list.add("2");
        list2.add("new");
        list2.add("word");
        assertThat(list.add("3")).isEqualTo(true);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.contains("4")).isEqualTo(false);
        assertThat(list.get(0)).isEqualTo("1");
        assertThat(list.set(0, "5")).isEqualTo("1");
        assertThat(list.remove(0)).isEqualTo("5");
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.addAll(1, list2)).isEqualTo(true);
        assertThat(list.hashCode() == list.hashCode()).isEqualTo(true);
        assertThat(list.hashCode() == list2.hashCode()).isEqualTo(false);
        assertThat(list.toArray()).isEqualTo(new String[]{"2", "new", "word", "3"});
        assertThat(list2.stream().map(s -> s + "1")).isEqualTo(new ArrayList<String>(Arrays.asList(new String[]{"new1", "word1"})));
    }
}
