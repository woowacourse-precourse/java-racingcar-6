package racingcar.Controller;

import racingcar.CarManager;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RaceController {
    private static CarManager carManager;
    private List<Car> carList;
    public static final String MOVE_FORWARD = "-";
    public void raceStart() {
        carList =carManager.getCarList();
        for (Car car : carList) {
            if (isMove(pickRandomNum()))
                movePosition(car);
            printPosition(car);
        }
        System.out.println("");
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
        System.out.println(car.getName()+" : "+car.getCurrentPosition());
    }
    public void setCarList(CarManager carManager) {
        this.carManager = carManager;
    }
    public List<String> getWinner() {
        int longestDistance=getLongestPosition();
        return getWinnerName(longestDistance);
    }
    private int getLongestPosition() {
        String longestPosition="";
        for (Car car : carList) {
            String position = car.getCurrentPosition();
            if(longestPosition.length() <position.length())
                longestPosition=position;
        }
        return longestPosition.length();
    }
    private List<String> getWinnerName(int longestDistance) {
        List<String> Winners = new ArrayList<>();
        for (Car car : carList) {
            String position = car.getCurrentPosition();
            if(longestDistance==position.length())
                Winners.add(car.getName());
        }
        return Winners;
    }
}