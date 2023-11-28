package racingcar.view;

import static racingcar.type.message.MessageType.ENTER_RACE_RESULT;

public class OutputViewImpl implements OutputView {
//    private static final String ENTER_RACE_RESULT = "\n실행 결과";
    @Override
    public void printExecution() {
        System.out.println(ENTER_RACE_RESULT);
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printFinalWinner(String winner) {
        System.out.print("최종 우승자 : " + winner);
    }
}
