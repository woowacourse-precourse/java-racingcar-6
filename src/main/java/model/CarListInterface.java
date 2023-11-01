package model;

import java.util.List;

public interface CarListInterface {

    void setCarList(List<String> carList);
    List<String> getCarList();
    void forwardCar(String carName);
    int getLocation(String carName);
}
