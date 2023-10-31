package racingcar.game;

import racingcar.controller.Dice;
import racingcar.view.OutputView;
import static racingcar.controller.constants.IntegerConstants.*;
import static racingcar.controller.constants.DelimiterConstants.*;

import java.util.ArrayList;

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

    private ArrayList<Car> getMaxOfScores(){
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (winners.size() == EMPTY.getValue()) {
                winners.add(car);
                continue;
            }
            int winnerScore = winners.get(STARTING_POINT.getValue()).getScore();
            int tempScore = car.getScore();

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

    public void getWinners(){
        // TODO: 위치를 고민해 봐야 할 메서드
        OutputView.finalGameResult(winnersToString(getMaxOfScores()));
    }

    public String winnersToString(ArrayList<Car> winners){
        ArrayList<String> carNames = getCarNames(winners);
        return String.join(DELIMITER_WITH_BLANK.getValue(), carNames);
    }

    public ArrayList<String> getCarNames(ArrayList<Car> cars) {
        ArrayList<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getCarName());
        }
        return carNames;
    }
}
