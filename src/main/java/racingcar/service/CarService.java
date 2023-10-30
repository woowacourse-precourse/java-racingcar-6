package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final CarView carView;

    public CarService(CarView carView) {
        this.carView = carView;
    }

    public List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            validateName(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void startRacing(List<Car> cars, int moveCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            moveCar(cars);
            carView.printResult(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private static boolean canMove() {
        int randNumber = Randoms.pickNumberInRange(1, 9);
        return randNumber >= 4;
    }
}
