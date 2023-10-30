package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleView implements GameView {

    public ConsoleView() {
    }

    @Override
    public String getUserInput() {
        return Console.readLine();
    }

    @Override
    public void printInputCars() {
        System.out.println(ViewConstants.INPUT_CARS);
    }

    @Override
    public void printInputMoveCount() {
        System.out.println(ViewConstants.INPUT_MOVE_COUNT);
    }

    @Override
    public void printExecutionStart() {
        System.out.println(ViewConstants.OUTPUT_EXECUTION_START);
    }

    @Override
    public void printMoveResult(List<String> status) {
        status.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printFinalWinner(String result) {
        System.out.print(ViewConstants.OUTPUT_FINAL_WINNER + result);
    }
}
