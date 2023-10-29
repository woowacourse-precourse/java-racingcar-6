package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int NOT_HAVE_SAME_NAMES = 0;
    private static final int KEY_NUMBER = 4;
    private static final int MAX_FORWARD_COUNT_TARGET = -1;

    private static final String START_RACE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_INPUT_DELIMITER = ",";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String PLAY_OUTPUT = "실행 결과";
    private static final String FINAL_RESULT = "최종 우승자 : ";

    private Integer gameCount;
    private final List<Car> cars = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator(this);

    public void start() {
        System.out.println(START_RACE);
        inputCarNames();
        inputGameCount();
        play();
    }

    private void inputCarNames() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(CAR_NAME_INPUT_DELIMITER);
        createCars(carNames);
    }

    private void createCars(String[] carNames) {
        for (String carName : carNames) {
            inputValidator.carName(carName);
            cars.add(new Car(carName));
        }
    }

    private void inputGameCount() {
        System.out.println(ASK_GAME_COUNT);
        String userInput = Console.readLine();
        saveGameCount(userInput);
        Console.close();
    }

    private void saveGameCount(String userInput) {
        inputValidator.gameCount(userInput);
        gameCount = Integer.parseInt(userInput);
    }

    public boolean hasDuplicatedCarNames(String carName) {
        long countEqualNames = cars.stream()
                .filter(car -> car.isEqualName(carName))
                .count();
        return countEqualNames > NOT_HAVE_SAME_NAMES;
    }

    private void play() {

        System.out.println();
        System.out.println(PLAY_OUTPUT);

        for (int i = 0; i < gameCount; i++) {
            playAllCars();
        }

        printResult();
    }

    private void playAllCars() {
        for (Car car : cars) {
            car.printCarName();
            int randomNumber = NumberGenerator.createRandomNumber();
            compareNumberAndMove(car, randomNumber);
            car.printForwardState();
        }
        System.out.println();
    }

    private void printResult() {

        System.out.print(FINAL_RESULT);

        List<Car> winnerCars = findWinnerCars();

        Car.printWinnerCars(winnerCars);

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

    private void compareNumberAndMove(Car car, int randomNumber) {
        if (randomNumber >= KEY_NUMBER) {
            car.moveForward();
        }
    }
}
