package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.StringUtil;

import java.io.InputStream;
import java.util.Scanner;

import static racingcar.domain.Cars.Car;

public class RaceService {
    private Scanner scanner;

    public RaceService(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public Cars inputCars() {
        Cars cars = Cars.createCars();
        for (String name : scanner.next().split(",")) {
            StringUtil.checkCarLength(name);
            cars.addCar(new Car(name, 0));
        }
        return cars;
    }


}
