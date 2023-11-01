package model;

import java.util.List;

public class RoundSet {

    private final List<Car> carList;
    private final int round;

    public RoundSet(CarList carList, Round round){
        this.carList = carList.getCarList();
        this.round = round.getRound();
    }
    public List<Car> getCarList() {
        return carList;
    }
    public int getRound() {
        return round;
    }
}
