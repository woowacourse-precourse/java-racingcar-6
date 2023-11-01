package racingcar;

import static racingcar.underhood.CliPrompt.ENTER_CAR_NAMES;
import static racingcar.underhood.CliPrompt.NUMBER_OF_REPETITIONS;
import static racingcar.underhood.CliPrompt.RACE_RESULT;
import static racingcar.underhood.CliPrompt.WINNERS_ARE;

import racingcar.underhood.CarRecord;
import racingcar.underhood.CliOutput;
import racingcar.underhood.ConsoleReader;
import racingcar.underhood.GameRule;
import racingcar.underhood.NumberOfRepetitions;
import racingcar.underhood.Race;

public class Application {

    private static final GameRule rule = new GameRule(0, 9);
    private static final ConsoleReader consoleReader = new ConsoleReader(rule);
    private static final Race race = new Race(rule);
    private static final CliOutput cliOutput = new CliOutput();

    public static void main(String[] args) throws IllegalArgumentException {
        cliOutput.printPrompt(ENTER_CAR_NAMES);
        race.registerRacers((CarRecord) consoleReader.readPureWords());
        cliOutput.printPrompt(NUMBER_OF_REPETITIONS);
        rule.setNumberOfRepetitions((NumberOfRepetitions) consoleReader.readPureNumber());
        cliOutput.printPrompt(RACE_RESULT);
        race.start();
        cliOutput.printMsgWithPrompt(WINNERS_ARE, race.winners());
    }
}
