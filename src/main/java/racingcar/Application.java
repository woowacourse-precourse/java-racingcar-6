package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        int time = 0;

        Screen.displayResultMessage();
        while (race.isRunning(time++)) {
            race.runOneRound();
            Screen.displayResult(race.getResult());
        }
        Screen.displayWinners(race.getWinners());
    }
}
