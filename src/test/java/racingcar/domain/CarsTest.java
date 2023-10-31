package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

class CarsTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"pobi", "pobi,", "pobi,woni", "pobi,woni,jun"})
    @DisplayName("자동차 이름들이 주어졌을 때 cars 생성 성공")
    void givenNames_whenCreateCars_thenNoException(String names) {
        assertThatNoException().isThrownBy(() -> new Cars(names));
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", ",", "pobi, ", "pobi,pobi", "pobi,woni,pobi"})
    @DisplayName("자동차 이름들이 주어졌을 때 cars 생성 실패")
    void givenNames_whenCreateCars_thenThrowException(String names) {
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("각 자동차 이동 확인")
    void givenCars_whenMoveEachCar_thenMoveOrStop() {
        Cars cars = new Cars("pobi,woni");

        cars.moveEachCar();

        CarsDto carsDto = cars.toCarsDto();
        List<CarDto> results = carsDto.carDtos();
        assertThat(results.get(0).position()).isBetween(0, 1);
        assertThat(results.get(1).position()).isBetween(0, 1);
    }

    @Test
    @DisplayName("최종 우승자 이름 구하기")
    void givenCars_whenFindWinnersName_thenReturnWinnersName() {
        Cars cars = new Cars("pobi,woni");
        cars.moveEachCar();

        List<String> result = cars.findWinnersName();

        assertThat(result).containsAnyOf("pobi", "woni");
    }

    @Test
    @DisplayName("최종 우승자 이름 구하기 불변 리스트 확인")
    void givenWinners_whenModify_thenThrowException() {
        Cars cars = new Cars("pobi");
        List<String> winners = cars.findWinnersName();

        assertThatThrownBy(() -> winners.add("woni"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("CarsDto 생성 확인")
    void givenCars_whenToCarsDto_thenSuccess() {
        Cars cars = new Cars("pobi,woni");

        CarsDto carsDto = cars.toCarsDto();

        List<CarDto> result = carsDto.carDtos();
        assertThat(result.get(0)).extracting("name").isEqualTo("pobi");
        assertThat(result.get(0)).extracting("position").isEqualTo(0);
        assertThat(result.get(1)).extracting("name").isEqualTo("woni");
        assertThat(result.get(1)).extracting("position").isEqualTo(0);
    }

}
