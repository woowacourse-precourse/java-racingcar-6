package racingcar;

import static racingcar.Properties.COMMA_TRAILING_SPACE;
import static racingcar.Properties.LINE_SEPARATOR_TWICE;

import java.util.List;

public class Application {

    private static final Computer computer = new Computer();

    public static void main(String[] args) {
        String racingCarInput = Prompt.RACING_CAR_INPUT_MESSAGE.read();
        computer.readCarNames(racingCarInput);

        String roundInput = Prompt.ROUND_INPUT_MESSAGE.read();
        computer.readRound(roundInput);

        List<String> raceResult = computer.startRace();
        Prompt.RESULT_MESSAGE.println();
        Prompt.println(LINE_SEPARATOR_TWICE, raceResult);

        List<String> raceWinners = computer.findWinner();
        Prompt.WINNER_MESSAGE.print();
        Prompt.print(COMMA_TRAILING_SPACE, raceWinners);
    }
}
