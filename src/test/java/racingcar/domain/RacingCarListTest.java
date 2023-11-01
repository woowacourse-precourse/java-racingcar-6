package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.utils.generator.IntendedNumberGenerator;

public class RacingCarListTest {

    @DisplayName("올바른 이름을 입력하면 인스턴스가 생성된다.")
    @Test
    void should_createInstance_when_validNameInput() {
        String name = "name";

        RacingCar racingCar = new RacingCar(name);

        Assertions.assertThat(racingCar.getName()).isEqualTo(name);
    }

    @DisplayName("잘못된 이름을 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void should_returnException_when_invalidNameInput(String name) {
        RacingCar racingCar = new RacingCar(name);

        Assertions.assertThatThrownBy(() -> new RacingCarList(List.of(racingCar)));
    }

    @DisplayName("getMaxAdvanceCount를 호출하면 최댓값을 반환한다.")
    @Test
    void should_returnMaxValue_when_invokeGetMaxAdvanceCount() {
        RacingCarList racingCarList = new RacingCarList(List.of(
                new RacingCar("a"),
                new RacingCar("b"),
                new RacingCar("c"),
                new RacingCar("d"),
                new RacingCar("e")
        ));

        racingCarList.racingCars().get(0).increaseCount();

        Assertions.assertThat(racingCarList.getMaxAdvanceCount()).isEqualTo(1);
    }

    @DisplayName("4이상의 수가 생성되면 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void should_move_when_GreaterOrEqual4(int number) {
        RacingCarList racingCarList = new RacingCarList(List.of(new RacingCar("name")));

        racingCarList.moveOrStop(new IntendedNumberGenerator(number));

        Assertions.assertThat(racingCarList.racingCars().get(0).getAdvanceCount()).isEqualTo(1);
    }

    @DisplayName("4미만의 수가 생성되면 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void should_dontMove_when_lessThan4(int number) {
        RacingCarList racingCarList = new RacingCarList(List.of(new RacingCar("name")));

        racingCarList.moveOrStop(new IntendedNumberGenerator(number));

        Assertions.assertThat(racingCarList.racingCars().get(0).getAdvanceCount()).isEqualTo(0);
    }
}
