package racingcar.service;

import racingcar.utils.Numbers;
import java.util.List;
public class CarWinner {

    private static final int FIRST_INDEX = 0;
    private CarResult result;
    public CarWinner(CarResult result) {
        this.result = result;
    }

    private String individualWinner(List<String> winner) {
        return winner.get(FIRST_INDEX);
    }

    private String multipleWinners(List<String> winner) {
        String winners = String.join(", " , winner);
        return winners;
    }

    public String printWinner() {
        List<String> winner = result.findMaxPlayers();
        if (winner.size() == Numbers.ALONE_NUMBER.getNumber()) {
            return individualWinner(winner);
        }
        return multipleWinners(winner);
    }
}
