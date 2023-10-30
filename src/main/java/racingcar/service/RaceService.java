package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.util.StringUtil;

import java.io.InputStream;
import java.util.Scanner;
import java.util.StringJoiner;

import static racingcar.domain.Cars.Car;

public class RaceService {
    private Scanner scanner;

    public RaceService() {
    }

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
        for (Car car : cars.getCarList()) {
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
        for (Car car : cars.getCarList()) {
            System.out.println(String.format("%s : ", car.getName()) + StringUtil.repeatString(car.getDistance()));
        }
        System.out.println();
    }

    public String showWinners(Cars cars) {
        StringJoiner joiner = new StringJoiner(", ");
        int winnerDistance = 0;
        for (Car car : cars.getCarList()) {
            if (car.getDistance() > winnerDistance) {
                joiner = new StringJoiner(", ");
                joiner.add(car.getName());
                winnerDistance = car.getDistance();
            } else if (car.getDistance() == winnerDistance) {
                joiner.add(car.getName());
            }
        }

        System.out.println(String.format("최종 우승자 : %s", joiner));

        return joiner.toString();
    }

}
