package racingcar.view;

import java.util.HashMap;
import java.util.List;

import racingcar.model.game_set;

public class output {

    public static void Start_Message() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void Attempts_Message() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void Game_Start() {
        System.out.println("실행결과");
    }

    public static void Game_exe(int n, List<String> cars) {
        HashMap<String, Integer> setting = game_set.game_set(n, cars);
        System.out.println(setting);
    }

}
