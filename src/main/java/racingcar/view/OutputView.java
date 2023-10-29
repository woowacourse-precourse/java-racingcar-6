package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INPUT_RACING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printInputRacingCarNamesMessage() {
        System.out.println(INPUT_RACING_CAR_NAMES_MESSAGE);
    }

    public void printInputAttemptCountMessage() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printExecutionResult(LinkedHashMap<String, Integer> progressStatus) {
        StringBuilder ExecutionResult = new StringBuilder();
        for (String carName : progressStatus.keySet()) {
            makeCarMovingResult(progressStatus, carName, ExecutionResult);
        }
        System.out.println(ExecutionResult);
    }

    private void makeCarMovingResult(LinkedHashMap<String, Integer> progressStatus, String carName,
                                     StringBuilder ExecutionResult) {
        ExecutionResult.append(carName)
                .append(" : ");
        for (int i = 0; i < progressStatus.get(carName); i++) {
            ExecutionResult.append("-");
        }
        ExecutionResult.append("\n");
    }

    public void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ")
                .append(winners.stream()
                        .collect(Collectors.joining(", ")));
        System.out.print(stringBuilder);
    }
}
