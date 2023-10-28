package racingcar.model;

import java.util.List;

public class Cars {
    List<Car> cars ;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public PairCompareResult comparePosition(Car givenCar) {
        int topLank = 0 ;
        PairCompareResult out = new PairCompareResult(ComparePositionState.BACK ,topLank);
        for(Car car : cars) {
            PairCompareResult compareResult = givenCar.comparePosition(car);
            if(compareResult.state().equals(ComparePositionState.FRONT)) {
                topLank = Integer.max(topLank,compareResult.position());
                out = new PairCompareResult(ComparePositionState.FRONT,topLank);
            }
            if(compareResult.state().equals(ComparePositionState.SAME)) {
                topLank = Integer.max(topLank,compareResult.position());
                out = new PairCompareResult(ComparePositionState.SAME,topLank);
            }
        }
        return out;
    }

}
