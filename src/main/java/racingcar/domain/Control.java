package racingcar.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Control {

    private final String carName;
    private final ArrayList<String> status;

    public Control(String carName, ArrayList<String> status){
        this.carName = carName;
        this.status = status;
    }

    public boolean carForwardCondition(){
        return false;
    }
}
