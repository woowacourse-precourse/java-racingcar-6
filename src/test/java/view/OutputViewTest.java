package view;

import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CarService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    CarService carService = new CarService();
    @BeforeEach
    void clearRepository(){
        carService.repositoryClear();
    }

    @Test
    void 출력_화면_테스트1(){
        String[] carsWithString = {"jade","lily","json"};
        carService.saveCars(carsWithString);

        List<Integer> list =new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        carService.moveAllCars(list);

        List<Car> cars = carService.findCars();
        Car car = cars.get(0);

        String checkingString = "jade : -\n";

        assertThat(checkingString).isEqualTo(OutputView.middleEachResult(car));
    }
    @Test
    void 출력_화면_테스트2(){
        String[] carsWithString = {"jade","lily","json"};
        carService.saveCars(carsWithString);

        List<Integer> list =new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        carService.moveAllCars(list);

        List<Car> cars = carService.findCars();

        String checkingString = "jade : -\n" +
                "lily : \n" +
                "json : -\n";
        assertThat(OutputView.middleResult(cars)).isEqualTo(checkingString);
    }

}