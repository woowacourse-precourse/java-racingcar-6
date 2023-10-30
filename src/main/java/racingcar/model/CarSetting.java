package racingcar.model;

import java.util.*;

public class CarSetting {
    private String[] carList;
    private int trialNumber;

    protected CarSetting(String inputCarName){
        carList = inputCarName.split(",");
    }

    public void setTrialNumber(int setInputValue){
        this.trialNumber = setInputValue;
    }


}
