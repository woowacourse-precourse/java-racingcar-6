package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarGame {
    private final List<Cars> cars = new ArrayList<>();
    private int playCount;

    public void setCars(String name) {
        divideName(name);
        Validation.name(cars);
    }

    public List<Cars> getCars() {
        return cars;
    }

    public void setPlayCount(String playCount) {
        Validation.isPositiveInt(playCount);
        this.playCount = Integer.parseInt(playCount);
    }

    public int getPlayCount() {
        return playCount;
    }

    private void divideName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name.trim(), ",");

        while (tokenizer.hasMoreTokens()) {
            String result = tokenizer.nextToken().trim();
            cars.add(new Cars(result, 0));
        }
    }

    public void moveOrStop() {
        for (Cars car : cars) {
            car.move(RandomNum.generate());
        }
    }


    public List<String> getWinner() {
        int maxDistance = getMaxDistance();

        List<String> result = cars.stream()
                .filter(car -> maxDistance == car.getDistance())
                .map(Cars::getName)
                .toList();
        return result;
    }

    private int getMaxDistance() {
        int maxDistance = cars.stream()
                .mapToInt(Cars::getDistance)
                .max()
                .orElse(0);

        return maxDistance;
    }
}
