package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Referee;
import racingcar.model.Validator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;

import static constant.MessgeList.MOVING_FORWARD;
import static constant.MessgeList.STOP;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private Validator validator;
    private Car car;
    private Referee referee;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        car = new Car();
        referee = new Referee(new int[]{5, 4, 5});
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("입력받은 자동차이름들이 콤마를 기준으로 5자이하가 아니면 IllegalArgumentException 발생시키기")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji", "pobiaa,woni,jun"})
    void isCarNameFromPlayerValidate(String carName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.isCarNameFromPlayerValidate(carName))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력받은 시도할 횟수가 숫자가 아니면 IllegalArgumentException 발생시키기")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1.2"})
    void isNumberFromPlayerValidate(String number) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.isNumberFromPlayerValidate(number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("random값이 0과 9사이의 숫자여야 한다.")
    void isRandomNumberInRange() {
        int randomNumber = car.generateRandomNumber();
        assertEquals(randomNumber, 0, 9);
    }

    @Test
    @DisplayName("최댓값을 가진 배열의 인덱스값을 반환한다")
    void getIndexOfMaxDistanceOfCars() {
        int[] maxIndexArray = referee.getIndexOfMaxDistanceOfCars();
        assertThat(maxIndexArray).isEqualTo(new int[]{0, 2});
    }

    @Test
    @DisplayName("우승자 이름이 담긴 배열을 반환한다")
    void getWinner() {
        String[] winners = referee.getWinner(new ArrayList<>(Arrays.asList("pobi", "woni", "jun")));
        assertThat(winners).isEqualTo(new String[]{"pobi", "jun"});
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
