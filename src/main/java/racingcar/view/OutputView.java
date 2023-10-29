package racingcar.view;

import racingcar.domain.dto.CarRecord;
import racingcar.domain.dto.RoundResult;

import java.util.List;

public class OutputView {

    private final String delimiter = " : ";
    private final String forwardMark = "-";

    public void printRoundResult(RoundResult roundResult){
        List<CarRecord> round = roundResult.getRound();

        for (CarRecord carRecord: round) {
            System.out.println(carRecord.getCarName() + delimiter + calculateNumberOfHyphen(carRecord.getNumber_of_step()));
        }

        System.out.println();

    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(",", winners);
        System.out.print("최종 우승자 : " + winnerNames);
    }

    public void printExecutionResultString() {
        System.out.println("실행결과");
    }

    private String calculateNumberOfHyphen(int numberOfStep){
        return forwardMark.repeat(numberOfStep);
    }

}
