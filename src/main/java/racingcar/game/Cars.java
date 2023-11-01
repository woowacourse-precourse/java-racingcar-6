package racingcar.game;

import racingcar.controller.Dice;
import racingcar.view.OutputView;
import static racingcar.controller.constants.IntegerConstants.*;
import static racingcar.controller.constants.DelimiterConstants.*;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    ArrayList<Car> cars = new ArrayList<>();

    public Cars(ArrayList<String> inputCarNames){
        inputCarNames.forEach(inputCarName -> cars.add(new Car(inputCarName)));
    }

    public void roundRace(){
        Dice dice = new Dice();

        for (Car car : cars) {
            if (dice.isCarCanGoForward()) {
                car.moveForward();
            }
            OutputView.broadcastCarRoundScore(car.getCarName(), car.getScore());
        }
    }

    public ArrayList<Car> getWinners(){
        ArrayList<Car> winners = new ArrayList<>();
        int winnerScore;
        int tempScore;

        for (Car car : cars) {
            if (winners.size() == EMPTY.getValue()) {
                winners.add(car);
                continue;
            }
            winnerScore = winners.get(STARTING_POINT.getValue()).getScore();
            tempScore = car.getScore();

            if (winnerScore < tempScore) {
                winners.clear();
                winners.add(car);
            }
            if (winnerScore == tempScore) {
                winners.add(car);
            }
        }
        return winners;
    }

    public String winnersToString(){
        List<String> carNames = carNamesToString(getWinners());
        return String.join(DELIMITER_WITH_BLANK.getValue(), carNames);
    }

    public List<String> carNamesToString(ArrayList<Car> cars){
        return cars.stream()
                .map(Car::getCarName)
                .toList();
    }
}
