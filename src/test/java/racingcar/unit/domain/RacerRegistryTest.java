package racingcar.unit.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.common.config.RacingCarRule;
import racingcar.domain.RacerRegistry;
import racingcar.domain.racer.RacingCar;

class RacerRegistryTest {

    private static List<RacingCar> getRacingCarList(String... name) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : name) {
            racingCarList.add(RacingCar.from(carName));
        }
        return racingCarList;
    }

    private static List<RacingCar> getRacingCarList(int size) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            racingCarList.add(RacingCar.from(String.valueOf(i)));
        }
        return racingCarList;
    }

    @Nested
    @DisplayName("경주 자동차 여러 개를 한 번에 등록할 시")
    class addAll {

        static Stream<List<RacingCar>> successArgument() {
            return Stream.of(
                    getRacingCarList(RacingCarRule.MIN_RACER_SIZE),
                    getRacingCarList(RacingCarRule.MIN_RACER_SIZE + 1)
            );
        }

        static Stream<List<RacingCar>> fail_DulicatedNameArgument() {
            return Stream.of(
                    getRacingCarList("A", "B", "A", "D"),
                    getRacingCarList("1", "2", "3", "1")
            );
        }

        @DisplayName("성공적으로 등록한다.")
        @MethodSource("successArgument")
        @ParameterizedTest
        void success(List<RacingCar> racingCarList) {
            //given
            //when
            RacerRegistry<RacingCar> racerRegistry = new RacerRegistry<>();
            racerRegistry.addAll(racingCarList);
            //then
            assertThat(racerRegistry.getRacers()).hasSize(racingCarList.size());
        }

        @DisplayName("중복 이름이 존재하면 예외를 발생시킨다.")
        @MethodSource("fail_DulicatedNameArgument")
        @ParameterizedTest
        void fail_DulicatedName(List<RacingCar> racingCarList) {
            //given
            //when then
            RacerRegistry<RacingCar> racerRegistry = new RacerRegistry<>();
            assertThatThrownBy(() -> racerRegistry.addAll(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("등록할 수 있는 최대 개수보다 많다면 예외를 발생시킨다.")
        @Test
        void fail_GreaterThanMaxRacingCarSize() {
            //given
            List<RacingCar> racingCarList = getRacingCarList(RacingCarRule.MAX_RACER_SIZE + 1);
            //when then
            RacerRegistry<RacingCar> racerRegistry = new RacerRegistry<>();
            assertThatThrownBy(() -> racerRegistry.addAll(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("등록해야 하는 최소 개수보다 적다면 예외를 발생시킨다.")
        @Test
        void fail_LessThanMinRacingCarSize() {
            //given
            List<RacingCar> racingCarList = getRacingCarList(RacingCarRule.MIN_RACER_SIZE - 1);
            //when then
            RacerRegistry<RacingCar> racerRegistry = new RacerRegistry<>();
            assertThatThrownBy(() -> racerRegistry.addAll(racingCarList))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}