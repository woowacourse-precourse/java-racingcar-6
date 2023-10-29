package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    private List<Car> cars;
    private int count;
    private int maxLocation;
    public Racing(List<Car> cars, int count){
        this.count = count;
    }

    public void run(){
        for(int i=0; i<cars.size(); i++){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            cars.get(i).moves(randomNumber);
        }
    }

    public void addCar(Car car){
        cars.add(car);
    }

}
