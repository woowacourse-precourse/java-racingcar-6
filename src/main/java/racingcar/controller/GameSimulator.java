package racingcar.controller;
import racingcar.model.Race;
import racingcar.model.Car;
import racingcar.view.ResultsPrinter;

public class GameSimulator {
    private final Race race;
    private final int tries;
    private ResultsPrinter resultsPrinter = new ResultsPrinter();


    public GameSimulator(Race race, int tries) {
        this.race = race;
        this.tries = tries;
    }

    public void runRace() {
        for (int i = 0; i < tries; i++) {
            //System.out.println("this");
            for (Car car : race.getCars()) {
                car.move();
            }
            if(i!=0){
                resultsPrinter.printResults(race);
            }
        }
    }
}
