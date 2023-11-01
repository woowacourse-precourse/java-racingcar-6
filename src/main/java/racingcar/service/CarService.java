package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.util.CarParser;
import racingcar.view.TextInterface;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    TextInterface textInterface = new TextInterface();
    CarParser carParser = new CarParser();

    public List<Car> enterCars(){
        textInterface.inputCarsNameMessage();
        return setCars(Console.readLine());
    }

    public List<Car> setCars(String input){
        List<Car> carList = carParser.stringToCarList(input);
        return carList;
    }
}
