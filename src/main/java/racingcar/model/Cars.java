package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars ;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    public Integer getTopPosition() {
        OptionalInt samePosition = cars.stream()
                .map(this::comparePosition)
                .filter(cp -> cp.state() == ComparePositionState.SAME)
                .mapToInt(PairCompareResult::position)
                .findFirst();

        if (samePosition.isPresent()) {
            return samePosition.getAsInt();
        }

        return cars.stream()
                .map(this::comparePosition)
                .filter(cp -> cp.state() == ComparePositionState.FRONT)
                .mapToInt(PairCompareResult::position)
                .max()
                .orElse(0);
    }

    public PairCompareResult comparePosition(Car givenCar) {
        Set<ComparePositionState> stateSet = cars.stream()
                .map(givenCar::comparePosition)
                .map(PairCompareResult::state)
                .collect(Collectors.toSet());

        int topRank = cars.stream()
                .map(givenCar::comparePosition)
                .filter(cp -> cp.state() == ComparePositionState.FRONT || cp.state() == ComparePositionState.SAME)
                .mapToInt(PairCompareResult::position)
                .max()
                .orElse(0);

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
