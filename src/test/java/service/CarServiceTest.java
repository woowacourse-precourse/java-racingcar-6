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

        Assertions.assertThat(cars).containsExactly(new Car("json"),new Car("jade"),new Car("lily"));
    }
    @Test
    void 랜덤값_입력받으면_move수행(){
        String carNamesWithComma ="json,jade,lily";
        carService.saveCars(InputView.splitNames(carNamesWithComma));

        List<Integer> list= new ArrayList<>(3);
        list.add(5);
        list.add(8);
        list.add(2);

        carService.moveAllCars(list);

        List<Car> cars = carService.findCars();

        Assertions.assertThat(cars.get(0).getForward()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getForward()).isEqualTo(1);
        Assertions.assertThat(cars.get(2).getForward()).isEqualTo(0);

        List<Integer> list2= new ArrayList<>(3);
        list2.add(3);
        list2.add(8);
        list2.add(5);

        carService.moveAllCars(list2);

        Assertions.assertThat(cars.get(0).getForward()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getForward()).isEqualTo(2);
        Assertions.assertThat(cars.get(2).getForward()).isEqualTo(1);


    }


}