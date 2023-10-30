package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        GameFunction gameFunction = new GameFunction();
        Print print = new Print();
        List<Car> carList;

        System.out.println(print.startingComment);
        carList = gameFunction.makingCar();

        System.out.println(print.askHowManyTurn);
        System.out.println();

        System.out.println(print.resultComment);
        gameFunction.repeatGame(carList);
        print.Winner(carList);
    }
}