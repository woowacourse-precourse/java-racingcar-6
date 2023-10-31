package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarNamesTest {

    @Test
    public void 차_이름_검증_테스트() {
        //given
        List<String> inputList = new ArrayList<>();

        String empty = "";
        String lastComma = "pobi,woni,jun,";
        String doubleComma = "pobi,woni,,jane";
        String firstComma = ",pobi,jason,min";
        String spaceNextToComma = "jane,pan, sang";
        String longNames = "minseong,pobi,woni";
        String duplicatedNames = "pobi,woni,woni,jason";

        inputList.add(empty);
        inputList.add(lastComma);
        inputList.add(doubleComma);
        inputList.add(firstComma);
        inputList.add(spaceNextToComma);
        inputList.add(longNames);
        inputList.add(duplicatedNames);

        //when
        //then
        for (String input : inputList) {
            Assertions.assertThatThrownBy(() -> {
                new CarNames(input);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

}
