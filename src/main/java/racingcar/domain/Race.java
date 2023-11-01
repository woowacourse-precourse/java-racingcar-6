package racingcar.domain;

import static java.util.Arrays.stream;
import static java.util.Collections.max;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {
    private final List<Car> carList = new ArrayList<>();

    public Race(List<String> carNames){
        carNames.forEach(carName -> carList.add(new Car(carName)));
    }


    private void goForward(){
        carList.forEach(Car::moveForward);
    }

    public void playOneRound(){
        goForward();
        InputOutputMessage.printRoundResult(new ArrayList<>(carList.stream()
                .map(Car::getRoundResult)
                .collect(Collectors.toList())

        ));
    }

    public void getWinner(){
        InputOutputMessage.printWinner(new ArrayList<>(carList.stream()
                .filter(car -> car.isWinner(max(getCarPosition())))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }

    private List<Integer> getCarPosition(){
        List<Integer> positions = new ArrayList<>();
        carList.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }
}
