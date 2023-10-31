package racingcar.play.game;

import java.util.LinkedHashMap;
import java.util.Map;

import racingcar.play.car.Car;
import racingcar.play.user.User;

public class Game {

    public static void start(){
        //사용자로부터 자동차 이름 입력
        String[] names = Car.input();

        //사용자로부터 시도 회수 입력
        int count = User.input();
    }
    private static void racing(String[] keys, Map<String, String> score) {
        //점수 증가
        for (String key : keys) {
            if (Random.check()) {
                score.put(key, score.get(key) + "-");
            }
        }

        //결과 출력
        for (String key : keys) {
            System.out.println(key + " : " + score.get(key));
        }
        System.out.println();
    }

}
