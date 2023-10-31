package service;

import domain.Car;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    CarService carService = new CarService();


    @Test
    void 입력받은_차_저장_test() {
        String carNamesWithComma ="json,jade,lily";
        carService.saveCars(InputView.splitNames(carNamesWithComma));

        List<Car> cars = carService.findCars();

        Assertions.assertThat(cars).contains(new Car("json"),new Car("jade"),new Car("lily"));
    }


}