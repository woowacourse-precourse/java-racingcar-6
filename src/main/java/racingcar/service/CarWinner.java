package racingcar.service;

import racingcar.utils.Numbers;

import java.util.List;

public class CarWinner {

    private CarResult result;

    public CarWinner(CarResult result) {
        this.result = result;
    }

    private String individualWinner(List<String> winner) {
        return winner.get(0);
    }

    private String multipleWinner(List<String> winner) {
        String winners = String.join(", " , winner);
        return winners;
    }

    public String printWinner() {
        List<String> winner = result.getMaxPlayer();
        if (winner.size() == Numbers.ALONE_NUMBER.getNumber()) {
            return individualWinner(winner);
        }
        return multipleWinner(winner);
    }
}
