package racingcar.unit.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.config.RacingCarRule;
import racingcar.config.RandomMock;
import racingcar.game.RacingGameManager;
import racingcar.mock.MockRacingGameScreen;
import racingcar.util.Random;

class RacingGameManagerTest extends RandomMock {

    private final MockRacingGameScreen mockScreen = new MockRacingGameScreen(null, null);
    private final RacingGameManager racingGameManager = new RacingGameManager(mockScreen);

    @Nested
    @DisplayName("자동차 경주 게임을 성공적으로 수행한다.")
    class runSuccess {

        @DisplayName("우승자가 한 명 나오는 경우")
        @Test
        void singleWinner() {
            //given
            mockScreen.setRacingCarNames("car1,car2,car3");
            mockScreen.setTotalTurn("5");
            given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(
                    MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, STOP
            );

            //when
            racingGameManager.run();

            //then
            List<String> winnerNames = mockScreen.getWinnerNames();
            assertThat(winnerNames).hasSize(1)
                    .containsExactly("car1");
        }

        @DisplayName("우승자가 여러 명 나오는 경우")
        @Test
        void pluralWinners() {
            //given
            mockScreen.setRacingCarNames("car1,car2,car3,car4,car5,car6");
            mockScreen.setTotalTurn("5");
            given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(
                    MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
            );

            //when
            racingGameManager.run();

            //then
            List<String> winnerNames = mockScreen.getWinnerNames();
            assertThat(winnerNames).hasSize(4)
                    .containsExactly("car1", "car3", "car4", "car6");
        }
    }

    @Nested
    @DisplayName("경주할 자동차 이름 입력 시")
    class Invalid_RacingCarNames {

        @DisplayName("비었거나, 공백이라면 예외를 발생시킨다.")
        @ValueSource(strings = {" ", "", "\n", "\r", "\t"})
        @ParameterizedTest
        void fail_EmptyInput(String racingCarName) {
            //given
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력의 최대 문자열 길이를 넘는다면 예외를 발생시킨다.")
        @Test
        void fail_OverMaxInputLength() {
            //given
            char[] ch = new char[RacingCarRule.MAX_RACER_NAME_INPUT_LENGTH + 1];
            Arrays.fill(ch, 'a');
            String racingCarName = String.valueOf(ch);
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("알파벳과 숫자, 쉼표 이외 문자가 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"valid,3 4", "fd$,valid", "in v,valid"})
        @ParameterizedTest
        void fail_InvalidInputFormat(String racingCarName) {
            //given
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("이름에 중복이 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"a,a", "1,2,3,1"})
        @ParameterizedTest
        void fail_DuplicatedName(String racingCarName) {
            //given
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("경주할 자동차의 개수가 최소 경주 가능한 자동차 개수보다 작다면 예외를 발생시킨다.")
        @Test
        void fail_LessThanMinRacingCarSize() {
            //given
            List<String> racingCarList = new ArrayList<>();
            for (int i = 0; i < RacingCarRule.MIN_RACER_SIZE - 1; i++) {
                racingCarList.add(String.valueOf(i));
            }
            String racingCarName = String.join(",", racingCarList);
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("경주할 자동차의 개수가 최대 경주 가능한 자동차 개수를 넘는다면 예외를 발생시킨다.")
        @Test
        void fail_OverMaxRacingCarSize() {
            //given
            List<String> racingCarList = new ArrayList<>();
            for (int i = 0; i < RacingCarRule.MAX_RACER_SIZE + 1; i++) {
                racingCarList.add(String.valueOf(i));
            }
            String racingCarName = String.join(",", racingCarList);
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName(RacingCarRule.MAX_RACER_NAME_LENGTH + "자가 넘는다면 예외를 발생시킨다.")
        @Test
        void fail_OverRacingCarNameMaxLength() {
            //given
            String racingCarName = "a".repeat(RacingCarRule.MAX_RACER_NAME_LENGTH + 1);
            String turnsCount = "1";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 시")
    class Invalid_TurnsCount {

        @DisplayName("비었거나, 공백이라면 예외를 발생시킨다.")
        @ValueSource(strings = {" ", "\n", "\r", "\t"})
        @ParameterizedTest
        void fail_EmptyInput(String turnsCount) {
            //given
            String racingCarName = "1,3";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력의 최대 문자열 길이를 넘는다면 예외를 발생시킨다.")
        @Test
        void fail_OverMaxInputLength() {
            //given
            String racingCarName = "1,3";
            String turnsCount = RacingCarRule.MAX_TOTAL_TURN + "0";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자 이외 문자가 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"1 00", "39g9", "10(0"})
        @ParameterizedTest
        void fail_InvalidInputFormat(String turnsCount) {
            //given
            String racingCarName = "1,3";
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            // when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("최대 시도 횟수보다 크다면 예외를 발생시킨다.")
        @Test
        void fail_GreaterThanMaxTotalTurn() {
            //given
            String racingCarName = "1,3";
            String turnsCount = String.valueOf(RacingCarRule.MAX_TOTAL_TURN + 1);
            mockScreen.setRacingCarNames(racingCarName);
            mockScreen.setTotalTurn(turnsCount);
            //when then
            assertThatThrownBy(racingGameManager::run)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}