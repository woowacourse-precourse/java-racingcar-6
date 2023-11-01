package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.CarNameSeperator;
import racingcar.utils.JudgementRandomGenerator;

@DisplayName("RacingCarService의")
public class RacingCarServiceTest {

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;
    private final CarNameSeperator carNameSeperator = new CarNameSeperator();
    private final JudgementRandomGenerator judgementRandomGenerator = mock(JudgementRandomGenerator.class);
    private final RacingCarService racingCarService = new RacingCarService(carNameSeperator, judgementRandomGenerator);

    private Cars cars;

    @BeforeEach
    void set_up() {
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car yunhoCar = new Car("yunho");
        cars = new Cars(List.of(pobiCar, woniCar, yunhoCar));
    }

    @Test
    @DisplayName("차 이름들이 저장이 되는가")
    void save_car_name() {
        //given
        String input = "pobi,woni,yunho";

        //when
        Cars actualCars = racingCarService.saveCarName(input);

        //then
        assertThat(actualCars.getValues().get(FIRST_INDEX).getName())
                .isEqualTo(cars.getValues().get(FIRST_INDEX).getName());
        assertThat(actualCars.getValues().get(SECOND_INDEX).getName())
                .isEqualTo(cars.getValues().get(SECOND_INDEX).getName());
        assertThat(actualCars.getValues().get(THIRD_INDEX).getName())
                .isEqualTo(cars.getValues().get(THIRD_INDEX).getName());
    }

    @Test
    @DisplayName("차가 이동하는가")
    void move_car() {
        //given
        int oneDistance = 1;
        given(judgementRandomGenerator.isIncreaseDistance()).willReturn(true);

        //when
        racingCarService.moveCar(cars);

        //then
        assertThat(cars.getValues().get(FIRST_INDEX).getDistance()).isEqualTo(oneDistance);
        assertThat(cars.getValues().get(SECOND_INDEX).getDistance()).isEqualTo(oneDistance);
        assertThat(cars.getValues().get(THIRD_INDEX).getDistance()).isEqualTo(oneDistance);
    }
}
