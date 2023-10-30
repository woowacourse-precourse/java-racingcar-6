package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        GameFunction gameFunction = new GameFunction();
        Print print = new Print();

        List<Car> carList;

        int turn;

        System.out.println(print.startingComment);
        List<String> carNameList = userInput.getCarNames();
        carList = gameFunction.makingCar(carNameList);

        System.out.println(print.askHowManyTurn);
        turn = userInput.getTurn();
        System.out.println();

        System.out.println(print.resultComment);
        gameFunction.repeatGame(turn, carList);
        print.Winner(carList);
    }
}