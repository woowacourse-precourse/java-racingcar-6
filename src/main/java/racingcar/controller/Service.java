package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Output;

public class Service {
    private static void startRace(int numberOfAttempts, Car[] cars) {
        int game = 0;

        while (game < numberOfAttempts) {
            for (Car car : cars) {
                car.setScore();
                Output.printScore(car.getName(), car.getScore());
            }
            System.out.println();
            game++;
        }
    }
    public static void playGame(){
        String[] names;
        int attempts;

        Output.printInput();
        names = User.inputCarName();
        Car[] cars = User.registerCars(names);

        Output.printRound();
        attempts = User.inputAttempts();

        Output.printResult();
        startRace(attempts, cars);
        Output.printWinner(Search.searchWinner(Search.searchMax(cars), cars));
    }
}
