package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingGame {

    private static final String REQUIRE_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUIRE_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PROGRESS_RESULT = "실행결과";
    private Player player = new Player();
    private HashMap<String, Integer> cars;
    private ArrayList<String> winnerList = new ArrayList<>();
    private int attemptNumber, carNumber, valueOfCar, randomNumber, updateCarValue;
    private String carName;

    public void GameStart() {
        printMessage(REQUIRE_CAR_NAME_MESSAGE);
        player.setCarName();
        printMessage(REQUIRE_ATTEMPT_NUMBER_MESSAGE);
        player.setAttemptNumber();
        attemptNumber = player.getAttemptNumber();

        cars = player.getCarName();
        carNumber = cars.size();

        gameProgress(attemptNumber);
    }

    public void gameProgress(int attemptNumber) {
        System.out.println();
        printMessage(PROGRESS_RESULT);
        carName = "";
        for (int i = 0; i < attemptNumber; i++) {
            for (int j = 0; j < carNumber; j++) {
                carName = player.getCarName(j);
                eachCarPickRandomNumber(carName);
                printProgress(carName);
            }
            System.out.println();
        }
        checkWinner();
        printWinner();
    }

    public void printProgress(String carName) {
        System.out.printf("%s : ", carName);
        valueOfCar = cars.get(carName);
        for (int i = 0; i < valueOfCar; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void eachCarPickRandomNumber(String carName) {
        randomNumber = player.getRandomNumber();
        if (randomNumber >= 4) {
            updateCarValue = cars.get(carName) + 1;
            cars.put(carName, updateCarValue);
        }
    }

    public void checkWinner() {
        for (int i = 0; i < cars.size(); i++) {
            carName = player.getCarName(i);
            valueOfCar = cars.get(carName);
            if (valueOfCar == attemptNumber) {
                winnerList.add(carName);
            }
        }
    }

    public void printWinner() {
        if (winnerList.size() == 1) {
            printSoloWinner();
        }
        if (winnerList.size() > 1) {
            printJointWinner();
        }
    }

    public void printSoloWinner() {
        System.out.printf("최종 우승자 :  %s", winnerList.get(0));
    }

    public void printJointWinner() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size() - 1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(winnerList.size() - 1));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
