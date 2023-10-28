package racingcar.model;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars ;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    public Integer getTopPosition() {
        int topPosition= 0 ;
        for(Car car : cars) {
            PairCompareResult cp = this.comparePosition(car);
            if(cp.state().equals(ComparePositionState.FRONT)) {
                topPosition = Integer.max(topPosition, cp.position());
            }
            if(cp.state().equals(ComparePositionState.SAME)) {
                return cp.position();
            }
        }
        return topPosition;
    }

    public PairCompareResult comparePosition(Car givenCar) {
        int topLank = 0 ;
        List<ComparePositionState> csList  = new ArrayList<>();
        for(Car car : cars) {
            PairCompareResult compareResult = givenCar.comparePosition(car);
            if(compareResult.state().equals(ComparePositionState.FRONT)) {
                topLank = Integer.max(topLank,compareResult.position());
                csList.add(ComparePositionState.FRONT);
            }
            if(compareResult.state().equals(ComparePositionState.SAME)) {
                topLank = Integer.max(topLank,compareResult.position());
                csList.add(ComparePositionState.SAME);
            }
            if(compareResult.state().equals(ComparePositionState.BACK)){
                csList.add(ComparePositionState.BACK);
            }
        }

        if(csList.contains(ComparePositionState.FRONT)) {
            return new PairCompareResult(ComparePositionState.FRONT,topLank);
        }

        if(csList.contains(ComparePositionState.BACK)){
            return new PairCompareResult(ComparePositionState.BACK ,topLank);
        }

        return new PairCompareResult(ComparePositionState.SAME,topLank);
    }
}
