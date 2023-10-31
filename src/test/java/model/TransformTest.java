package model;

import static model.Transform.carNameToList;
import static model.Transform.resultListReset;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransformTest {
    @Test
    @DisplayName("쉼표로 구분된 string이 List에 저장되는가")
    void carNameToListTest() {
        //given
        String carName = "pobi,nana,popo";
        //when
        List<String> listCarName = new ArrayList<>(carNameToList(carName));
        //then
        assertThat(listCarName).contains("pobi", "nana", "popo");
    }

    @Test
    @DisplayName("List를 자동차 수만큼 0으로 초기화 하는가")
    void resultListResetTest() {
        //given
        int carNameSize = 4;
        List<Integer> raceResult = new ArrayList<>();
        List<Integer> expectedResult = Arrays.asList(0, 0, 0, 0);
        //when
        resultListReset(carNameSize, raceResult);
        //then
        assertThat(raceResult).isEqualTo(expectedResult);
    }
}