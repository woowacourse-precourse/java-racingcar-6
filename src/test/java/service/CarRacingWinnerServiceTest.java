package service;

import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ui.Output;
import util.BeanFactory;
import util.CarList;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarRacingWinnerServiceTest {

    private CarRacingWinnerService carRacingWinnerService;
    private CarList<Car> carList;
    private Field outputBuilder;

    @BeforeAll
    public void init() {
        this.carRacingWinnerService = BeanFactory.getInstanceCarRacingWinnerService();
    }

    @Test
    public void 우승자는_가장_많이_전진한_차다() throws IllegalAccessException {
        CarList<Car> carList = new CarList<Car>();
        carList.add(new Car("aaaaa",3));
        carList.add(new Car("bbbbb",2));
        Cars cars = new Cars(carList);

        List<Car> selectedWinner = carRacingWinnerService.selectWinner(cars);
        assertEquals(selectedWinner.size(),1);
        assertEquals(selectedWinner.get(0).getName(),"aaaaa");
    }



}