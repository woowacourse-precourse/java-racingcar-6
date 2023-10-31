package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarNameValidator;
import racingcar.model.Race;
import racingcar.model.RoundNumValidator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RaceTest {
    @Test
    public void setRaceTest(){
        CarNameValidator carNameValidator = new CarNameValidator("car1,car2");
        RoundNumValidator roundNumValidator = new RoundNumValidator("5");
        Race race = new Race(carNameValidator.carNameList, Integer.parseInt(roundNumValidator.roundInput));

        ArrayList<Car> carList = race.getCarList();
        assertEquals("car1", carList.get(0).getName());
        assertEquals("car2", carList.get(1).getName());
        assertEquals(race.getRound(), 5);
    }
}