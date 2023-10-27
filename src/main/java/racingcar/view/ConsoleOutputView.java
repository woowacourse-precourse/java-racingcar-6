package racingcar.view;

import java.util.ArrayList;

public class ConsoleOutputView {
    public String showInputCarNamesPrompt() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public String showInputTryNumberPrompt() {
        return "시도할 회수는 몇회인가요?";
    }

    public String showExecutionResultsHeader() {
        return "실행 결과";
    }

    public String showExecutionResults(ArrayList<String> carNames, ArrayList<Integer> carGoingCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carNames.size(); i++) {
            result.append(carNames.get(i)).append(" : ");
            for (int j = 0; j < carGoingCount.get(i); j++) {
                result.append("-");
            }
            result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public String showWinner(String winners) {
        return "최종 우승자 : " + winners;
    }
}
