package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    private static void checkCarNames(String[] inputNames){
        for(String name: inputNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int checkTurn(String turnInput){
        try {
            return Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    public static void main(String[] args) {
        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputs = Console.readLine().split(",");
        checkCarNames(inputs);      // 예외 처리

        // 2. 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String turnInput = Console.readLine();
        int turns = checkTurn(turnInput);       // 예외 처리 및 횟수 값

        // 3. 경주 진행
        HashMap<String, List<Integer>> gameState = new HashMap<>();     // 회차 무작위값 기록
        HashMap<String, List<Integer>> forwardState = new HashMap<>();  // 회차 자동차 위치 기록

        for(int i = 0; i < turns; i++) {
            for(String name: inputs){
                // 무작위값 계산
                int dice = Randoms.pickNumberInRange(0,9);
                if(!gameState.containsKey(name)) {
                    List<Integer> list = new ArrayList<>();
                    gameState.put(name, list);
                }
                gameState.get(name).add(dice);      // 회차 무작위값 저장

                // 전진 여부 계산
                if(!forwardState.containsKey(name)){
                    List<Integer> list = new ArrayList<>();
                    forwardState.put(name, list);
                }
                List<Integer> playerPosList = forwardState.get(name);
                if(playerPosList.isEmpty()){
                    playerPosList.add(0);      // 첫 위치 초기화
                }
                int isForward = 0;
                if(dice >= 4) {
                    isForward = 1;
                }
                playerPosList.add(playerPosList.get(playerPosList.size()-1) + isForward);      // 회차 자동차 위치 저장
            }
        }

        System.out.println(gameState);
        System.out.println(forwardState);
    }
}
