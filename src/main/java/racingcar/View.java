package racingcar;

import java.util.List;

public class View {
    public void printGameStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountsQuestionMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printPlayResultText() {
        System.out.println("\n실행 결과");
    }

    public void printResult(List<String> names, List<Long> moveCounts) {
        String result = convertToResultForm(names, moveCounts);
        System.out.println(result);
    }

    private String convertToResultForm(List<String> names, List<Long> moveCounts) {
        StringBuilder resultForm = new StringBuilder();
        for (int idx = 0; idx < names.size(); idx++) {
            String name = names.get(idx);
            long moveCount = moveCounts.get(idx);
            resultForm.append(name).append(" : ").append(convertMoveCountsToHyphens(moveCount)).append("\n");
        }
        return resultForm.toString();
    }
}
