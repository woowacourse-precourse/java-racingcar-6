package model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static model.ValidateRacingValue.carNameInputToList;
import static model.ValidateRacingValue.validateRacingResult;
import static model.ValidateRacingValue.validateRandomMoreFour;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateRacingValueTest extends NsTest {
    static final int FOWARDVALUE = 4;
    static final int STOPVALUE = 3;
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
    @DisplayName("랜덤 추출한 수가 4이상이면 true를 반환하는가")
    @Test
    void validateRandomMoreFourTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(validateRandomMoreFour()).isEqualTo(true);
                },
                FOWARDVALUE
        );
    }
    @DisplayName("추가된 레이싱 결과값이 List에 저장되는가")
    @Test
    void validateRacingResultTest() {
        List<String> carName = Arrays.asList("pobi", "nana");
        List<Integer> raceResult = Arrays.asList(1, 3);
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    List<Integer> testResult = new ArrayList<>(List.of(2, 3));
                    assertThat(validateRacingResult(carName, raceResult)).isEqualTo(testResult);
                },FOWARDVALUE, STOPVALUE
        );
    }
    @Override
    public void runMain() {
    }
}