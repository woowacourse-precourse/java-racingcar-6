package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.ResultCars;

@DisplayName("Cars의 ")
public class CarsTest {

    private Cars cars;

    @BeforeEach
    void set_up() {
        String firstCarName = "1st";
        String secondCarName = "2nd";
        String thirdCarName = "3rd";

        Car firstCar = new Car(firstCarName);
        Car secondCar = new Car(secondCarName);
        Car thirdCar = new Car(thirdCarName);

        firstCar.increaseDistance();
        firstCar.increaseDistance();
        firstCar.increaseDistance();

        secondCar.increaseDistance();
        secondCar.increaseDistance();

        thirdCar.increaseDistance();

        cars = new Cars(List.of(firstCar, secondCar, thirdCar));
    }

    @Test
    @DisplayName("가장 멀리간 차들을 반환 하는가")
    void filter_cars_with_max_distance() {
        //given
        int firstIndex = 0;
        String expectedCarName = "1st";

        //when
        ResultCars expectedResultCars = cars.filterCarsWithMaxDistance();

        //then
        assertThat(expectedResultCars.getResultCars().get(firstIndex).getName())
                .isEqualTo(expectedCarName);
    }
}
