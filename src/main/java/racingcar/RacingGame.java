package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class RacingGame {

    public RacingGame() {
    }

    String[] carName;
    public Car[] cars;
    int carCount;
    int tryNumber;
    int currentMax = 0;
    ArrayList<String> winner = new ArrayList<String>();

    public void init() {
        inputCarName();
        inputTryNum();
        startGame();
        getWinner();
    }

    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInputs = Console.readLine();
        carName = carNameInputs.split(",");
        carCount = carName.length;
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        tryNumber = Integer.parseInt(input);
    }

    public void startGame() {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(carName[i]);
        }

        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < carCount; j++) {
                cars[j].startGameTurn();
            }
            System.out.println("\n실행 결과");
            for (int j = 0; j < carCount; j++) {
                cars[j].showCurrentStep();
                currentMax = Math.max(currentMax, cars[j].getCurrentStep());
            }
        }
    }

    public ArrayList<String> getWinner() {
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getCurrentStep() == currentMax) {
                winner.add(cars[i].getName());
            }
        }
        return winner;
    }
}