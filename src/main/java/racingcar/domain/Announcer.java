package racingcar.domain;

import java.util.List;

public class Announcer {
    public StringBuffer displayWinner(List<Car> winner) {
        StringBuffer finalWinner = new StringBuffer("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            finalWinner.append(winner.get(i).getName());
            if (i < winner.size() - 1) {
                finalWinner.append(", ");
            }
        }
        return finalWinner;
    }
}
