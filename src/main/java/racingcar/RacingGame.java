package racingcar;

import racingcar.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final static String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String START_COUNT_TEXT = "시도할 회수는 몇회인가요?";

    public List<String> getCarNames() throws IllegalArgumentException {
        System.out.println(START_TEXT);
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> values = Arrays.asList(input.split(","));
        values.replaceAll(String::trim);
        isVaildCarName(values);
        return values;
    }

    private void isVaildCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name cannot exceed 5 characters: " + carName);
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("Car name cannot null " + carName);
            }
        }
    }

    private int getUserInput() throws IllegalArgumentException {
        int input = 0;
        System.out.println(START_COUNT_TEXT);
        input = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        return input;
    }

    public void start() {
        try {
            List<String> carNames = getCarNames();
            int userInput = getUserInput();
            List<Car> cars = makeCarList(carNames);
            printState(userInput, cars);
            judgeWinner(cars);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void printState(int userInput, List<Car> cars) {
        System.out.println("\n실행결과");
        for (int i = 0; i < userInput; i++) {
            for (Car car : cars) {
                String middleBar = "-".repeat(car.move());
                System.out.println(car.getName() + " : " + middleBar);
            }
        }
    }

    private void judgeWinner(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        // 최고 위치 찾기
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        // 최고 위치에 있는 차들을 리스트에 추가
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }

    private List<Car> makeCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}