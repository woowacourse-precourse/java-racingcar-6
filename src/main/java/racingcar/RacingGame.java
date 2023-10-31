package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RacingGame {
    private final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRIALS_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String PRINT_RESULT_MESSAGE = "실행 결과";
    private final String PRINT_FINAL_WINNER = "최종 우승자 : ";
    private final int MAX_CAR_NAME_LENGTH = 4;
    private final int MIN_CAR_NAME_LENGTH = 1;

    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();

    public RacingGame() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);

        splitInputToCarNames(readInput());

        validateCarName();

        System.out.println(INPUT_TRIALS_MESSAGE);
        String trial = readInput();

        validateTrial(trial);

        printResultMessage(Integer.parseInt(trial));

        findWinners();

        printWinners();
    }

    private String readInput() {
        return Console.readLine().trim();
    }

    private void validateCarName() {
        if (cars.isEmpty())
            throw new IllegalArgumentException();

        for (Car car : cars) {
            int lengthOfCarName = car.getLengthOfName();
            if (lengthOfCarName > MAX_CAR_NAME_LENGTH || lengthOfCarName < MIN_CAR_NAME_LENGTH)
                throw new IllegalArgumentException();
        }
    }

    private void validateTrial(String trial) {
        if (!Pattern.matches("^[0-9]*$", trial))
            throw new IllegalArgumentException();
    }

    private void splitInputToCarNames(String input) {
        Arrays.stream(input.split(","))
                .iterator()
                .forEachRemaining(car -> {
                    car = car.trim();
                    if (car.isEmpty())
                        throw new IllegalArgumentException();

                    cars.add(new Car(car));
                });
    }

    private void printResultMessage(int trial) {
        System.out.println(PRINT_RESULT_MESSAGE);
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                pickRandomNumberAndPrintResult(car);
            }
            System.out.println();
        }
    }

    private void pickRandomNumberAndPrintResult(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4)
            car.forward();
        System.out.printf("%s : %s\n", car.getName(), car.getPosition());
    }

    private void findWinners() {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getPositionByLength() > maxDistance) {
                winners = new ArrayList<>();
                winners.add(car);
            } else if (car.getPositionByLength() == maxDistance) {
                winners.add(car);
            }
        }
    }

    private void printWinners() {
        StringBuilder result = new StringBuilder();
        winners.stream()
                .iterator()
                .forEachRemaining(car -> result.append(car.getName()).append(", "));
        if (winners.size() > 1)
            result.delete(result.length() - 2, result.length());
        System.out.printf("%s%s", PRINT_FINAL_WINNER, result);
    }
}
