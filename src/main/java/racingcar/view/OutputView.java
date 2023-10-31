package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;

public class OutputView {

    private final String MESSAGE_OUTPUT_RESULT = "\n실행 결과";
    private final String MESSAGE_OUTPUT_WINNER = "최종 우승자 : ";
    private final String MOVE_SIGN = "-";

    public void outputResultMessage() {
        System.out.println(MESSAGE_OUTPUT_RESULT);
    }

    public void outputRacingCarGameStatus(String CarName, int position) {
        System.out.println(CarName + " : " + MOVE_SIGN.repeat(position));
    }

    public void outputEmptyLine() {
        System.out.println();
    }

    public void outputWinnerMessage(ArrayList<Car> winnerList) {
        System.out.print(MESSAGE_OUTPUT_WINNER);

        for(Car winner : winnerList) {
            System.out.print(winner.getName());
            if(winnerList.indexOf(winner) != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }

}
