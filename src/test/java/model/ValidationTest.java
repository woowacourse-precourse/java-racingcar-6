package model;

import static model.Validation.racingResult;
import static model.Validation.racingWinner;
import static model.Validation.randomMoreFour;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ValidationTest {
    @Test
    @DisplayName("숫자 랜덤 추출 기능이 작동하는가")
    void randomMoreFourTest() {
        //given
        //when
        boolean testResult = randomMoreFour();
        //then
        System.out.printf("랜덤 추출 기능 출력값 : %b \n", testResult);
    }

    @Test
    @DisplayName("추가된 레이싱 결과값이 List에 저장되는가")
    void racingResultTest() {
        //given
        List<String> carName = new ArrayList<>(List.of("pobi"));
        List<Integer> raceResult = new ArrayList<>(List.of(2));
        //when
        List<Integer> testList = racingResult(carName, raceResult);
        //then
        assertThat(testList.get(0)).isBetween(2, 3);
    }

    @Test
    @DisplayName("결과 값에 따라 우승자를 선정하는가")
    void racingWinnerTest() {
        //given
        List<String> carName = new ArrayList<>(Arrays.asList("pobi", "nana", "bubu", "lala"));
        List<Integer> raceResult = Arrays.asList(1, 4, 3, 4);
        //when
        List<String> testResult = racingWinner(carName, raceResult);
        //then
        assertThat(testResult).contains("nana", "lala");
    }
}