package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingCarResult {
    private HashMap<String, List<Integer>> carPositionMap = new HashMap<>();
    private List<String> carNameList;
    private Integer tryNumber;

    public RacingCarResult(List<String> carNameList, Integer tryNumber) {
        this.tryNumber = tryNumber;
        this.carNameList = carNameList;
        initializeCarPositionMap(carNameList);
    }

    public HashMap<String, List<Integer>> getCarPositionMap() {
        raceCar();
        return carPositionMap;
    }

    private void initializeCarPositionMap(List<String> carNameList) {
        for (String carName:carNameList) {
            List<Integer> positionList = new ArrayList<>();
            positionList.add(0);
            carPositionMap.put(carName, positionList);
        }
    }

    public void raceCar() {
        for (int i=0;i<tryNumber;i++) {
            moveAllCarOnce();
        }
    }

    private void moveAllCarOnce() {
        for (String carName:carNameList) {
            addCarMoveOnce(carName);
        }
    }

    private void addCarMoveOnce(String carName) {
        List<Integer> positionList = carPositionMap.get(carName);
        int beforePositionListSize = positionList.size();
        int beforeValue = positionList.get(positionList.size()-1);

        if (isMove()) {
            positionList.add(beforeValue+1);
        }

        int afterPositionListSize = positionList.size();
        if (beforePositionListSize == afterPositionListSize) {
            positionList.add(beforeValue);
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
