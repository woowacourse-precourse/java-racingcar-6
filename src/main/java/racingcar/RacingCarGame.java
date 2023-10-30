package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
    public void run() {
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

        } catch (RacingGameException e) {
            System.out.println(e.getMessage());
        }
    }

    private CarManager initializeCarManager() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String[] carNames = UserInput.readCarNames();
        CarManager carManager = new CarManager();
        for (String carName : carNames) {
            carManager.addCar(carName);
        }
        return carManager;
    }

    private int getNumberOfAttempts() {
        System.out.println("\n시도할 횟수를 입력하세요.");
        return UserInput.readNumberOfAttempts();
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

