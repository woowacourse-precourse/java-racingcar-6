package racingcar;

import static racingcar.Computer.getInput;

public class Application {

    public static void main(String[] args) {

        Car car = new Car(CarManager.createNames(getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")));

        car.move(CarRace.createRound(getInput("시도할 회수는 몇회인가요?")));

        CarRace.printWinner(CarRace.findWinner(car, CarRace.findBest(car.movedDistances)));

    }
}
