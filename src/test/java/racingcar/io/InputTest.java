package racingcar.io;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputTest extends IOTest {
    @Test
    void set_testing_input() {
        testInput("배달이,동준이,민족이");
        setRegistryTest();
    }

    void setRegistryTest() {
        //given
        List<String> expectList = new ArrayList<>();
        expectList.add("배달이");
        expectList.add("동준이");
        expectList.add("민족이");
        //when
        List<String> test = InputView.setRegistry();
        //then
        Assertions.assertThat(test).isEqualTo(expectList);
    }
}