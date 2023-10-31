package racingcar.game;

import racingcar.controller.Dice;
import racingcar.view.OutputView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cars {
    ArrayList<Car> cars = new ArrayList<>();

    public Cars(ArrayList<String> inputList){
        for (String s : inputList) {
            cars.add(new Car(s));
        }
    }

    public void roundRace(){
        Dice dice = new Dice();

        for (Car car : cars) {
            if (dice.rollTheDice()) {
                car.moveForward();
            }
            car.stop();
            broadcastGameRound(car);
        }
    }

    public void broadcastGameRound(Car car){
        // TODO: 위치를 고민 해 봐야 할 메서드
        OutputView.broadcastUserBoardOfRound(car);
    }

    private ArrayList<Car> getMaxOfScores(){
        // TODO: 상수 교체
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (winners.size() == 0) {
                winners.add(car);
                continue;
            }
            int winnerScore = winners.get(0).getScore();
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
        return String.join(", ", carNames);
    }

    public ArrayList<String> getCarNames(ArrayList<Car> cars) {
        ArrayList<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getCarName());
        }
        return carNames;
    }
}
