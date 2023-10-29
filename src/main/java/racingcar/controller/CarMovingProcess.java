package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.RacingData;
import racingcar.view.RacingGameOutputs;

import java.util.ArrayList;
import java.util.List;

public class CarMovingProcess {

    Car car = Car.getInstance();
    RacingData racingData = RacingData.getInstance();

    public void carMovingView() {

        for (int carOrder = 0; carOrder < car.getPassedTestList().size(); carOrder++) {

            racingCarName(carOrder);

            for (int i = 0; i < racingData.getForwardPointList().get(carOrder); i++) {
                System.out.print(RacingGameOutputs.carMovingMotion);
            }

            System.out.println();

        }
    }

    public void racingCarName (int carOrder) {

        List<String> carNames = car.getPassedTestList();

        System.out.print(carNames.get(carOrder)+ " : ");

    }

    public void makingForwardCountList(){

        List<Integer> forwardCountList = new ArrayList<>();

        for (int i = 0; i < car.getPassedTestList().size(); i++) {
            forwardCountList.add(i ,0);
        }

        racingData.setForwardPointList(forwardCountList);
    }

    public void upDateForwardCountList(){

        int updateCount =0;

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

