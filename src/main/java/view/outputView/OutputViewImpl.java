package view.outputView;

import java.util.List;

public class OutputViewImpl {
    private static final String INSERT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String INSERT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners));
    }

    public void printResults(List<String> results) {
        results.forEach(System.out::println);
    }

    public void printInsertCarNamesMessage() {
        System.out.println(INSERT_CAR_NAMES_MESSAGE);
    }

    public void printInsertAttemptMessage() {
        System.out.println(INSERT_ATTEMPT_MESSAGE);
    }
}
