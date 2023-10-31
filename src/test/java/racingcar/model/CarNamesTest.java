package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarNamesTest {

    @Test
    public void 이름_길이_검증_테스트() {
        //given
        List<String> inputList = new ArrayList<>();

        String NULL = "";
        String LAST_COMMA = "pobi,woni,jun,";
        String DOUBLE_COMMA = "pobi,woni,,jane";
        String FIRST_COMMA = ",pobi,jason,min";
        String SPACE_NEXT_TO_COMMA = "jane,pan, sang";
        String LONG_NAMES = "minseong,pobi,woni";
        String DUPLICATED_NAMES = "pobi,woni,woni,jason";

        inputList.add(NULL);
        inputList.add(LAST_COMMA);
        inputList.add(DOUBLE_COMMA);
        inputList.add(FIRST_COMMA);
        inputList.add(SPACE_NEXT_TO_COMMA);
        inputList.add(LONG_NAMES);
        inputList.add(DUPLICATED_NAMES);

        //when
        //then
        for (String input : inputList) {
            Assertions.assertThatThrownBy(() -> {
                new CarNames(input);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

}
