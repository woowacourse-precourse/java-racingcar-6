package racingcar.play.game;

import java.util.LinkedHashMap;
import java.util.Map;

import racingcar.play.car.Car;
import racingcar.play.user.User;
import racingcar.util.Random;

public class Game {

    public static void start(){
        //사용자로부터 자동차 이름 입력
        String[] names = Car.input();

        //사용자로부터 시도 회수 입력
        int count = User.input();
        play(names, count);
    }

    public static void play(String[] names, int count){
        System.out.println("실행 결과");
        Map<String, String> score = new LinkedHashMap<>();

        //초기화
        for(String name : names){
            score.put(name, "");
        }

        //Map의 Key모임
        String[] keys = score.keySet().toArray(new String[0]);

        //시도 회수만큼 반복
        for(int i=0;i<count;i++){
            racing(keys, score);
        }

        //게임 종료로 이동


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
