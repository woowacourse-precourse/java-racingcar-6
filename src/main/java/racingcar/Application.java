package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import car.Car;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 자동차 이름 입력을 받음
        List<Car> cars = initializeCars();
        // 사용자로부터 시도 횟수 입력을 받음
        int rounds = readRounds();
        // 게임을 시작하여 자동차를 주어진 횟수만큼 이동시킴
        startGame(cars, rounds);
        // 게임이 종료되면 우승자를 찾아 출력
        findWinners(cars);
    }

    // 사용자로부터 자동차 이름 입력을 받음
    private static String readCarNames() {
        System.out.print("자동차 이름 입력: ");
        return Console.readLine();
    }

    // 사용자로부터 시도 횟수 입력을 받음
    private static int readRounds() {
        System.out.print("시도할 횟수: ");
        return Integer.parseInt(Console.readLine());
    }

    // 자동차 초기화
    private static List<Car> initializeCars() {
        String[] carNames = readCarNames().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    // 자동차 이름의 유효성을 검사
    private static void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    // 게임 시작
    private static void startGame(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars(cars);
        }
    }

    // 자동차를 무작위로 이동
    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            printCarPosition(car);
        }
    }

    // 각 자동차의 현재 위치 출력
    private static void printCarPosition(Car car) {
        String positionString = new String(new char[car.getPosition()]).replace('\0', '-');
        System.out.println(car.getName() + " : " + positionString);
    }

    // 우승자 찾기
    private static void findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        printWinners(winners);
    }

    // 최대 위치 찾기
    private static int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }

    // 우승자 출력
    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
