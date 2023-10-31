package racingcar.domain;

import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Game {
    private final List<Car> carList ;
    private final int repetitions;

    public Game(String carNames, String repetitions){
        carList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(carNames);
        while (st.hasMoreTokens()){
            String carName = st.nextToken(",");
            Validator.validateCarLength(carName);
            carList.add(new Car(carName, ""));
        }
        Validator.validateIsNumber(repetitions);
        this.repetitions = Integer.parseInt(repetitions);
    }

    public List<Car> getCar(){
        return carList;
    }


    public int getRepetitions() {
        return repetitions;
    }
}
