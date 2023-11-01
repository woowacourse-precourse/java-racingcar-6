package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SingleRoundResultDtoTest {
    @Test
    @DisplayName("SingleRoundResultDto에는 각 차마다의 CarResultDto를 저장하고 있다.")
    void getCarResultDto() {
        // given
        Car pobiCar = Car.createCar("pobi");
        Car woniCar = Car.createCar("woni");
        Car junCar = Car.createCar("jun");

        Car.CarResultDto pobiCarResult = pobiCar.createCarResultDto();
        Car.CarResultDto woniCarResult = woniCar.createCarResultDto();
        Car.CarResultDto junCarResult = junCar.createCarResultDto();
        // when
        List<Car.CarResultDto> carResults = Arrays.asList(
                pobiCarResult, woniCarResult, junCarResult
        );
        SingleRoundResultDto singleRoundResult = new SingleRoundResultDto(carResults);

        // then
        assertThat(singleRoundResult.getCarResultDto(0))
                .isEqualTo(pobiCarResult);
        assertThat(singleRoundResult.getCarResultDto(1))
                .isEqualTo(woniCarResult);
        assertThat(singleRoundResult.getCarResultDto(2))
                .isEqualTo(junCarResult);
    }
}