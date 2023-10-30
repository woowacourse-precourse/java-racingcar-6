package racingcar.domain;

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
        if(carName.length()>5){
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    public void addCarName(String carName){
        carNameList.add(carName);
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
