package racingcar.domain;

import static java.util.Collections.max;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> Cars = new ArrayList<>();

    //forEach문 사용
    public Race(List<String> cars){
        cars.forEach(car -> Cars.add(new Car(car)));
    }

    private void goForward(){
        Cars.forEach(Car::moveForward);
    }

    public void playOneRound(){
        goForward();
        InputOutputMessage.printRoundResult(new ArrayList<>(Cars.stream()
                .map(Car::getRoundResult)
                .collect(Collectors.toList())

        ));
    }

    public void presentWinner(){
        InputOutputMessage.presentWinner(new ArrayList<>(Cars.stream()
                .filter(car -> car.isWinner(max(getCarPosition())))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }

    private List<Integer> getCarPosition(){
        List<Integer> positions = new ArrayList<>();
        Cars.forEach(car -> positions.add(car.getPosition()));

        return positions;
    }
}
