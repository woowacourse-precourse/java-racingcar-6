package racingcar.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameStateModel {
    Map<String, List<Integer>> gameState = new HashMap<>();     // 회차 무작위값 기록
    Map<String, List<Integer>> forwardState = new HashMap<>();  // 회차 자동차 위치 기록
    final int FORWARD_NUM = 4;

    public void setGameState(Map<String, List<Integer>> stateInput) {
        gameState = stateInput;
    }

    public void setForwardState(Map<String, List<Integer>> forwardStateInput) {
        this.forwardState = forwardStateInput;
    }

    public Map<String, List<Integer>> getGameState() {
        return gameState;
    }

    public Map<String, List<Integer>> getForwardState() {
        return forwardState;
    }

    public void updateGameState(String name, int dice) {
        gameState.putIfAbsent(name, new ArrayList<Integer>());
        gameState.get(name).add(dice);
    }

    // 플레이어별 현재 진행 상황
    public void updateForwardState(String name, int dice) {
        forwardState.putIfAbsent(name, new ArrayList<Integer>());
        List<Integer> playerPosList = forwardState.get(name);
        if(playerPosList.isEmpty()){
            playerPosList.add(0);      // 첫 위치 초기화
        }
        int isForward = 0;
        if(dice >= FORWARD_NUM) {
            isForward = 1;
        }
        playerPosList.add(playerPosList.get(playerPosList.size()-1) + isForward);
    }
}
