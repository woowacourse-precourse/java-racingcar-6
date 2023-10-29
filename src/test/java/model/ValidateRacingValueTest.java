package model;

import static model.ValidateRacingValue.carNameInputToList;
import static model.ValidateRacingValue.racingResult;
import static model.ValidateRacingValue.racingWinner;
import static model.ValidateRacingValue.randomMoreFour;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateRacingValueTest {
    @DisplayName("쉼표로 구분된 string이 List에 저장되는가")
    @Test
    void carNameInputToListTest() {
        //given
        String carName = "pobi,nana,popo";
        //when
        List<String> listCarName = new ArrayList<>(carNameInputToList(carName));
        //then
        assertThat(listCarName).contains("pobi", "nana", "popo");
    }
    @DisplayName("숫자 랜덤 추출 기능이 작동하는가")
    @Test
    void randomMoreFourTest() {
        //given
        //when
        boolean testResult = randomMoreFour();
        //then
        System.out.printf("랜덤 추출 기능 출력값 : %b \n", testResult);
    }
    @DisplayName("추가된 레이싱 결과값이 List에 저장되는가")
    @Test
    void racingResultTest() {
        //given
        List<String> carName = Arrays.asList("pobi", "nana");
        List<Integer> raceResult = Arrays.asList(1, 3);
        //when
        List<Integer> testList = racingResult(carName, raceResult);
        //then
        System.out.print("레이싱 결과 저장 기능 출력값 :");
        for(int result : testList) {
            System.out.printf("%d,", result);
        }
        System.out.println();
    }
    @DisplayName("결과 값에 따라 우승자를 선정하는가")
    @Test
    void racingWinnerTest() {
        //given
        List<String> carName = new ArrayList<>();
        carName.add("pobi");
        carName.add("nana");
        carName.add("bubu");
        carName.add("lala");
        List<Integer> raceResult = Arrays.asList(1, 4, 3, 4);
        //when
        List<String> testResult = racingWinner(carName, raceResult);
        //then
        assertThat(testResult).contains("nana", "lala");
    }
}