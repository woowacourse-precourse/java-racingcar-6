package racingcar.Controller;

import racingcar.CarManager;
import racingcar.domain.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RaceController {
    private static CarManager carManager;
    private List<Car> carList;
    public static final String MOVE_FORWARD = "_";
    public void raceStart() {
        carList =carManager.getCarList();
        for (Car car : carList) {
            if (isMove(pickRandomNum()))
                movePosition(car);
            printPosition(car);
        }
    }


    private int pickRandomNum(){
        return pickNumberInRange(1,9);
    }
    private boolean isMove(int RandomNum){
        if(RandomNum>=4) return true;
        return false;
    }
    private void movePosition(Car car) {
        String position=car.getCurrentPosition();
        position+=MOVE_FORWARD;
        car.setCurrentPosition(position);
    }
    private void printPosition(Car car) {
    }
    public void setCarList(CarManager carManager) {
        this.carManager = carManager;
    }
}