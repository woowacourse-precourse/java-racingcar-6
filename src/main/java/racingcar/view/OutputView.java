package racingcar.view;

import racingcar.domain.dto.CarRecord;
import racingcar.domain.dto.RoundResult;

import java.util.List;

public class OutputView {

    private final static String delimiter = " : ";
    private final static String forwardMark = "-";

    public void printRoundResult(List<RoundResult> roundResult) {
        for(RoundResult result : roundResult){
            printRound(result);
        }
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.print("최종 우승자 : " + winnerNames);
    }

    public void printExecutionResultString() {
        System.out.println("실행결과");
    }

    private String calculateNumberOfHyphen(int numberOfStep) {
        return forwardMark.repeat(numberOfStep);
    }

    private void printRound(RoundResult roundResult){
        List<CarRecord> round = roundResult.getRound();
        for (CarRecord carRecord : round) {
            System.out.println(carRecord.getCarName() + delimiter + calculateNumberOfHyphen(carRecord.getNumberOfStep()));
        }
        System.out.println();
    }

}
