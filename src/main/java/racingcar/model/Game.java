package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> carList ;
    private String winnerPosition;

    public Game(){
        carList = new ArrayList<>();
        winnerPosition="";
    }

    public void addCar(Car car){
        carList.add(car);
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
}
