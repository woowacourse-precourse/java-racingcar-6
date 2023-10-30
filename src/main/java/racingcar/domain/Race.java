package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    List<String> carList;

    int attemptsNumber;

    List<Car> racingCars;

    public void initializationRace(List<String> carList,int attemptsNumber){
        this.carList=carList;
        this.attemptsNumber=attemptsNumber;
    }

    public void setRacingCars(){
        racingCars=new ArrayList<>();
        for(int i=0;i<carList.size();i++){
            racingCars.add(new Car(carList.get(i)));
        }
    }

    public int getAttemptsNumber() {
        return attemptsNumber;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
