package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.repository.SaveCarList;

import java.util.Arrays;
import java.util.List;

public class ParsingCarName {
    private SaveCarList saveCarList;
    public ParsingCarName(SaveCarList saveCarList,CarList carList){
        this.saveCarList= new SaveCarList(carList);
    }

    public void parsingInput(String inputCars) {
        for (String carName : inputCars.split(",")) {
            Car car = new Car(carName);
            saveCarList.addCar(car);
        }
    }
}

//        new ArrayList<>(Arrays.asList(inputCars.split(",")));
