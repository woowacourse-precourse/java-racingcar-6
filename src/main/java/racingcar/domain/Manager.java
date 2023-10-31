package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Car> carList;

    private int maxLine;

    private int moveCount;

    public Manager(int moveCount) {
        this.carList = new ArrayList<>();
        this.moveCount = moveCount;
        this.maxLine = 0;
    }

    public void registerCar(Car car){
        this.carList.add(car);
    }

    public void manageMoveOneCycle(){
        for(Car car : carList){
            if(possibleToMove(car)) {
                car.getChanceToMove();
            }
            increaseMaxLine(car.getScore());
        }
        endOneCycle();
    }

    public List<String> resultWinner(){
        List<String> winner = new ArrayList<>();
        for(Car car : carList){
            if(car.getScore()==maxLine){
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private boolean possibleToMove(Car car){
        if(car.getRemainMoveCount()>0) {
            return true;
        }
        return false;
    }

    private void increaseMaxLine(int score){
        if (maxLine < score) {
            this.maxLine = score;
        }
    }

    private void endOneCycle(){
        moveCount--;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

}
