package domain;

import static constant.GameUserInterface.*;
import static validate.ValidateGo.validateGoStop;

//carName 가진 것 마다 각자의 distance를 가지고 있어야함!
public class Car {

    private String carname = "";
    private String distance = "";

    public Car() {
    }
    //객체 배열로 넣기 위해서 public 혹은 비지정 해야함

    public void setCarName(String carName) {
        carname = carName;
    }

    public String getCarName() {
        return carname;
    }

    public void appendDistance() {
        if (validateGoStop()) {
            distance += RACING_DISTANCE.getUserInterface();
        }
    }

    public String getDistance() {
        return distance;
    }

}
