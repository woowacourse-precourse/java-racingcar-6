package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.constant.RacingCarGameText;
import racingcar.number.Location;

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

    public int size() {
        return this.collection.size();
    }

    public String getMaxLocationCarName() {
        Location maxLocation = getMaxLocation();
        List<String> winners = getWinners(maxLocation);
        return String.join(RacingCarGameText.RACINGCAR_WINNERS_DELIMITER, winners);
    }

    private List<String> getWinners(Location maxLocation) {
        return this.collection.stream()
                .filter(car -> car.isSameLocation(maxLocation))
                .map(Car::getCarNameString)
                .collect(Collectors.toList());
    }

    private Location getMaxLocation() {
        return this.collection.stream()
                .map(Car::getCarLocation)
                .max(Location::compareTo).orElse(Location.fromInteger(0));
    }

    public void addFromString(String carNameString) {
        Car newCar = Car.fromString(carNameString);
        this.collection.add(newCar);
    }
}
