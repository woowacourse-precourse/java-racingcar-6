package testUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.Test;

import racingcar.game.Car;
import racingcar.game.Cars;
import racingcar.utils.Converter;

import java.util.List;

public class CarsTest {
    @Test
    void Cars_cars_name_test(){
        String input = "pobi,navi";

        Cars cars = new Cars();
        cars.initializeCars(input);

        List<Car> carsList = cars.getCars();

        String result = "";

        for(Car car:carsList){
            result = result.concat(car.getName());
        }

        assertThat(result).isEqualTo("pobinavi");
    }

}
