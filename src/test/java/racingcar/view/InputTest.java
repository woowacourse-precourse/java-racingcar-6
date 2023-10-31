package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    private static final String STRING_REGEX = "^[\\w]*$";

    List<Car> carList = new ArrayList<>();

    @AfterEach
    void clearCarList(){
        carList.clear();
    }

    @Test
    public void carNameDuplicateTest(){
        //given
        carList.add(new Car("crong"));
        carList.add(new Car("pobi"));
        carList.add(new Car("pobi"));

        //when
        HashSet<String> carHashSet = new HashSet<>();
        for (Car car : carList) {
            carHashSet.add(car.getCarName());
        }

        //then
        assertThat(carList.size())
                .isNotEqualTo(carHashSet.size());
    }

    @Test
    public void carNameTypeAndLengthTest(){
        //given
        carList.add(new Car("poro"));
        carList.add(new Car("lux"));

        //when

        //then
        for (Car car : carList) {
            assertThat(car.getCarName().length())
                    .isLessThan(6)
                    .isGreaterThan(0);
            assertThat(car.getCarName())
                    .containsPattern(STRING_REGEX);
        }
    }
}
