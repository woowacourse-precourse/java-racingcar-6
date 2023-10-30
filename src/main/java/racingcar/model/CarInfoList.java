package racingcar.model;

import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static racingcar.model.Constants.IS_GO_FORWARD;

public class CarInfoList {

    List<String> carNameList;
    List<Integer> carPositionList;

    public CarInfoList(String userInputString) {
        this.carNameList = Arrays.asList(userInputString.split(","));
        for (String s : carNameList) {
            InputValidator.checkNameLength(s);
        }
        this.carPositionList = new ArrayList<>();
        for (int i=0;i<carNameList.size();i++) { carPositionList.add(0); }
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public Integer getCarNums() {
        return this.carNameList.size();
    }

    public List<Integer> getCarPositionList() {
        return carPositionList;
    }

    public void updateCarInfoList(List<Integer> carRandomOutputList) {
        System.out.println("carRandomOutputList : "+carRandomOutputList);
        for (int i=0;i<carRandomOutputList.size();i++) {
            if (carRandomOutputList.get(i) >= IS_GO_FORWARD) {
                this.carPositionList.set(i,carPositionList.get(i)+1);
            }
        }
    }

    public List<String> getWinnerList() {
        int maxPosition = Collections.max(carPositionList);
        List<String> winnerList = new ArrayList<>();
        for (int i=0;i<carPositionList.size();i++) {
            if (carPositionList.get(i) == maxPosition) {
                winnerList.add(carNameList.get(i));
            }
        }
        return winnerList;
    }

}