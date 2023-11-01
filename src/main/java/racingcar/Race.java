package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.userinput.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int MAX_FORWARD_COUNT_TARGET = -1;

    private Integer gameCount;
    private final List<Car> cars = new ArrayList<>();
    private final UserInput userInput = new UserInput();
    private final UserOutput userOutput = new UserOutput();

    public void start() {
        userOutput.printStart();
        saveCars();
        saveGameCount();
        Console.close();
    }

    private void saveGameCount() {
        gameCount = userInput.inputGameCount();
    }

    private void saveCars() {
        List<String> carNames = userInput.inputCarNames();
        createCars(carNames);
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void play() {

        userOutput.printPlay();

        for (int i = 0; i < gameCount; i++) {
            playAllCars();
        }

        List<Car> winnerCars = findWinnerCars();
        userOutput.printResult(winnerCars);
    }

    private void playAllCars() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.createRandomNumber();
            int forwardCount = car.compareNumberAndMove(randomNumber);
            userOutput.printProgress(car.getName(), forwardCount);
        }
        userOutput.printBlank();
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
