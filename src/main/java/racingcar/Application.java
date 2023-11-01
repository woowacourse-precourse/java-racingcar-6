package racingcar;

import controller.CarRace;
import controller.Race;
import domain.OneStepMoveStrategy;
import domain.RandomMoveJudgement;
import view.ConsoleInput;
import view.ConsoleOutput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new CarRace(
                new ConsoleInput(),
                new ConsoleOutput(),
                new RandomMoveJudgement(),
                new OneStepMoveStrategy());
        race.executeRace();
    }
}
