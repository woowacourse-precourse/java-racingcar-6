package view.outputView;

import java.util.List;

public class OutputViewImpl {
    private static final String READ_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners));
    }

    public void printResults(List<String> results) {
        results.forEach(System.out::println);
    }

    public void printReadAttemptMessage() {
        System.out.println(READ_ATTEMPT_MESSAGE);
    }
}
