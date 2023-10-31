package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Race {
    private static final int MOVING_FORWARD = 4;
    private static final int ONE_STEP = 1;
    public List<Car> cars = new ArrayList<>();
    public NumberGenerator numberGenerator = new NumberGenerator();

    public void play() {
        createCarObjects(inputCarNames());
        int moveNum = inputMovingNumber();

        System.out.println("실행 결과");
        for (int num = 0; num < moveNum; num++) {
            updateCarsPosition();
            displayCarMoving();
        }

        displayWinner();
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        String[] carNames = input.split(",");
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public void createCarObjects(String[] carNames) {
        for (int idx = 0; idx < carNames.length; idx++) {
            cars.add(new Car(carNames[idx]));
        }
    }

    private int inputMovingNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String moveNum = readLine();
        InputValidator.validateMovingNumber(moveNum);
        return Integer.parseInt(moveNum);
    }

    public void updateCarsPosition() {
        for (Car car : cars) {
            int number = numberGenerator.createRandomNumber();

            if (number >= MOVING_FORWARD) {
                car.setPosition(car.getPosition() + ONE_STEP);
            }
        }
    }

    public void displayCarMoving() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.print("\n");
    }

    public void displayWinner() {
        List<String> winners = findWinners();
        String result = String.join(", ", winners);
        System.out.print("최종 우승자 : " + result);
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public int findMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }

        return Collections.max(positions);
    }
}