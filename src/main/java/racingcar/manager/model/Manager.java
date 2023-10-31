package racingcar.manager.model;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private int maxMove;

    private List<String> winnerCars;

    public Manager(){
        this.maxMove = 0;
        this.winnerCars = new ArrayList<>();
    }

    public List<String> getWinnerCars(){
        return this.winnerCars;
    }

    public void judgeWinnerCar(String carName, Integer moveCount){
        if(moveCount>this.maxMove){
            this.maxMove = moveCount;
            this.winnerCars.clear();
            this.winnerCars.add(carName);
        }
        else if(moveCount == this.maxMove){
            this.winnerCars.add(carName);
        }
    }
}
