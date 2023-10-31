package racingcar;

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
        Prompt.println("\n\n", raceResult);

        List<String> raceWinners = computer.findWinner();
        Prompt.WINNER_MESSAGE.print();
        Prompt.print(", ", raceWinners);
    }
}
