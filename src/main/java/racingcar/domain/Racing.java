package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    private List<Car> cars;
    private int maxLocation;

    public void moveCars(){
        for(int i=0; i<cars.size(); i++){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            cars.get(i).moves(randomNumber);
        }
    }

    public void addCar(Car car){
        cars.add(car);
    }

}
