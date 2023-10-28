package racingcar.model;

import java.util.List;

public class Race {
    private List<Car> cars;
    private int tryNum;

    public List<Car> getCars(){
        return cars;
    }
    public int getTryNum(){
        return tryNum;
    }
    public void setCars(List<Car> cars){
        this.cars = cars;
    }
    public void setTryNum(int tryNum){
        this.tryNum = tryNum;
    }
}
