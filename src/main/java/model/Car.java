package model;

import camp.nextstep.edu.missionutils.Randoms;
import constants.GameConstant;

public class Car {
    private String name;
    private int stepCount;

    public Car(){}
    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStepCount() {
        return stepCount;
    }

    /**
     * 전진 가능한 Random 수 얻기
     *
     * @return 0에서 9 사이에서 무작위 정수 값 반환
     */
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    /**
     * 랜덤 수 전진 판단하기
     * 무작위 값이 4 이상일 경우 한칸 전진 한다.
     *
     * @return 4 이상일 경우 true, 아닐 경우 false
     */
    public boolean isStepForward(int randomNumber){
        if(randomNumber < GameConstant.MIN_STEP_COUNT){
            return false;
        }
        return true;
    }

    public void MoveForward(){
        this.stepCount++;
    }


}
