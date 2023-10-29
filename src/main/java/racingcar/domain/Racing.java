package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> carList;
    private int maxLocation;

    public void moveCars(){
        for(int i = 0; i< carList.size(); i++){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            int afterLocation = carList.get(i).moves(randomNumber);
            if(maxLocation < afterLocation){
                maxLocation = afterLocation;
            }
        }
    }

    public void addCar(Car car){
        carList.add(car);
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        for(Car car: carList){
            if(car.getLocation() == maxLocation){
                winners.add(car);
            }
        }
        return winners;
    }
}
