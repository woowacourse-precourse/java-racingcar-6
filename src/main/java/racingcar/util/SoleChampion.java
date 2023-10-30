package racingcar.util;

import java.util.List;

public class SoleChampion implements Champion {

    @Override
    public void finalWinnerOutput(List<String> winnerInformation) {

        String winner = String.join(", ", winnerInformation);
        System.out.println(winner);

    }

}
