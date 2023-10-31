package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Car> carList;

    private List<String> winnerList;

    private int maxMovingScore;

    private int RemainingCycle;

    public Manager(int moveCount) {
        this.carList = new ArrayList<>();
        this.RemainingCycle = moveCount;
        this.maxMovingScore = 0;
    }

    public void registerCar(Car car){
        this.carList.add(car);
    }

    public void manageOneCycle(){
        for(Car car : carList){
            car.tryToGetMovementScore();
            renewMaxMovingScore(car.getMovementScore());
        }
        endOneCycle();
    }

    public List<String> announceWinner(){
        checkWinner();
        return winnerList;
    }

    private void checkWinner(){
        winnerList = new ArrayList<>();
        for(Car car : carList){
            if(car.getMovementScore()== maxMovingScore){
                winnerList.add(car.getName());
            }
        }
    }

    private void renewMaxMovingScore(int score){
        if (maxMovingScore < score) {
            this.maxMovingScore = score;
        }
    }

    private void endOneCycle(){
        RemainingCycle--;
    }

    public int getRemainingCycle(){
        return RemainingCycle;
    }

    public int getMaxMovingScore(){
        return maxMovingScore;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

}
