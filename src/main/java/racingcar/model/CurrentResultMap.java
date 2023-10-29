package racingcar.model;

import java.util.List;

public class CurrentResultMap {
    private final static String moveUnit = "-";
    private final static String printMoveFormat = "%s : %s\n";
    private String currentResultMap = "";

    public String getCurrentResultMap(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            int moveDistance = car.getMoveDistance();
            String moveUnits = moveUnit.repeat(moveDistance);
            currentResultMap += String.format(printMoveFormat, carName, moveUnits);
        }
        return currentResultMap;
    }
}
