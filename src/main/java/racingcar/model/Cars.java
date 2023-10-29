package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Numbers;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int randomGenerator() {
        int randomNumber = Randoms.pickNumberInRange(
                Numbers.RANDOM_START_NUMBER.getNumber(),
                Numbers.RANDOM_END_NUMBER.getNumber()
        );
        return randomNumber;
    }

    private void moveForward() {
        cars.stream()
                .filter(car -> randomGenerator() >= Numbers.MOVE_POSITION_NUMBER.getNumber())
                .forEach(car -> car.updatePosition());
    }

    public void printPlayers() {
        moveForward();
        cars.stream()
            .map(car -> car.getName() + " : " + car.getPosition())
            .forEach(System.out::println);
        System.out.println();
    }

    private int getMaxLength(){
        return cars.stream()
                .map(car -> car.getPosition().length())
                .max(Integer::compareTo)
                .orElse(0);
    }

    private List<String> getMaxPlayer() {
        List<String> maxPlayers = cars.stream()
                .filter(car -> car.getPosition().length() == getMaxLength())
                .map(Car::getName)
                .collect(Collectors.toList());
        return maxPlayers;
    }

    public void printWinner() {
        List<String> winner = getMaxPlayer();
        winner.stream()
                .forEach(System.out::println);
    }

}
