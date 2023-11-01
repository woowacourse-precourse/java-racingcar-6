package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .filter(car -> car.hasWin(car.getPosition()))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }
}
