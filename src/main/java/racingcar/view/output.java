package racingcar.view;

import java.util.HashMap;
import java.util.List;

import racingcar.model.game_attempt;
import racingcar.model.game_set;
import racingcar.model.game_winner;

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

    public static HashMap<String, Integer> Game_exe(int n, List<String> cars) {
        HashMap<String, Integer> setting = game_set.game_set(cars);
        for (int i = 0; i < n; i++) {
            game_attempt.game_record(setting);
            Game_cur(setting);
        }
        return setting;
    }

    public static void Game_cur(HashMap<String, Integer> setting) {
        for (String car_name : setting.keySet()) {
            System.out.print(car_name + " : ");
            System.out.println("-".repeat(setting.get(car_name)));
        }
        System.out.println("");
    }

    public static void Game_result(HashMap<String, Integer> result) {
        List<String> winners = game_winner.game_winner(result);
        String wins = String.join(", ", winners);
        System.out.println("최종 우승자 : " + wins);
    }

}
