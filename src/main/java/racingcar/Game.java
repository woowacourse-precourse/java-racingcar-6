package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final List<Car> cars = new ArrayList<>();
    private int round;

    private boolean isValidCarName(String name) {
        return name.length() <= 5;
    }

    private boolean validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (!isValidCarName(carName)) {
                return false;
            }
        }
        return true;
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(Console.readLine().split(","));
    }

    private void createCars(List<String> carNames) {
        if (!validateCarNames(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
    }

    private String inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    private boolean validateRound(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void setRound(String round) {
        if (!validateRound(round)) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
        this.round = Integer.parseInt(round);
    }

    private void input() {
        createCars(inputCarNames());
        setRound(inputRound());
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printResult() {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName());
            sb.append(" : ");
            sb.append("-".repeat(Math.max(0, car.getPosition())));
            System.out.println(sb);
        }
    }

    private void printTotalResult() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            moveCars();
            printResult();
            System.out.println();
        }
    }

    private String getWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                sb.append(car.getName());
                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private void printWinners() {
        System.out.println("최종 우승자 : " + getWinners());
    }

    public void run() {
        input();
        printTotalResult();
        printWinners();
    }
}
