package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carName;

    private List<String> carNameList;

    private int position;

    private final static int START_INCLUSIVE=0;

    private final static int END_INCLUSIVE=9;

    private final static int ALLOWABLE_NAME_LENGTH=5;

    private final static int MIN_FORWARD_MOVEMENT=4;

    public Car(){
        carNameList=new ArrayList<>();
    }

    public Car(String carName){
        validateCarNameLength(carName);
        this.carName=carName;
        this.position=0;
    }

    private static void validateCarNameLength(String carName) {
        if(carName.length()>ALLOWABLE_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    public void addCarName(String carName){
        carNameList.add(carName);
    }

    public void forwardOrStop(){
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        moveForward(randomNumber);
    }

    private void moveForward(int randomNumber) {
        if(canMoveForward(randomNumber)){
            position++;
        }
    }

    private boolean canMoveForward(int randomNumber) {
        if(randomNumber>=MIN_FORWARD_MOVEMENT){
            return true;
        }
        return false;
    }



    public String getCarName() {
        return carName;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public int getPosition() {
        return position;
    }
}
