package racingcar;

import static racingcar.Computer.calculateMaxDistance;
import static racingcar.Computer.createCarNames;
import static racingcar.Computer.createRoundCount;
import static racingcar.Computer.findWinner;
import static racingcar.Computer.getInput;
import static racingcar.Computer.printWinner;


public class Application {

    public static void main(String[] args) {
        // 1. 자동차 이름 입력
        Car car = new Car(createCarNames(getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")));

        car.move(createRoundCount(getInput("시도할 회수는 몇회인가요?")));

        printWinner(findWinner(car, calculateMaxDistance(car)));

    }
}
