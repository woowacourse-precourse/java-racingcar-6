package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.io.input.InputMapper;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 변환 객체에 대해")
class InputMapperTest {

    @Test
    @DisplayName("자동차 이름들이 Cars객체로 변환한다.")
    void names_to_Cars() {
        //given
        InputMapper inputMapper = new InputMapper();
        Cars cars = inputMapper.toCars("pobi,woni");

        //when
        int carsCount = cars.getRacingCars().size();

        //then
        assertThat(carsCount).isEqualTo(2);
    }

}
