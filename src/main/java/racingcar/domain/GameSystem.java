package racingcar.domain;

import java.util.List;

public class GameSystem {
    private final List<Car> carList;
    private final int attemptNumFinal;
    private int attemptNum=0;

    public GameSystem(List<Car> carList,int attemptNumFinal){
        this.carList=carList;
        this.attemptNumFinal=attemptNumFinal;
    }

    public List<Car> getCarList(){
        return carList;
    }

    public void incAttemptNum(){
        attemptNum++;
    }

    //attemptNum count test
    public int getAttemptNum(){
        return attemptNum;
    }

    public Boolean compareAttemptNumToFinal(){
        return attemptNum==attemptNumFinal;
    }


}
