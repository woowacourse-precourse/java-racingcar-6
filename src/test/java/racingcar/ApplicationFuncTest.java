package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationFuncTest {

    @DisplayName("차 이름 구하기")
    @Test
    public void getCarNamesTest() {
        String carName = "pobi,woni,jun";
        String[] getCarNames = Application.getCarNames(carName);
        String[] ArrayCarNames = {"pobi", "woni", "jun"};
        assertThat(getCarNames).isEqualTo(ArrayCarNames);
    }

    @DisplayName("경주 시도 횟수 한글로 작성한 경우 테스트")
    @Test
    public void getNumAttemptsTest() {

        String input = "일이삼";
        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            Application.getNumAttempts(input);
        });

        assertEquals("숫자로 입력해주세요", exception.getMessage());
    }

    @DisplayName("Race 해보기")
    @Test
    public void RaceTest() {
        String[] carNames = {"pobi", "woni", "jun"};
        int[] carPositions = {0, 0, 0};
        int numAttempts = 3;
        Application.Race(carNames, carPositions, numAttempts);
    }




}
