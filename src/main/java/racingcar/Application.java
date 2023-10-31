package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        UserInput userInput = new UserInput();
        List<Car> carList = carFactory.createCars(userInput.getCarNames(Console.readLine()));
        int attemptsNumber = userInput.getAttemptsNumber();

        Race race = new Race();
        race.start(carList, attemptsNumber);
    }
}
