package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.message.GameMessage;
import racingcar.vo.Car;

public class CarPark {
    private List<Car> park;

    public CarPark(List<Car> park) {
        this.park = park;
    }

    public List<String> makeNameList() {
        return park.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getPark() {
        return park;
    }

    public void UpdateCarParkState(List<Car> park) {
        this.park = park;
    }

    public List<String> getCarScores() {
        return park.stream().map(Car::getScoreBoard).collect(Collectors.toList());
    }

    private List<String> getWinnerCars() {
        int maxScore = -1;
        List<String> winnerList = new ArrayList<>();
        for (Car car : park) {
            maxScore = updateMaxScore(maxScore, winnerList, car);
        }

        return winnerList;
    }

    private static int updateMaxScore(int maxScore, List<String> winnerList, Car car) {
        if (car.isScoreBiggerThanMaxScore(maxScore).equals("Bigger")) {
            maxScore = car.getScore();
            winnerList.clear();
            winnerList.add(car.getName());
        } else if (car.isScoreBiggerThanMaxScore(maxScore).equals("Equal")) {
            winnerList.add(car.getName());
        }
        return maxScore;
    }

    public String getWinnerList() {
        List<String> winnerCars = getWinnerCars();
        String winnerMessage = GameMessage.WINNER_MESSAGE.getMessage();
        return winnerMessage + String.join(", ", winnerCars);
    }
}
