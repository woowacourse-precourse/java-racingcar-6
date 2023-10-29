package racingcar.game;

import static racingcar.input.Count.inputCount;
import static racingcar.input.Count.raceCount;
import static racingcar.input.Name.inputName;
import static racingcar.input.Name.carName;
import racingcar.race.Race;

import java.util.List;

public class Game {
    public void runGame() {
        Race race = new Race();
        List<String> names = carName(inputName());
        race.saveName(names);
        int num = raceCount(inputCount());
        printResult();
        for (int i = 0; i < num; i++) {
            race.goFoward();
            race.printRace();
        }
        race.printWinner();
    }
    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
