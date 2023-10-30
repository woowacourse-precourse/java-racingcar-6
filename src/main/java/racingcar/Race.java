package racingcar;

import java.util.ArrayList;
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

        displayWinner(decideWinner());
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

    public List<Car> decideWinner() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = -1;

        for (Car car : cars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                winners.clear();
                winners.add(car);
                maxPosition = position;
            }
            else if (position == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public void displayWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int idx = 0; idx < winners.size(); idx++) {
            System.out.print(winners.get(idx).getName());

            if (idx < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}