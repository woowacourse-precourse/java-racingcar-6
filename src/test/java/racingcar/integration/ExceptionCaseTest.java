package racingcar.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.integration.config.IntegrationTest;

class ExceptionCaseTest extends IntegrationTest {

    @Nested
    @DisplayName("경주할 자동차 이름 입력 시")
    class Invalid_RacingCarNames {

        @DisplayName("비었거나, 공백이라면 예외를 발생시킨다.")
        @ValueSource(strings = {" ", "", "\n", "\r", "\t"})
        @ParameterizedTest
        void Fail_EmptyInput(String racingCarName) {
            //given
            String turnsCount = "1";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("입력의 최대 문자열 길이를 넘는다면 예외를 발생시킨다.")
        @Test
        void Fail_OverMaxInputLength() {
            //given
            char[] ch = new char[599 + 1];
            Arrays.fill(ch, 'a');
            String racingCarName = String.valueOf(ch);
            String turnsCount = "1";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("알파벳과 숫자, 쉼표 이외 문자가 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"valid,3 4", "fd$,valid", "inv\n,valid"})
        @ParameterizedTest
        void Fail_InvalidInputFormat(String racingCarName) {
            //given
            String turnsCount = "1";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("이름에 중복이 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"a,a", "1,2,3,1"})
        @ParameterizedTest
        void Fail_DuplicatedName(String racingCarName) {
            //given
            String turnsCount = "1";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("경주할 자동차의 개수가 최대 경주 가능한 자동차 개수를 넘는다면 예외를 발생시킨다.")
        @Test
        void Fail_OverRacingCarMaxSize() {
            //given
            int size = 101;
            List<String> racingCarList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                racingCarList.add(String.valueOf(i));
            }
            String racingCarName = String.join(",", racingCarList);
            String turnsCount = "1";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("5자가 넘는다면 예외를 발생시킨다.")
        @ValueSource(strings = {"123456", "1234566"})
        @ParameterizedTest
        void Fail_OverRacingCarNameMaxLength(String racingCarName) {
            //given
            String turnsCount = "1";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 시")
    class Invalid_TurnsCount {

        @DisplayName("비었거나, 공백이라면 예외를 발생시킨다.")
        @ValueSource(strings = {" ", "\n", "\r", "\t"})
        @ParameterizedTest
        void Fail_EmptyInput(String turnsCount) {
            //given
            String racingCarName = "1,3";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("입력의 최대 문자열 길이를 넘는다면 예외를 발생시킨다.")
        @Test
        void Fail_OverMaxInputLength() {
            //given
            String racingCarName = "1,3";
            String turnsCount = "10000";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("숫자 이외 문자가 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"1 00", "39g9", "10(0"})
        @ParameterizedTest
        void Fail_InvalidInputFormat(String turnsCount) {
            //given
            String racingCarName = "1,3";

            // when then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(racingCarName, turnsCount))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}
