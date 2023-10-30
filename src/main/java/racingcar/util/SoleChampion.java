package racingcar.util;

import java.util.List;

public class SoleChampion implements Champion {
    @Override
    public void finalWinnerOutput(List<String> winnerInformation) {
        System.out.println("단독우승");
        System.out.println(winnerInformation);


    }
}
