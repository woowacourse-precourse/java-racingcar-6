package domain;

import validate.ValidateWinner;
import java.util.List;
import static constant.GameUserInterface.*;
import static validate.ValidateGo.validateGoStop;

//carName 가진 것 마다 각자의 distance를 가지고 있어야함!
public class Car {

    public String carname="";
    private String distance="";


    Car(){
        //횟수 반복
    }

    public void setCarname(String carName) {
        carname = carName;
    }
    public String getCarname(){
        return carname;
    }
    public void appendDistance(){
        if(validateGoStop())
            distance+=RACING_DISTANCE.getUserInterface();
    }
    public String getDistance(){
        return distance;
    }
}
