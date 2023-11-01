package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class CarService {
    private boolean CanRun(){
        int dice = Randoms.pickNumberInRange(0, 9);

        if(dice >= 4){
            return true;
        }

        return false;
    }

    public void runOneTurn(List<Car> cars){
        for(Car car: cars) {
            if (CanRun()) {
                car.run();
            }
        }
    }

    public void showResults(List<Car> cars){
        for(Car car:cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
