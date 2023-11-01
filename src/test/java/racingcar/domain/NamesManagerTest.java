package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesManagerTest {

    @Test
    void separateNamesString_이름_분리(){
        NamesManager manager = new NamesManager();

        List<String> nameList = manager.separateNamesString("pobi,woni,jun");
        assertThat(nameList).isEqualTo(Arrays.asList("pobi","woni","jun"));
    }
    @Test
    void checkNamesException_이름_길이(){
        NamesManager manager = new NamesManager();

        assertThatThrownBy(() -> manager.checkNamesException(Arrays.asList("pobi","pobiiii")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6 글자 이상인 이름이 있는지 확인해주세요.");
    }

    @Test
    void checkNamesException_이름_중복(){
        NamesManager manager = new NamesManager();

        assertThatThrownBy(() -> manager.checkNamesException(Arrays.asList("pobi","pobi","woni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 이름이 있는지 확인해주세요.");
    }

}