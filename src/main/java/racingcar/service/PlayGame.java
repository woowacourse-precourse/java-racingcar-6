package racingcar.service;

import java.util.ArrayList;

public interface PlayGame {
    // 게임 셋팅
    void initGame();

    // 플레이어 값 초기화
    void initPlayers(ArrayList<String> names);

    // 게임의 전체 진행을 위한 메서드
    void playGame();

    // 게임의 각 라운드를 위한 메서드
    void playRound();

    // 게임 종료시 호출될 메서드
    void endGame(int winnerCount);
}
