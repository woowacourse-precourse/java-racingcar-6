package racingcar;

public class Game {

    static void run() {
        View.makeCarList();
        View.inputAttemptsCount();
        Leaderboard.makeCarInstanceList();
        System.out.println("실행 결과");
        for (int i = 0; i < View.getAttempts(); i++) {
            Leaderboard.race();
            Leaderboard.printRaceProgress();
            System.out.println();
        }
        System.out.println(Leaderboard.printResult());
    }
}
