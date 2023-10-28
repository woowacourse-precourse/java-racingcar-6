package racingcar;

import racingcar.model.CarMove;
import racingcar.view.PrintInput;
import racingcar.view.PrintResult;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PrintInput car = new PrintInput();
        List<String> car_list = car.inputCar();
        StringBuilder[] move_result = new StringBuilder[car_list.size()];
        int numberOfGame = car.inputNumberOfMove();

        for (int i = 0; i<move_result.length; i++){
            move_result[i] = new StringBuilder();
        }

        System.out.println("실행 결과");

        for (int i = 0; i<numberOfGame; i++){
            CarMove.move(car_list, move_result);
        }

        PrintResult.printWinner(car_list, move_result);
    }
}
