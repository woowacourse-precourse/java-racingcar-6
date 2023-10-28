package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class RacingCar {
    private List<Car> cars = new ArrayList<>();
    private int round;

    public void playGame() {
        startGame();
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            playRound();
        }
        endGame();
    }

    private void startGame() {
        List<String> carNames = getCarNames();
        round = getNumber();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] nameArr = names.split(",");
        return Arrays.asList((nameArr));
    }

    private int getNumber() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        String numStr = Console.readLine();
        return Integer.parseInt(numStr);
    }

    private void playRound() {
        for (Car car : cars) {
            car.moveForward();
        }
        printRoundResult();
    }

    private void printRoundResult() {
        for (Car car : cars) {
            car.printMoves();
        }
        System.out.println();
    }

    private void endGame() {
        System.out.print("최종 우승자 : ");
        printWinner();
    }

    private int getMaxMoves() {
        int maxMoves = 0;
        for (Car car : cars) {
            maxMoves = max(maxMoves, car.getMoves());
        }
        return maxMoves;
    }

    private void printWinner() {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoves() == getMaxMoves()) {
                winner.add(car.getName());
            }
        }
        System.out.println(String.join(", ", winner));
    }
}
