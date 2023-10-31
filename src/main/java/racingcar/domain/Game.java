package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    ArrayList<Car> carList;
    int moveNumber;

    public Game(ArrayList<Car> carList, int moveNumber) {
        this.carList = carList;
        this.moveNumber = moveNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public int getCarNumber(){
        return carList.size();
    }

    public ArrayList<Car> updateDistance(List<Boolean> isMoving){
        for(int i=0; i<carList.size(); i++){
            if(isMoving.get(i)) carList.get(i).move();
        }
        return carList;
    }
}
