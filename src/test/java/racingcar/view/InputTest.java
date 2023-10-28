package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @Test
    public void carNameDuplicateTest(){
        //given
        List<Car> carList = new ArrayList<>();
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
}
