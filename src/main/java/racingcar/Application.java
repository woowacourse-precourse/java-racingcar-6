package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        GameFunction gameFunction = new GameFunction();
        Print print = new Print();

        List<Car> carList;

        int turn;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = userInput.getCarNames();
        carList = gameFunction.makingCar(carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        turn = userInput.getTurn();
        System.out.println();

        System.out.println("실행 결과");
        gameFunction.repeatGame(turn, carList);
        print.Winner(carList);
    }
}