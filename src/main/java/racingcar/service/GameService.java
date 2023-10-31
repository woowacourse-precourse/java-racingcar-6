package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.carfactory.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameService {

    public int randomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public List<Car> selectWinner(List<Car> cars){
        int maxScore = cars.stream().mapToInt(Car::getLocation).max().getAsInt();
        List<Car> winners = cars.stream()
                .filter((car)->{return car.getLocation()==maxScore;})
                .collect(Collectors.toList());
        return winners;
    }

    public List<String> inputToCarNames(String input){
        return Arrays.asList(input.split(", "));
    }
}
