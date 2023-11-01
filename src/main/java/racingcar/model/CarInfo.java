package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.Validation;

public class CarInfo {
    private final List<String> carName = new ArrayList<>();
    private final List<Integer> carStatus = new ArrayList<>();

    public List<Integer> getCarStatus() {
        return carStatus;
    }
    public List<String> getCarName() {
        return carName;
    }
    public int getMaxMove() {
        return Collections.max(carStatus);
    }
    public List<String> getWinnerName() {
        int maxMove = getMaxMove();
        List<String> maxMoveList = new ArrayList<>();
        for(int i = 0; i < carStatus.size(); i++) {
            if(carStatus.get(i) == maxMove) {
                maxMoveList.add(carName.get(i));
            }
        }
        return maxMoveList;
    }

    public void setCarName(String carName) {
        String[] splitStr = carName.split(",");
        Collections.addAll(this.carName, splitStr);
        for (String s : this.carName) {
            Validation.checkCarName(s);
        }
    }

    public boolean isMove(int randomNum) {
        return randomNum >= 4;
    }

    public void updateCarStatus(boolean isMove, int carIndex) {
        if(isMove){
            int newValue = carStatus.get(carIndex) + 1;
            carStatus.set(carIndex, newValue);
        }
    }

    public void initCarStatus() {
        for(int i = 0; i < carName.size(); i++){
            carStatus.add(0);
        }
    }
}
