package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.RacingGameManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameManagerTest {

    @Test
    @DisplayName("입력 조건에 부합하는 경우, 예외를 발생시키지 않는다.")
    void validateCarNames_dontThrowException() {
        String playerInput = "seoul,rome,tokyo";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatCode(() -> racingGameManager.createCarListFromPlayerInput(playerInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차의 이름이 5자 이하가 아니라면 예외를 발생시킨다.")
    void validateCarNamesUnderFive_throwException() {
        String playerInput = "seoul,washington,tokyo";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatThrownBy(() -> racingGameManager.createCarListFromPlayerInput(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 5자 이하로 입력해주세요. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("차의 이름이 중복된다면 예외를 발생시킨다.")
    void validateDuplicatedCarName_throwException() {
        String playerInput = "seoul, rome, rome";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatThrownBy(() -> racingGameManager.createCarListFromPlayerInput(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 중복될 수 없습니다. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("차의 이름이 공백이라면 예외를 발생시킨다.")
    void validateEmptyCarName_throwException() {
        String playerInput = "seoul, ,tokyo";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatThrownBy(() -> racingGameManager.createCarListFromPlayerInput(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력될 수 없습니다. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("입력 조건에 부합하는 경우, 값을 검증한다.")
    void validateCarNames_successful() {
        String playerInput = "seoul,rome";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());
        List<Car> carNames = racingGameManager.createCarListFromPlayerInput(playerInput);

        assertThat(carNames.get(0).getName()).isEqualTo("seoul");
        assertThat(carNames.get(1).getName()).isEqualTo("rome");
        assertThat(carNames.get(0).getMovingCount()).isEqualTo(0);
        assertThat(carNames.get(1).getMovingCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("시도 횟수가 조건에 맞다면, 예외를 발생시키지 않는다.")
    void validateCounts_dontThrowException() {
        String playerInput = "5";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatCode(() -> racingGameManager.createCountFromPlayerInput(playerInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 공백이라면, 예외를 발생시킨다.")
    void validateCounts_ThrowException1() {
        String playerInput = " ";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatThrownBy(() -> racingGameManager.createCountFromPlayerInput(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 0이라면, 예외를 발생시킨다.")
    void validateCounts_ThrowException2() {
        String playerInput = "0";
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());

        assertThatThrownBy(() -> racingGameManager.createCountFromPlayerInput(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다. 자동차 경주 게임을 종료합니다.");
    }
}