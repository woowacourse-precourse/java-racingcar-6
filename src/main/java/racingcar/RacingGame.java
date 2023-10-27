package racingcar;

import java.util.ArrayList;

public class RacingGame {

    public static void initializeGame() {
        OutputView.printStartMessage();
    }

    public static ArrayList<Cars> insertPlayer() {
        ArrayList<Cars> players = new ArrayList<>();
        ArrayList<String> cars = InputView.getCarsName();
        for (String car : cars) {
            Cars user = new Cars(car);
            players.add(user);
        }
        return players;
    }

    public static void startRacing(ArrayList<Cars> racingPlayers, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            GameModel.tryOneCycle(racingPlayers); // 한번 반복할때마다 나아갈지 말지 결정
            OutputView.printSingleGame(racingPlayers);
            System.out.println(); // 개행
        }
    }

    public static void racingGame() {
        initializeGame();
        ArrayList<Cars> racingPlayers = insertPlayer();

        OutputView.printAskTryNumber();

        int tryNumber = Integer.parseInt(InputView.getTryNumber());

        OutputView.printResultMessage();

        startRacing(racingPlayers, tryNumber);

        ArrayList<String> finalWinner = GameModel.decideFinalWinner(racingPlayers);

        OutputView.printFinalWinner(finalWinner);
    }
}
