package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private static final Integer initialRound = 0;

    private List<Car> cars;
    private Integer totalRound;
    private Integer round;

    public Racing(List<Car> cars, Integer totalRound){
        this.cars = cars;
        this.totalRound = totalRound;
        this.round = initialRound;
    }

    public List<Car> getCars(){
        return cars;
    }

    public Integer getTotalRound(){
        return totalRound;
    }

    public Integer getRound(){
        return round;
    }

    public void allCarsDecideMoving(){
        cars.stream().forEach(Car::decideMoving);
    }

    public void proceedRound(){
        round++;
    }

    public Boolean isRacingOver(){
        if (round == totalRound) return true;
        return false;
    }

    public List<String> getWinnerNames(){
        Integer maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winnerNames = cars.stream()
                .filter(car -> car.isDistanceSame(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
        return winnerNames;
    }
}
