package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.car.GameCount;
import racingcar.domain.car.Name;
import racingcar.domain.car.NameParser;
import racingcar.domain.car.Position;
import racingcar.domain.car.RacingGame;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.io.ConsoleManager;

import java.util.List;

import static racingcar.util.StringConverter.*;

public class GameRunner {
    private final ConsoleManager consoleManager;
    private final NameParser nameParser;
    private final RacingGame racingGame;

    public GameRunner(){
        consoleManager = new ConsoleManager();
        nameParser = new NameParser();
        racingGame = new RacingGame(new RandomNumberGenerator());
    }

    public void run(){
        List<Car> cars= createCars(readCarNames());
        GameCount count = readGameCount();
        playGame(cars, count);
    }

    private List<Car> createCars(List<Name> names){
        return names.stream()
                .map(n -> new Car(n,new Position(0)))
                .toList();
    }

    private List<Name> readCarNames(){
        String line = consoleManager.readCarNames();
        return nameParser.parseName(line);
    }

    private GameCount readGameCount(){
        String strCount = consoleManager.readGameCount();
        return new GameCount(toInteger(strCount));
    }

    private void playGame(List<Car> cars, GameCount count){
        for(int i=0; i<count.getCount(); i++){
            racingGame.play(cars);
        }
    }

}

