package racingcar.domain;

import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Game {
    private final List<Car> carList ;
    private String winnerPosition;
    private final int repetitions;

    public Game(String carNames, String repetitions){
        carList = new ArrayList<>();
        winnerPosition="";

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

    public void setWinnerPosition(String winnerPosition) {
        this.winnerPosition = winnerPosition;
    }

    public String getWinnerPosition() {
        return winnerPosition;
    }

    public int getRepetitions() {
        return repetitions;
    }
}
