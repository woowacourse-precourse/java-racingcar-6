package racingcar.domain.referee;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.valueobject.CarLocation;

public class InGameReferee {
    private final int LOWER_LIMIT = 4;

    public int getLOWER_LIMIT_Fortest() {
        return LOWER_LIMIT;
    }

    public boolean isBiggerLowerLimit(int generatedNumber) {
        return generatedNumber >= LOWER_LIMIT;
    }

    public List<Car> findWinner(List<Car> carList) {
        List<Car> winner = new ArrayList<>();

        CarLocation maxLocation=findBiggest(carList);
        for (Car car : carList) {
            if(car.getLocation().equals(maxLocation)){
                winner.add(car);
            }
        }

        return winner;
    }

    private CarLocation findBiggest(List<Car> carList){
        CarLocation maxLocation=new CarLocation();

        for (Car car : carList) {
            if(car.getLocation().getInteger()>maxLocation.getInteger()){
                maxLocation=car.getLocation();
            }
        }

        return maxLocation;
    }
}
