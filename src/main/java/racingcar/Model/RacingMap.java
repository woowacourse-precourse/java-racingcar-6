package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class RacingMap {
    private List<Car> carList;
    private List<String> winner;

    public RacingMap(){
        carList = new ArrayList<>();
        winner = new ArrayList<>();
    }

    public void setCarList(List<Car> carList){
        this.carList = carList;
    }

    public void trial(){
        for(Car car: carList)
            car.trial();
    }

    public List<Car> getCarList(){
        return this.carList;
    }

    public void calWinner(){
        Car max = carList.get(0);
        for(Car car: carList)
            if(max.compareTo(car) < 0)
                max = car;
        for(Car car: carList)
            if(max.compareTo(car) == 0)
                winner.add(car.getName());
    }

    public List<String> getWinner(){
        if(winner.isEmpty())
            calWinner();
        return winner;
    }
}
