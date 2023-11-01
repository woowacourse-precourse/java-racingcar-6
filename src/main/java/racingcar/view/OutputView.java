package racingcar.view;

import java.util.List;

public class OutputView {
    public void showResult() {
        System.out.println("실행 결과");
    }

    public String convertListToString(List<String> winnerList) {
        return String.join(", ", winnerList);
    }

    public void showWinners(List<String> winnerList) {
        String winners = convertListToString(winnerList);
        System.out.print("최종 우승자 : " + winners);
    }
}
