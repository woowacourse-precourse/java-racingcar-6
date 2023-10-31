package racingcar;

public class Application {

    private static final Computer computer = new Computer();

    public static void main(String[] args) {
        String racingCarInput = Prompt.RACING_CAR_INPUT_MESSAGE.read();
        computer.readCarNames(racingCarInput);

        String roundInput = Prompt.ROUND_INPUT_MESSAGE.read();
        computer.readRound(roundInput);

        Prompt.RESULT_MESSAGE.println("\n", "");
        String raceResult = computer.startRace();
        System.out.println(raceResult);

        String winner = computer.findWinner();
        Prompt.WINNER_MESSAGE.print("", winner);
    }
}
