package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.CarRaceGame;

public class myApplicationTest extends NsTest {
    @Nested
    @DisplayName("자동차 이름 테스트")
    class CarNameTest {
        @ParameterizedTest
        @ValueSource(strings = {",","Alice,Bob,,Carol", "Alice,Bob,Carol,"})
        @DisplayName("자동차 전체이름을 예외처리를 테스트한다.")
        void 자동차전체이름예외처리테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> Validator.carNamesComma(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }
        @ParameterizedTest
        @ValueSource(strings = {"Alice,Bob,Catarina"})
        @DisplayName("자동차 이름들이 5글자 이상인지 테스트한다.")
        void 자동차이름분리후_5글자_이하인지_테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> CarRaceGame.CarNamesToList(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"Alice,Bob,,Carol"})
        @DisplayName("자동차 이름의 공백 예외처리를 테스트한다.")
        void 자동차_이름_공백_테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> CarRaceGame.CarNamesToList(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("게임횟수 테스트")
    class AttemptNumberTest {
        @ParameterizedTest
        @ValueSource(strings = {"a", "-1"})
        @DisplayName("게임시도횟수 입력을 테스트한다.")
        void 시도횟수테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> runException(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
