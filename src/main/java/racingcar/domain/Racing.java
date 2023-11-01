package racingcar.domain;

import java.util.List;
public class Racing {

    final String BLANK_CAR_NAME = "";

    private List<Car> cars;
    private int round;

    public Racing(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getRound() {
        return this.round;
    }

    public void addRound() {
        this.round++;
    }

    public int compareDistance(int maxDistance, Car compareCar){
        if (maxDistance < compareCar.getMovement()) {
            return compareCar.getMovement();
        }
        return maxDistance;
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.cars) {
            maxDistance = compareDistance(maxDistance, car);
        }
        return maxDistance;
    }

    public String getTopRanker(int maxDistance, Car car) {
        if (maxDistance == car.getMovement()) {
            return car.getName() + ", ";
        }
        return BLANK_CAR_NAME;
    }

    public String getWinner() {
        String winner = "";
        int maxDistance = getMaxDistance();
        for (Car car : this.cars) {
            winner += getTopRanker(maxDistance, car);
        }
        return winner.substring(0, winner.length()-2);
    }
}
