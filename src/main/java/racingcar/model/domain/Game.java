package racingcar.model.domain;

import java.util.List;

public class Game {
    private final int trial;//시도 횟수 -> 상수로 고정

    private final List<Car> cars;//같은 domain패키지에 Car 존재-> 끌고 와 cars에 할당

    private int trialNum = 0;//초기값 0

    public Game( List<Car> cars,int trial) { //car과 trial을 매게변수로 받아 멤버변수에 할당
        this.trial = trial;
        this.cars = cars;
    }

    public List<Car>getCars(){
        return cars;
    }
    public void increaseTrialNum(){ //trialNum++메서드
        this.trialNum += 1;
    }
    public Boolean checkTrialNum(){ //게임에 따라 라운드 진행하는지 학인
        return this.trial == this.trialNum;
    }


}
