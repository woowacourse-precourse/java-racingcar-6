package racingcar;

import camp.nextstep.edu.missionutils.Console;
import car.Car;
import racegame.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // 경주 게임을 생성하고 시작
        RaceGame raceGame = createRaceGame();
        raceGame.start();
    }

    // 자동차 리스트와 라운드 횟수를 설정하여 경주 게임 생성
    private static RaceGame createRaceGame() {
        List<Car> cars = initializeCars();
        int rounds = readRounds();
        return new RaceGame(cars, rounds);
    }

    // 사용자로부터 자동차 이름을 입력받음
    private static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    // 사용자로부터 라운드 횟수를 입력받음
    private static int readRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    // 사용자로부터 입력받은 자동차 이름을 검증하고 리스트에 추가
    private static List<Car> initializeCars() {
        String[] carNames = readCarNames().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(carName, cars);
            cars.add(new Car(carName));
        }
        return cars;
    }

    // 자동차 이름의 유효성 검사 및 중복 확인
    private static void validateCarName(String carName, List<Car> cars) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차이름이 5자 이상입니다.");
        }
        for (Car car : cars) {
            if (car.getName().equals(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }
        }
    }
}