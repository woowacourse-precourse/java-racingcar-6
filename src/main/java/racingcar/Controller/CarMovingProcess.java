package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.Model.RacingData;


import java.util.ArrayList;
import java.util.List;

public class CarMovingProcess {
    
    RacingData racingData = RacingData.getInstance();


    public List<Integer> makingForwardCountList(List<String> carNameList){

        List<Integer> forwardCountList = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); i++) {
            forwardCountList.add(i ,0);
        }

        racingData.setForwardPointList(forwardCountList);
        return forwardCountList;
    }


    public List<Integer> upDateForwardCountList(List<Integer> beforePointList){

        int updateCount = 0;

        List<Integer> forwardCountList = beforePointList;

        for (int i = 0; i < beforePointList.size(); i++) {
            updateCount = forwardCountList.get(i) + moveOrNot();
            forwardCountList.set(i,updateCount);
        }

        racingData.setForwardPointList(forwardCountList);
        return forwardCountList;
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

