package racingcar;

public class RacingGame {
    public RacingGame() {
        Player.inputCarName();
        Player.makeCarList(Player.getCarNames());
        Player.validateInput(Player.getCarList());
        Player.inputAttemptsCount();
        Leaderboard.makeCarInstanceList();
    }

    void run() {
        System.out.println("\n" + "실행 결과");
        for (int i = 0; i < Player.getAttempts(); i++) {
            Leaderboard.race();
            Leaderboard.printRaceProgress();
            System.out.println();
        }
        Leaderboard.printResult();
    }
}