package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int topRank = 0;
        Set<ComparePositionState> stateSet = new HashSet<>();

        for (Car car : cars) {
            PairCompareResult compareResult = givenCar.comparePosition(car);
            ComparePositionState state = compareResult.state();

            stateSet.add(state);
            if (state == ComparePositionState.FRONT || state == ComparePositionState.SAME) {
                topRank = Integer.max(topRank, compareResult.position());
            }
        }

        if (stateSet.contains(ComparePositionState.FRONT)) {
            return new PairCompareResult(ComparePositionState.FRONT, topRank);
        }
        if (stateSet.contains(ComparePositionState.BACK)) {
            return new PairCompareResult(ComparePositionState.BACK, topRank);
        }
        return new PairCompareResult(ComparePositionState.SAME, topRank);
    }

    public List<Car> moveAll() {
        List<Car> result = new ArrayList<>();
        for(Car car:cars){
            car.moveByRandom();
            result.add(car);
        }
        return result;
    }

    public List<String> getWinnerNames(Integer topPosition) {
        List<String> result = new ArrayList<>();
        for(Car car:cars){
            if(car.isWinner(topPosition)){
                result.add(car.getName());
            }
        }
        return result;
    }
    public static Cars buildCars(List<String> names){
        List<Car> carList = new ArrayList<>();
        for(String name : names) {
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }
    public int getSize(){
        return cars.size();
    }
    public String getResult(int i) {
        return cars.get(i).resultMessage();
    }
}
