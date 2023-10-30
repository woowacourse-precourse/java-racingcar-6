package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    int moveCount;
    private List<Car> cars=new ArrayList<>();
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
    public void moveCars(){
        for(Car car:cars){
            car.move();
        }
    }
    public List<String> getWinner(){
        List<String> winners=new ArrayList<>();
        int max=0;
        for(Car car:cars){
            if(car.getLocation()>=max){
                if(car.getLocation()>max)
                    winners.clear();
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
