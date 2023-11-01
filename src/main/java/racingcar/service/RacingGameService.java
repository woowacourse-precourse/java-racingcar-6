package racingcar.service;

import racingcar.common.Message;
import racingcar.entity.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private List<Car> entry;
    private int remainChance;
    private InputView inputView;
    private OutputView outputView;
    private Moving moving;

    public void init() {
        inputView = new InputView();
        outputView = new OutputView();
        moving = new Moving();
        entry = new ArrayList<>();
        remainChance = 0;
    }

    public void start() {
        setCars();
        setRemainChange();
        outputView.printMessage(Message.RESULT);
        mainSequence();
    }

    private void mainSequence() {
        while (remainChance > 0) {
            movingSequence();
            remainChance--;
            outputView.printCarScores(entry);
        }
        endSequence();
    }

    private void movingSequence() {
        for (Car car : entry) {
            moving.moveOrStop(car);
        }
    }

    private void endSequence() {
        int maxDistance = getMaxDistance();
        List<String> winners = entry.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName).toList();

        outputView.printWinner(winners);
    }

    private void setCars() {
        outputView.printMessage(Message.START);
        inputView.getCarsName().forEach(name -> entry.add(new Car(name)));
    }

    private void setRemainChange() {
        outputView.printMessage(Message.COUNT);
        remainChance = inputView.getPlayCount();
    }

    private int getMaxDistance() {
        int max = 0;

        for (Car car : entry) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }

}
