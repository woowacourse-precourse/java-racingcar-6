package racingcar.view;

import java.util.ArrayList;

public class ConsoleOutputView {
    public void showInputCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showInputTryNumberPrompt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showExecutionResultsHeader() {
        System.out.println("실행 결과");
    }

    public void showExecutionResults(ArrayList<String> carNames, ArrayList<Integer> carGoingCount) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            for (int j = 0; j < carGoingCount.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
