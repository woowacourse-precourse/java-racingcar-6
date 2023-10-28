package view.outputView;

import java.util.List;

public class OutputViewImpl implements OutputView {
    private static final String INSERT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INSERT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    @Override
    public void printInsertCarNamesMessage() {
        System.out.println(INSERT_CAR_NAMES_MESSAGE);
    }

    @Override
    public void printInsertAttemptMessage() {
        System.out.println(INSERT_ATTEMPT_MESSAGE);
    }

    @Override
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    @Override
    public void printResults(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printWinners(List<String> winners) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.print(String.join(", ", winners));
    }
}
