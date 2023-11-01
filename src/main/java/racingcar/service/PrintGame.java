package racingcar.service;

import java.util.ArrayList;

public interface PrintGame {
    //초기화 시 프린트 하는 메서드
    void printInit();

    //시도할 횟수에 대한 프린트 하는 메서드
    void tryCount();

    // 게임 진행시 결과를 프린트 하는 메서드
    void printGame(String playerName, int goCount);

    // 게임 승리자를 프린트 하는 메서드
    void printWinner(ArrayList<String> names);
}
