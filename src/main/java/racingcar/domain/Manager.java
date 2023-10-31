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
            if(possibleToMove(car)) {
                car.tryToGetMovementScore();
            }
            increaseMaxMovingScore(car.getMovementScore());
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

    private boolean possibleToMove(Car car){
        if(car.getRemainingOpportunity()>0) {
            return true;
        }
        return false;
    }

    private void increaseMaxMovingScore(int score){
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
