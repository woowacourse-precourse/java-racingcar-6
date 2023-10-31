package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import racingcar.controller.CarRaceGame;
import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

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
    @DisplayName("게임시도횟수 테스트")
    class AttemptNumberTest {
        @ParameterizedTest
        @ValueSource(strings = {"a",",","!"})
        @DisplayName("게임시도횟수 입력이 숫자인지 테스트한다.")
        void 시도횟수_숫자_테스트(String roundNumber) {
            Assertions.assertThatThrownBy(
                    () -> Validator.isNumber(roundNumber)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0","-1"})
        @DisplayName("게임시도횟수가 1이상인지 테스트한다.")
        void 시도횟수_범위_테스트(String roundNumber) {
            Assertions.assertThatThrownBy(
                    () -> Validator.attemptNumberRange(roundNumber)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }



    @Nested
    @DisplayName("전진 테스트")
    class MoveTest {
        @ParameterizedTest
        @ValueSource(ints = {0, 5, 9})
        @DisplayName("랜덤 숫자가 0~9범위면 테스트를 통과한다.")
        void 랜덤_함수_예외_테스트(int randomNumber) {
            Assertions.assertThatCode(
                    () -> Validator.randomNumberRange(randomNumber)
            ).doesNotThrowAnyException();

        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 10})
        @DisplayName("랜덤 숫자가 0~9범위가 아니면 테스트를 통과하지 못한다.")
        void 랜덤_함수_예외_테스트1(int randomNumber) {
            Assertions.assertThatThrownBy(
                    () -> Validator.randomNumberRange(randomNumber)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource(value = {"3,true","4,true","5,false"})
        @DisplayName("4이하에만 이동할지 결정하는 지 테스트")
        void 이동_결정_테스트(int randomNumber, boolean result) {
            Assertions.assertThat(Car.decideToMove(randomNumber)).isEqualTo(result);
        }


    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
