package racingcar.service.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

    @Nested
    @DisplayName("유효성 테스트")
    class CreateTest {
        @ParameterizedTest
        @ValueSource(strings = {"pobi,pobi", "준기,1231,준기"})
        @DisplayName("[실패 테스트] 중복 이름의 자동차가 존재")
        void duplicateCarTest(String carNames) {
            // given
            List<String> carNamesList = Arrays.asList(carNames.split(","));
            // when, then
            Assertions.assertThatThrownBy(() -> new RacingCars(carNamesList, new WootecoCarEngine()))
                    .hasMessage("중복된 이름이 존재합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"jun"})
        @DisplayName("[실패 테스트] 자동차가 최소 제한 2개를 미만")
        void lessThanMinTotalCount(String carName) {
            // given
            List<String> carNameList = Arrays.asList(carName);
            // when, then
            Assertions.assertThatThrownBy(() -> new RacingCars(carNameList, new WootecoCarEngine()))
                    .hasMessage("자동차 개수 범위가 맞지 않습니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"jun,pobi,hey,!!!, QGG,QWE,*_*,pay,runne,guuc,shake"})
        @DisplayName("[실패 테스트] 자동차가 최대 제한 10개를 초과")
        void greaterThanMaxTotalCount(String carNames) {
            // given
            List<String> carNameList = Arrays.asList(carNames.split(","));
            // when, then
            Assertions.assertThatThrownBy(() -> new RacingCars(carNameList, new WootecoCarEngine()))
                    .hasMessage("자동차 개수 범위가 맞지 않습니다.");
        }
    }

    // TODO:우승자를 찾는 기능 테스트
    @Nested
    @DisplayName("우승자를 찾는 기능 테스트")
    class FindWinnersTest {

        @ParameterizedTest
        @ValueSource(strings = {"준기,포비"})
        @DisplayName("2명이 경주하고 2명 모두 우승하는 테스트")
        void doRaceTest(String carNames) {
            // given
            RacingCars racingCars = new RacingCars(Arrays.asList(carNames.split(",")), () -> 1);
            // when
            racingCars.doRace();
            List<String> winners = racingCars.findWinners();
            // then
            Assertions.assertThat(winners.get(0)).isEqualTo("준기");
            Assertions.assertThat(winners.get(1)).isEqualTo("포비");
        }
    }

    // TODO:경주를 진행하는 기능 테스트
    @Nested
    @DisplayName("경주를 진행하는 기능 테스트")
    class DoRaceTest {

        static final int MOVE = 1;
        static final int STOP = 0;

        @ParameterizedTest
        @ValueSource(strings = {"준기,포비,왼손"})
        @DisplayName("3명이 경주하고 2명만 전진하는 테스트")
        void doRaceTest(String carNames) {
            // given
            RacingCars racingCars = new RacingCars(Arrays.asList(carNames.split(",")), new CustomCarEngine());
            // when
            List<Car> cars = racingCars.doRace();
            // then
            Assertions.assertThat(cars.get(0).getPosition()).isEqualTo(STOP);
            Assertions.assertThat(cars.get(1).getPosition()).isEqualTo(MOVE);
            Assertions.assertThat(cars.get(2).getPosition()).isEqualTo(MOVE);
        }

        static class CustomCarEngine implements CarEngine {

            List<Integer> enginePowers3 = Lists.newArrayList(3, 4, 9);

            @Override
            public int generateNumber() {
                return enginePowers3.remove(0);
            }
        }
    }
}