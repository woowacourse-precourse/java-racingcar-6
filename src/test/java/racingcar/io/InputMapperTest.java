package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.io.input.InputMapper;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 변환 객체에 대해")
class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("자동차 이름들이 Cars객체로 변환한다.")
    void names_to_cars() {
        //given
        Cars cars = inputMapper.toCars("pobi,woni");

        //when
        int carsCount = cars.getRacingCars().size();

        //then
        assertThat(carsCount).isEqualTo(2);
    }

    @Test
    @DisplayName("시도 횟수를 int형으로 변환한다.")
    void attempt_count_to_int() {
        //given
        //when
        int attemptCount = inputMapper.toInt("3");

        //then
        assertThat(attemptCount).isInstanceOf(Integer.class);
    }
}
