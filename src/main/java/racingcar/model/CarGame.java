package racingcar.model;

import java.util.List;
import java.util.StringTokenizer;
import racingcar.util.RandomNum;

public class CarGame {
    private final List<Car> cars;
    private int playCount;

    public CarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void setCars(String name) {
        saveDivideName(name);
        Validation.name(cars);
    }

    public void setPlayCount(String playCount) {
        Validation.isPositiveInt(playCount);
        this.playCount = Integer.parseInt(playCount);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<String> getWinner() {
        int maxDistance = getMaxDistance();

        List<String> result = cars.stream()
                .filter(car -> maxDistance == car.getDistance())
                .map(Car::getName)
                .toList();
        return result;
    }

    private int getMaxDistance() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return maxDistance;
    }

    private void saveDivideName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name.trim(), ",");

        while (tokenizer.hasMoreTokens()) {
            String result = tokenizer.nextToken().trim();
            cars.add(new Car(result, 0));
        }
    }

    public void moveOrStop() {
        for (Car car : cars) {
            car.move(RandomNum.generate());
        }
    }
}
