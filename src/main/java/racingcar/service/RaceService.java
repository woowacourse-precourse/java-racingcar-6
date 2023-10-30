package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
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

    public int inputCnt() {
        String cnt = scanner.next();
        StringUtil.checkNumber(cnt);

        return Integer.parseInt(cnt);
    }

    public void raceStart(Cars cars, int cnt) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < cnt; i++) {
            moveCars(cars);
            showAllCars(cars);
        }

    }

    private void moveCars(Cars cars) {
        for (Car car : cars.getCars()) {
            car.moveCar(getRandomMoveDistance());
        }

    }

    protected int getRandomMoveDistance() {
        int distance = Randoms.pickNumberInRange(0, 9);
        if (distance > 3) {
            return distance;
        }
        return 0;
    }

    private void showAllCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s : ", car.getName()) + StringUtil.repeatString(car.getDistance()));
        }
        System.out.println();
    }


}
