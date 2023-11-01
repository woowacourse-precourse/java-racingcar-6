package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.RacingData;


import java.util.ArrayList;
import java.util.List;

public class CarMovingProcess {

    Car car = Car.getInstance();
    RacingData racingData = RacingData.getInstance();


    public void makingForwardCountList(){

        List<Integer> forwardCountList = new ArrayList<>();

        for (int i = 0; i < car.getPassedTestList().size(); i++) {
            forwardCountList.add(i ,0);
        }

        racingData.setForwardPointList(forwardCountList);
    }

    public void upDateForwardCountList(){

        int updateCount = 0;

        List<Integer> forwardCountList = racingData.getForwardPointList();

        for (int i = 0; i < car.getPassedTestList().size(); i++) {
            updateCount = forwardCountList.get(i) + moveOrNot();
            forwardCountList.set(i,updateCount);
        }

        racingData.setForwardPointList(forwardCountList);
    }

    public int makeRandomNum() {

       int randomNum = Randoms.pickNumberInRange(0,9);

       return randomNum;

    }

    public int moveOrNot() {

        int forwardPoint = 0;

        if(makeRandomNum() >= 4){
            forwardPoint++;
        }

        return forwardPoint;

    }

}

