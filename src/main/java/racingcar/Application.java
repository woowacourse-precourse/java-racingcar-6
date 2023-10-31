package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import car.Car; // car 패키지의 Car 클래스를 import

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = readCarNames();
        int rounds = readRounds();
        List<Car> cars = validateCarNames(carNames);
        race(cars, rounds);
    }

    // 자동차 이름 입력을 받음
    private static String readCarNames() {
        System.out.print("자동차 이름 입력: ");
        return Console.readLine();
    }

    // 시도 횟수 입력을 받음
    private static int readRounds() {
        System.out.print("시도할 횟수: ");
        return Integer.parseInt(Console.readLine());
    }

    // 자동차 이름의 유효성 검사
    private static List<Car> validateCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNameArray) {
            if (!isCarNameValid(carName)) {
                throw new IllegalArgumentException("값의 길이가 5자 이상입니다.");
            }
            cars.add(new Car(carName));
        }

        return cars;
    }
    // 자동차 이름이 유효한지 확인
    private static boolean isCarNameValid(String carName) {
        return carName.trim().length() < 5;
    }


    // 자동차를 주어진 횟수만큼 이동
    private static void race(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars(cars);
        }
    }

    // 자동차를 무작위로 이동
    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    // 자동차를 무작위로 이동
    private static void moveCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        car.move(randomNumber);
    }
}
