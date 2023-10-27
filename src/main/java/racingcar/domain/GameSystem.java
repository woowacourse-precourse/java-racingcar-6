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

    //함수 테스트 용도
    /*public int getAttemptNum(){
        return attemptNum;
    }*/

    public Boolean compareAttemptNumToFinal(){
        return attemptNum==attemptNumFinal;
    }


}
