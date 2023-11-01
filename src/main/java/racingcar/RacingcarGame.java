package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.*;

public class RacingcarGame {

    private RacingCars cars;
    private int tryCount;

    private RandomNumberGenerator randomNumberGenerator;

    public RacingcarGame() {
        this.cars = new RacingCars();
        this.tryCount = 0;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void setCars(String[] carsName) {
        cars.setRacingCars(carsName);
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public HashMap<String, Integer> race() {
        moveOrStop();
        HashMap<String, Integer> raceResult = new HashMap<>();
        for (Car car : cars.getRacingCars()) {
            raceResult.put(car.getName(), car.getDistance());
        }
        return raceResult;
    }

    private void moveOrStop() {
        List<Car> RacingCars = cars.getRacingCars();
        for (Car car : RacingCars) {
            int num = randomNumberGenerator.getRandomNumber();
            car.moveOrStop(num);
        }
        tryCount -= 1;
    }

    public Boolean isContinue() {
        if (tryCount == 0) {
            return false;
        }
        return true;
    }

    public String getWinner() {
        int maxDistance = getMaxDistance();
        List<Car> racingCars = cars.getRacingCars();
        List<Car> winners = racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
        if (!isJointWinner(winners) && maxDistance != 0) {
            return winners.get(0).getName();
        } else if (isJointWinner(winners) && maxDistance != 0) {
            return winnerStringJoin(winners);
        } else {
            return null;
        }
    }

    private int getMaxDistance() {
        List<Car> racingCars = cars.getRacingCars();
        Comparator<Car> comparatorByDistance = Comparator.comparingInt(Car::getDistance);
        Optional<Car> maxDistance = racingCars.stream().max(comparatorByDistance);
        return maxDistance.map(Car::getDistance).orElse(0);
    }

    private Boolean isJointWinner(List<Car> winnerList) {
        if (winnerList.size() > 1) {
            return true;
        }
        return false;
    }

    private String winnerStringJoin(List<Car> winners) {
        StringJoiner stringJoiner = new StringJoiner(",");
        winners.forEach(car -> stringJoiner.add(car.getName()));
        return stringJoiner.toString();
    }
}
