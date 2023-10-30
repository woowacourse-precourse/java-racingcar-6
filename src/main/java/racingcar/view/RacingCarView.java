package racingcar.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class RacingCarView {

    public String inputCarName() {
        System.out.println(Message.INPUT_CARNAME_MESSAGE);
        return Console.readLine();
    }

    public String inputCount() {
        System.out.println(Message.INPUT_RACECOUNT_MESSAGE);
        return Console.readLine();
    }

    public void printRacing(ArrayList<Car> cars) {
        for (Car c : cars) {
            System.out.print(c.getName() + " : ");
            printMove(c.getMove());
        }
        System.out.println();
    }

    public void printResultMessage() {
        System.out.println(Message.OUTPUT_RESULT_MESSAGE);
    }

    void printMove(int move) {
        for (int i = 0; i < move; i++)
            System.out.print("-");
        System.out.println();
    }

    public void printWinner(String[] names) {
        System.out.print("최종 우승자 : " + String.join(", ", names));
    }
}
