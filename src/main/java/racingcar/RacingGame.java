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
        showResults();
    }

    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInputs = Console.readLine();
        carName = carNameInputs.split(",");
        carCount = carName.length;
        isCarNameValid();
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumInput = Console.readLine();
        isTryNumValid(tryNumInput);
        tryNumber = Integer.parseInt(tryNumInput);
    }

    public void isCarNameValid() {
        for (int i = 0; i < carCount; i++) {
            if (carName[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isTryNumValid(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }
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

    public void showResults() {
        System.out.print("\n최종 우승자 : ");
        String result = String.join(",", winner);
        System.out.println(result);
    }

    public int getCarCount() {
        return carCount;
    }
}