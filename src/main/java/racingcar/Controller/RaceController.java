package racingcar.Controller;

import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RaceController {
    public static final String MOVE_FORWARD = "_";
    public void raceStart() {

        if (isMove(pickRandomNum()))
            movePosition(car);
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
}