package controller;

import domain.CarFactory;
import domain.Race;
import infra.RandomCarEngine;
import java.util.List;
import view.View;

public class Controller {

    private final CarFactory carFactory = new CarFactory(new RandomCarEngine());

    public void run() {
        final List<String> carNames = View.renderAndReadName();
        final Race race = new Race(carFactory.generateCars(carNames));
        final int time = View.renderAndReadTime();

        View.renderResultHeader();
        for (int currentTime = 1; currentTime <= time; ++currentTime) {
            race.moveEachCars();
            View.renderResult(race.toStringEachCars());
        }
        View.renderWinner(race.toWinnerString());
    }

}
