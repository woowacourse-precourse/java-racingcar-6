package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.userinput.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int NOT_HAVE_SAME_NAMES = 0;
    private static final int MAX_FORWARD_COUNT_TARGET = -1;

    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String CAR_NAME_OUTPUT_DELIMITER = ", ";
    private static final String START_RACE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLAY_OUTPUT = "실행 결과";
    private static final String FINAL_RESULT = "최종 우승자 : ";

    private Integer gameCount;
    private final List<Car> cars = new ArrayList<>();
    private final UserInput userInput = new UserInput(this);

    public void start() {
        System.out.println(START_RACE);
        userInput.inputCarNames();
        userInput.inputGameCount();
        Console.close();
    }

    public void createCar(String carName) {
        cars.add(new Car(carName));
    }

    public void saveGameCount(String userInput) {
        gameCount = Integer.parseInt(userInput);
    }

    public boolean hasDuplicatedCarNames(String carName) {
        long countEqualNames = cars.stream()
                .filter(car -> car.isEqualName(carName))
                .count();
        return countEqualNames > NOT_HAVE_SAME_NAMES;
    }

    public void play() {

        System.out.println();
        System.out.println(PLAY_OUTPUT);

        for (int i = 0; i < gameCount; i++) {
            playAllCars();
        }

        printResult();
    }

    private void playAllCars() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.createRandomNumber();
            int forwardCount = car.compareNumberAndMove(randomNumber);
            printProgress(car.getName(), forwardCount);
        }
        System.out.println();
    }

    private void printProgress(String carName, int forwardCount) {
        System.out.print(carName + COLON);
        System.out.println(DASH.repeat(forwardCount));
    }

    private void printResult() {

        System.out.print(FINAL_RESULT);

        List<Car> winnerCars = findWinnerCars();

        List<String> winnerCarsNames = Car.getCarsNames(winnerCars);

        System.out.println(String.join(CAR_NAME_OUTPUT_DELIMITER, winnerCarsNames));

    }

    private List<Car> findWinnerCars() {

        int maxForwardCount = findMaxForwardCount();

        return cars.stream()
                .filter(car -> car.isEqualForwardCount(maxForwardCount))
                .toList();
    }

    private int findMaxForwardCount() {

        int maxForwardCount = MAX_FORWARD_COUNT_TARGET;

        for (Car car : cars) {
            maxForwardCount = car.findBiggerForwardCount(maxForwardCount);
        }

        return maxForwardCount;
    }
}
