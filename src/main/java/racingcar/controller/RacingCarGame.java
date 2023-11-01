package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.model.RacingResult;
import racingcar.view.RacingGameException;
import racingcar.view.UserInput;

public class RacingCarGame {
    private final UserInput userInput;

    public RacingCarGame(UserInput userInput) {
        this.userInput = userInput;
    }

    public RacingResult run() {
        try {
            CarManager carManager = initializeCarManager();
            int numberOfAttempts = getNumberOfAttempts();

            RacingResult racingResult = new RacingResult();

            System.out.println("실행결과");

            for (int i = 0; i < numberOfAttempts; i++) {
                carManager.moveAll();
                printCarMovements(carManager);
            }

            determineWinners(racingResult, carManager);
            printWinners(racingResult);

            return racingResult;

        } catch (RacingGameException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private CarManager initializeCarManager() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String[] carNames = userInput.readCarNames();
        CarManager carManager = new CarManager();
        for (String carName : carNames) {
            carManager.addCar(carName);
        }
        return carManager;
    }

    private int getNumberOfAttempts() {
        System.out.println("\n시도할 횟수를 입력하세요.");
        return userInput.readNumberOfAttempts();
    }

    private void printCarMovements(CarManager carManager) {
        for (Car car : carManager.getCars()) {
            System.out.println(car.getName() + " : " + car.getMovement());
        }
        System.out.println();
    }

    private void determineWinners(RacingResult racingResult, CarManager carManager) {
        for (Car car : carManager.getCars()) {
            racingResult.update(car.getName(), car.getPosition());
        }
    }

    private void printWinners(RacingResult racingResult) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", racingResult.getWinners()));
    }
}
