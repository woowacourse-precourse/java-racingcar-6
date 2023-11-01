package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;

public class CarPlayGameImpl implements PlayGame {

    private CarPrintGame carPrintGame;
    private int round;
    private ArrayList<Player> players;

    final static int RUN_OR_STOP_STANDARD = 3;

    public CarPlayGameImpl(CarPrintGame carPrintGame) {
        this.carPrintGame = carPrintGame;
        this.round = 0;
        this.players = new ArrayList<>();
    }

    @Override
    public void initGame() {
        carPrintGame.printInit();
        String inputPlayers = Console.readLine();
        String[] names = inputPlayers.split(",");
        initPlayers(names);
        carPrintGame.tryCount();
        round = Integer.parseInt(Console.readLine());
    }

    @Override
    public void initPlayers(String[] names) {
        for (int loop = 0; loop < names.length; ++loop) {
            validCheck(names[loop]);
            players.add(new Player(names[loop]));
        }
    }

    @Override
    public void playGame() {
        initGame();

        for (int loop = 0; loop < round; ++loop) {
            playRound();
            System.out.println();
        }

        int winnerCount = getCurrentWinnerCount();

        endGame(winnerCount);
    }

    @Override
    public void playRound() {
        for (int loop = 0; loop < players.size(); ++loop) {
            Player currentPlayer = players.get(loop);
            if (canIGo()) currentPlayer.addWinCount();
            carPrintGame.printGame(currentPlayer.name, currentPlayer.winCount);
        }
    }

    @Override
    public void endGame(int winnerCount) {
        ArrayList<String> winnerList = new ArrayList<>();

        for (int loop = 0; loop < players.size(); ++loop) {
            if (players.get(loop).winCount == winnerCount) {
                winnerList.add(players.get(loop).name);
            }
        }

        carPrintGame.printWinner(winnerList);
    }

    private void validCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자이하 여야 합니다.");
        }
    }

    // 랜덤으로 값을 뽑아 전진이 가능한지 확인하는 메서드
    // 4 이상 부터 전진한다.
    private boolean canIGo() {
        int result = Randoms.pickNumberInRange(0, 9);
        return result > RUN_OR_STOP_STANDARD;
    }

    // 현재 가장 많이 전진한 사람의 count를 가져오는 메서드
    private int getCurrentWinnerCount() {
        int maxGoCount = 0;

        for (int loop = 0; loop < players.size(); ++loop) {
            maxGoCount = max(maxGoCount, players.get(loop).winCount);
        }

        return maxGoCount;
    }
}
