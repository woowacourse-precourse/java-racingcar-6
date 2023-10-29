package racingcar.service;

import java.util.List;

public class CarWinner {

    private CarResult result;

    public CarWinner(CarResult result) {
        this.result = result;
    }

    private void individualWinner(List<String> winner) {
        winner.stream()
                .forEach(System.out::println);
    }

    private void multipleWinner(List<String> winner) {
        String winners = String.join(", " , winner);
        System.out.println(winners);
    }

    public void printWinner() {
        List<String> winner = result.getMaxPlayer();
        if (winner.size() == 1) {
            individualWinner(winner);
            return;
        }
        multipleWinner(winner);
    }
}
