package racingcar.domain;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    private List<Car> participant = new ArrayList<>();

    public void play(){
        List<String> cars = parseCarNames(readLine());
    }

    public List<String> parseCarNames(String carNames){
        String regex = ",";
        return Arrays.asList(carNames.split(regex));
    }

    public void createCar(List<String> cars){
        for(String car : cars){
            participant.add(new Car(car, 0));
        }
    }
}
