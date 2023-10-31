package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;



public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        Racing racing = new Racing();

        // 경주할 차 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingCar.setCarName();
        Map<String, String> gameScore = racingCar.createRaceStatusMap();

        // 시도 횟수 입력
        System.out.println("시도할 횟수는 몇회인가요?");
        int attemptInput = racingCar.attemptCountInput();

        // 실행 결과
        System.out.println("실행 결과");
        for (int i = 0; i < attemptInput; i++) {
            racing.moveResult(gameScore);
            System.out.println();
        }
        String findWinner = Collections.max(gameScore.values());

        List<String> winner = new ArrayList<>();
        for (String key : gameScore.keySet()) {
            if (gameScore.get(key).equals(findWinner)) {
                winner.add(key);
            }
        }

        String result = String.join(",", winner);
        System.out.println("최종 우승자 : " + result);
    }
}
