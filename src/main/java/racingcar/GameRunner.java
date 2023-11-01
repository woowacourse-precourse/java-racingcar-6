package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.car.GameCount;
import racingcar.domain.car.Name;
import racingcar.domain.car.NameParser;
import racingcar.domain.car.Position;
import racingcar.domain.car.RacingGame;
import racingcar.domain.car.dto.RaceResult;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.io.ConsoleManager;
import racingcar.io.GameMessage;

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
        endGame(cars);
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
        consoleManager.printGameMessage(GameMessage.EXECUTE_RESULT);
        for(int i=0; i<count.getCount(); i++){
            List<RaceResult> results = racingGame.play(cars);
            consoleManager.printRaceResult(results);
        }
    }

    private void endGame(List<Car> cars){
        List<String> winners = racingGame.getWinners(cars);
        consoleManager.printWinner(winners);
    }

}

