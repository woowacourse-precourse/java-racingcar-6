package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.*;

public class CarService {

    public final List<Car> cars = new ArrayList<>();
    public final int forwardMovementCount;

    public CarService(String carNames, String forwardMovementCount) {

        this.forwardMovementCount = checkTypeForwardMovementCount(forwardMovementCount);

        for (String carName : carNames.split(",")) {

            if (checkTypeCarName(carName)) {
                throw new IllegalArgumentException("자동차 이름이 5자 초과되었습니다.");
            }

            cars.add(new Car(carName));
        }

    }

    public void moveForward() {

        System.out.println("실행 결과");

        for (int i = 0; i < forwardMovementCount; i++) {

            for (Car car : cars) {
                carMove(car);
                System.out.println(car);
            }

            System.out.println();
        }

    }

    public void finalWinnerCar() {

        String tot = "";
        int rank = cars.get(0).getForwardMovementCount();

        Collections.sort(cars, (car1, car2) -> Integer.compare(
                car2.getForwardMovementCount(),
                car1.getForwardMovementCount())
        );

        for (Car car : cars) {
            if (car.getForwardMovementCount() == rank) {
                tot += car.getName() + ", ";
            }
        }

        System.out.println("최종 우승자 : " + tot.substring(0, tot.length() - 2));
    }

    private boolean checkTypeCarName(String carName) {

        if (carName.length() > 5) {
            return true;
        }

        return false;
    }

    private void carMove(Car car) {

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            car.addForwardMovementCount();
        }

    }

    private int checkTypeForwardMovementCount(String forwardMovementCount) {

        int count;

        try {
            count = Integer.parseInt(forwardMovementCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 시도할 회수가 정수가 아닙니다.");
        }

        if (count <= 0) {
            throw new IllegalArgumentException("입력하신 시도할 회수가 음수 또는 0 입니다.");
        }

        return count;
    }

}
