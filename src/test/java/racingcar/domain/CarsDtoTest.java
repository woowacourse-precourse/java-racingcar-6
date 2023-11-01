package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsDtoTest {

    CarsDto carsDto;

    @BeforeEach
    @DisplayName("매 테스트 수행 전 데이터 입력")
    void initCarNames() {
        // given
        String inputtedCarNames = "pobi,woni,jun";
        // when
        carsDto = new CarsDto(inputtedCarNames);
    }

    @Test
    @DisplayName("자동차 이름이 순서대로 DTO에 입력되고, DTO는 인덱스에 맞춰 반환하는 기능이 있다.")
    void getSingleCarName() {
        // then
        assertThat(carsDto.getSingleCarName(0)).isEqualTo("pobi");
        assertThat(carsDto.getSingleCarName(1)).isEqualTo("woni");
        assertThat(carsDto.getSingleCarName(2)).isEqualTo("jun");
    }

    @Test
    @DisplayName("자동차가 총 몇 대인지 DTO는 반환하는 기능을 갖고 있다.")
    void getNumberOfCars() {
        // then
        assertThat(carsDto.getNumberOfCars()).isEqualTo(3);
    }
}