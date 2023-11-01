package racingcar.Controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.Util.InputUtil;
import racingcar.Util.NameUtil;
import racingcar.Util.NumberUtil;
import racingcar.Util.OutputUtil;

public class GameController {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TIMES = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNER_IS = "최종 우승자 : ";
    private static final String BLANK = "";
    private static final String MOVE = "-";
    private static final String BLANK_WITH_COLON = " : ";
    private static final String BLANK_WITH_COMMA = ", ";
    private static final int MIN_MOVE_LENGTH = 4;


    public void startGame() {
        play(makeCarsList(NameUtil.splitName(inputCarsName())), getTimes());
    }

    private String inputCarsName() {
        OutputUtil.println(INPUT_CAR_NAME);
        return InputUtil.readLine();
    }

    private int getTimes() {
        OutputUtil.println(INPUT_TIMES);
        String input = InputUtil.readLine();
        NumberUtil.validateNumber(input);
        return Integer.parseInt(input);
    }

    private List<Car> makeCarsList(List<String> carsNameList) {
        carsNameList.forEach(NameUtil::validateNameLength);
        return carsNameList.stream()
                .map(Car::from)
                .collect(Collectors.toList());
    }

    private void play(List<Car> cars, int times) {
        OutputUtil.println(BLANK);
        OutputUtil.println(RESULT);
        for (int i = 0; i < times; i++) {
            moveCars(cars);
            printCarsLocation(cars);
        }
        printWinner(checkWhoIsWinner(cars));
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.goForward();
            }
        }
    }

    private boolean canMove() {
        return NumberUtil.create() >= MIN_MOVE_LENGTH;
    }

    private void printCarsLocation(List<Car> cars) {
        cars.forEach(this::printCarLocation);
        OutputUtil.println(BLANK);
    }

    private void printCarLocation(Car car) {
        OutputUtil.print(car.getName() + BLANK_WITH_COLON);
        for (int i = 0; i < car.getLocation(); i++) {
            OutputUtil.print(MOVE);
        }
        OutputUtil.println(BLANK);
    }

    private void printWinner(String winner) {
        OutputUtil.print(WINNER_IS);
        OutputUtil.print(winner);
    }

    private String checkWhoIsWinner(List<Car> cars) {
        int maxLocation = cars.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);

        List<String> winnerCars = cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();

        return String.join(BLANK_WITH_COMMA, winnerCars);
    }
}