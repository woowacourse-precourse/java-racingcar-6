package racingcar.view;

import java.util.List;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printInitGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printBeforeInputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRoundResult(List<String> carResults) {
        for (int i = 0; i < carResults.size(); i++) {
            System.out.println(carResults.get(i));
        }
        System.out.println();
    }

    public void notifyBeforeResult() {
        System.out.println("\n실행결과");
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
