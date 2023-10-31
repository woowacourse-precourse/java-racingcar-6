package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.CarRaceGame;
import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class myApplicationTest {
    @Nested
    @DisplayName("자동차 이름 테스트")
    class CarNameTest {
        @ParameterizedTest
        @ValueSource(strings = {",","Alice,Bob,,Carol", "Alice,Bob,Carol,"})
        @DisplayName("자동차 전체이름을 예외처리를 테스트한다.")
        void 자동차전체이름예외처리테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> Validator.checkCarNamesForm(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }
        @ParameterizedTest
        @ValueSource(strings = {"Alice,Bob,Catarina"})
        @DisplayName("자동차 이름들이 5글자 이상인지 테스트한다.")
        void 자동차이름분리후_5글자_이하인지_테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> CarRaceGame.makeCarNamesToList(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"Alice,Bob,,Carol"})
        @DisplayName("자동차 이름의 공백 예외처리를 테스트한다.")
        void 자동차_이름_공백_테스트(String carNames) {
            Assertions.assertThatThrownBy(
                    () -> CarRaceGame.makeCarNamesToList(carNames)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(Arrays.asList("Alice","Alice","Bob")));
        }

        @ParameterizedTest
        @MethodSource("generateData")
        @DisplayName("자동차 이름의 중복 예외처리를 테스트한다.")
        void 자동차_이름_중복_테스트(List<String> carNameList) {
            Assertions.assertThatThrownBy(
                    () -> Validator.checkCarNameDuplication(carNameList)
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
                    () -> Validator.isMoreThanOne(roundNumber)
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

    @Nested
    @DisplayName("전진한 상황 출력 테스트")
    class 전진_상황_출력_테스트{
        private static ByteArrayOutputStream outputMessage;
        @BeforeEach
        void setUpStreams() {
            outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
            System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
        }

        @AfterEach
        void restoresStreams() {
            System.setOut(System.out); // 원상복귀
        }
        @Test
        void 전진_상황_테스트() {
            CarRaceGameView.printOneRoundResult("Alice", 3);
            org.junit.jupiter.api.Assertions.assertEquals("Alice : ---\r\n", outputMessage.toString());
        }
    }

    @Nested
    @DisplayName("우승자 출력 테스트")
    class 우승자_출력_테스트{
        private static ByteArrayOutputStream outputMessage;
        @BeforeEach
        void setUpStreams() {
            outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
            System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
        }

        @AfterEach
        void restoresStreams() {
            System.setOut(System.out); // 원상복귀
        }

        static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(Arrays.asList("Alice"),"최종 우승자 : Alice\r\n"),
                    Arguments.of(Arrays.asList("Alice","Bob","Carol"),"최종 우승자 : Alice, Bob, Carol\r\n"));
        }


        @ParameterizedTest
        @MethodSource("generateData")
        void 우승자_출력_테스트(List<String> winnerList,String result) {
            CarRaceGameView.printGameResult(winnerList);
            org.junit.jupiter.api.Assertions.assertEquals(result, outputMessage.toString());
        }
    }

    @Nested
    @DisplayName("전체 실행 테스트")
    class runTest extends NsTest{
        private static final int MOVING_FORWARD = 4;
        private static final int STOP = 3;
        @Test
        @DisplayName("전체 실행 테스트")
        void 전체실행() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("Alice,Bob,Carol", "2");
                        assertThat(output()).contains("Alice : --", "Bob : -","Carol : -", "최종 우승자 : Alice");
                    },
                    MOVING_FORWARD, STOP,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,STOP
            );
        }
        @Override
        public void runMain() {
            Application.main(new String[]{});
        }
    }
}
