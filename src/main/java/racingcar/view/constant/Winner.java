package racingcar.view.constant;

import java.util.List;

public class Winner implements Message {

    private final String winner;

    private Winner(List<String> winnerList) {
        winner = "최종 우승자 : " + String.join(", ", winnerList);
    }

    public static Winner announcement(List<String> winnerList) {
        return new Winner(winnerList);
    }

    @Override
    public String getMessage() {
        return winner;
    }
}
