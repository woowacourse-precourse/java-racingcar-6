package racingcar;

import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    TextView textView = new TextView();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Race race;
    private List<String> names = new ArrayList<>();
    private int tryNumber;

    public void game() {
        gameStart();
        textView.tryResult();
        getRace();
        getRaceResult();
    }

    public void gameStart() {
        textView.nameInput();
        String name = inputView.inputCarName();
        cutNames(name);
        textView.tryNumInput();
        tryNumber = inputView.inputTryNumber();
    }

    public void cutNames(String name) {
        String[] nameCut = name.split(",");
        for (int i = 0; i < nameCut.length; i++) {
            nameError(nameCut[i]);
            names.add(nameCut[i]);
        }
    }

    public void nameError(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void getRace() {
        race = new Race(names);
        for (int i = 0; i < tryNumber; i++) {
            roundRace();
            System.out.print("\n");
        }
    }

    public void roundRace() {
        race.playRound();
        List<Car> cars = race.getCars();
        for (Car car : cars) {
            outputView.roundResult(car.getPosition(), car.getName());
        }
    }

    public void getRaceResult() {
        race.maxPosition();
        race.whoWinner();
        textView.winner();
        if (race.getWinner().size() > 1) {
            outputView.someWinner(race.getWinner());
        } else {
            outputView.someWinner(race.getWinner());
        }
    }
}
