package racingcar;

import static racingcar.CliPrompt.ENTER_CAR_NAMES;
import static racingcar.CliPrompt.NUMBER_OF_REPETITIONS;
import static racingcar.CliPrompt.RACE_RESULT;
import static racingcar.CliPrompt.WINNERS_ARE;

public class Application {

    private static final GameRule rule = new GameRule(5, 0, 9);
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
