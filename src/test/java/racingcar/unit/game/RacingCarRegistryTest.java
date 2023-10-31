package racingcar.unit.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.game.RacingCarRegistry;
import racingcar.racer.RacingCar;

class RacingCarRegistryTest {

    private static List<RacingCar> getRacingCarList(String... name) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : name) {
            racingCarList.add(RacingCar.nameOf(carName));
        }
        return racingCarList;
    }

    private static List<RacingCar> getRacingCarList(int size) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            racingCarList.add(RacingCar.nameOf(String.valueOf(i)));
        }
        return racingCarList;
    }

    @Nested
    @DisplayName("경주 자동차 여러 개를 한 번에 등록할 시")
    class addAll {

        static Stream<List<RacingCar>> successArgument() {
            return Stream.of(
                    getRacingCarList("A", "B", "C", "D"),
                    getRacingCarList("pobi")
            );
        }

        static Stream<List<RacingCar>> fail_DulicatedNameArgument() {
            return Stream.of(
                    getRacingCarList("A", "B", "A", "D"),
                    getRacingCarList("1", "2", "3", "1")
            );
        }

        static Stream<List<RacingCar>> fail_OverRacingCarMaxNumberArgument() {
            return Stream.of(
                    getRacingCarList(101)
            );
        }

        @DisplayName("성공적으로 등록한다.")
        @MethodSource("successArgument")
        @ParameterizedTest
        void success(List<RacingCar> racingCarList) {
            //given

            //when
            RacingCarRegistry racingCarRegistry = new RacingCarRegistry();
            racingCarRegistry.addAll(racingCarList);

            //then
            assertThat(racingCarRegistry.getRacingCars()).hasSize(racingCarList.size());
        }

        @DisplayName("중복 이름이 존재하면 예외를 발생시킨다.")
        @MethodSource("fail_DulicatedNameArgument")
        @ParameterizedTest
        void fail_DulicatedName(List<RacingCar> racingCarList) {
            //given
            //when then
            RacingCarRegistry racingCarRegistry = new RacingCarRegistry();
            assertThatThrownBy(() -> racingCarRegistry.addAll(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("등록할 수 있는 최대 개수보다 많다면 예외를 발생시킨다.")
        @MethodSource("fail_OverRacingCarMaxNumberArgument")
        @ParameterizedTest
        void fail_OverRacingCarMaxNumber(List<RacingCar> racingCarList) {
            //given
            //when then
            RacingCarRegistry racingCarRegistry = new RacingCarRegistry();
            assertThatThrownBy(() -> racingCarRegistry.addAll(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}