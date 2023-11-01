package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GarageTest {

    @Test
    @DisplayName("입력 조건에 부합하는 경우, 예외를 발생시키지 않는다.")
    void validateCarNames_dontThrowException() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 정상적인 사용자 입력을 입력한다면,
         * then : 예외를 발생시키지 않는다.
         */
        String playerInput = "seoul,rome,tokyo";

        assertThatCode(() -> new Garage(playerInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차의 이름이 5자 이하가 아니라면 예외를 발생시킨다.")
    void validateCarNamesUnderFive_throwException() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 차의 이름이 6자 이상인 원소(washington)이 포함된다면,
         * then : IllegalArgumentException 예외를 발생시킨다.
         */
        String playerInput = "seoul,washington,tokyo";

        assertThatThrownBy(() -> new Garage(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 5자 이하로 입력해주세요. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("차의 이름이 중복된다면 예외를 발생시킨다.")
    void validateDuplicatedCarName_throwException() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 차의 이름이 중복("rome")된다면
         * then : IllegalArgumentException 예외를 발생시킨다.
         */
        String playerInput = "seoul, rome, rome";

        assertThatThrownBy(() -> new Garage(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 중복될 수 없습니다. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("차의 이름이 공백이라면 예외를 발생시킨다.")
    void validateEmptyCarName_throwException() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 차의 이름이 공백이라면
         * then : IllegalArgumentException 예외를 발생시킨다.
         */
        String playerInput = "seoul, ,tokyo";

        assertThatThrownBy(() -> new Garage(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력될 수 없습니다. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("입력 조건에 부합하는 경우, 값을 검증한다.")
    void validateCarNames_successful() {
        /**
         * given : 사용자 입력과 Garage 객체가 주어진다.
         * when : Garage에 사용자 입력을 입력하고,
         * then : Garage 객체의 값을 검증한다.
         */
        String playerInput = "seoul,rome";
        Garage garage = new Garage(playerInput);
        List<Car> cars = garage.getCarList();

        assertThat(cars.get(0).getName()).isEqualTo("seoul");
        assertThat(cars.get(1).getName()).isEqualTo("rome");
        assertThat(cars.get(0).getMovingCount()).isEqualTo(0);
        assertThat(cars.get(1).getMovingCount()).isEqualTo(0);
    }
}