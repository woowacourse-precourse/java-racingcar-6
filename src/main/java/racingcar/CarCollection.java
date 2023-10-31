package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private ArrayList<Car> collection;

    private CarCollection() {
        this.collection = new ArrayList<>();
    }

    public static CarCollection initCarCollect() {
        return new CarCollection();
    }

    public void add(Car car) {
        this.collection.add(car);
    }

    public void batchMoveCarOnRandomCondition() {
        this.collection.stream().forEach(Car::moveCarOnRandomCondition);
    }

    public void batchDisplayCarStatus() {
        this.collection.stream().forEach(Car::displayCarLocation);
    }

    public int size(){
        return this.collection.size();
    }

    public String getMaxLocationCarName() {
        Location maxLocation = this.collection.stream()
                .map(Car::getCarLocation)
                .max(Location::compareTo).orElse(Location.fromInteger(0));

        List<String> winners = this.collection.stream()
                .filter(car -> car.isSameLocation(maxLocation))
                .map(Car::getCarName)
                .map(Name::getName)
                .collect(Collectors.toList());

        return String.join(RacingCarGameText.RACINGCAR_WINNERS_DELIMITER, winners);
    }

    public List<Name> getCarNameList() {
        return this.collection.stream().map(Car::getCarName)
                                    .collect(Collectors.toList());
    }
}
