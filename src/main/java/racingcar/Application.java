package racingcar;

import racingcar.cars.Car;
import racingcar.cars.Cars;
import racingcar.input.Input;

public class Application {
    public static void main(String[] args){
        Input input = new Input();
        input.printInputCarsMessage();
        String carsName = input.inputCarsName();
        Cars cars = new Cars(carsName);
        input.printInputAttemptCountMessage();
        int attemptCount = input.inputAttemptCount();
        System.out.println("\n실행 결과");
        for(int i=0; i<attemptCount; i++) {
            for(Car car : cars) {
                car.move(car.getRandomNumber());
                cars.printMoveRecord(car.getName(), car.getMoveDistance());
            }
            System.out.println("\n");
        }
        cars.printWinner();
    }
}
