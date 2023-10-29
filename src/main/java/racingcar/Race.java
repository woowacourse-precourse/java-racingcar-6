package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int NOT_HAVE_SAME_NAMES = 0;
    private static final int KEY_VALUE = 4;

    private Integer gameCount;
    private final List<Car> cars = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator(this);

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarNames();
        inputGameCount();
        play();
    }

    private void inputCarNames() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");
        createCars(carNames);
    }

    private void createCars(String[] carNames) {
        for (String carName : carNames) {
            inputValidator.carName(carName);
            cars.add(new Car(carName));
        }
    }

    private void inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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
        System.out.println("\n실행 결과");
        for (int i = 0; i < gameCount; i++) {
            for (Car car : cars) {
                car.printCarName();
                int randomNumber = NumberGenerator.createRandomNumber();
                compareNumberAndMove(car, randomNumber);
                car.printForwardCount();
            }
            System.out.println();
        }
    }

    private void compareNumberAndMove(Car car, int randomNumber) {
        if (randomNumber >= KEY_VALUE) {
            car.moveForward();
        }
    }
}
