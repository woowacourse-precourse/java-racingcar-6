package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
        List<String> winner = getMaxPlayer();
        if (winner.size() == 1) {
            individualWinner(winner);
            return;
        }
        multipleWinner(winner);
    }



}
