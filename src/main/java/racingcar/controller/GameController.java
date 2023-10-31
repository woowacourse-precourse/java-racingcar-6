package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.CarView;

import java.util.ArrayList;

public class GameController {
    private Race race;
    private CarView view;
    private ReceiveController receive;

    public GameController() {
        this.receive = new ReceiveController();
    }

    public void playGame() {
        /* Receive car names and number of moves */
        ArrayList<String> carNames = receive.carNames();
        int moves = receive.moveNum();

        /* Initialize race */
        race = new Race(carNames);

        /* Start real race */
        startRace(moves);
        announceWinners();
    }

    private void startRace(int moves) {
        for (int i = 0; i < moves; i++) {
            race.moveCars();
            view.printRaceResult(race.getCars());
        }
    }

    private void announceWinners() {
        System.out.println("실행 결과");
        ArrayList<Car> winners = getWinners();
        view.printWinners(winners);
    }

    private ArrayList<Car> getWinners() {
        int maxPosition = 0;
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : race.getCars()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void setView(CarView view) {
        this.view = view;
    }
}
