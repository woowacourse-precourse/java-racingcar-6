package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        UserInput userInput = new UserInput();
        PrintOut.informationMessage();
        List<Car> carList = carFactory.createCars(userInput.getCarNames(Console.readLine()));

        PrintOut.numberAttemptsMessage();
        int attemptsNumber = userInput.getAttemptsNumber(Console.readLine());

        Race race = new Race();
        race.start(carList, attemptsNumber);
    }
}
