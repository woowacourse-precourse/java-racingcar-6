package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {

    List<String> car_name;
    List<Integer> car_score = new ArrayList<>();

    int play_count;

    public void startGame() {
        init();

        System.out.println("실행 결과");

        for (int i = 0; i < play_count; i++) {
            play();
        }

        result();
    }

    private void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        car_name = Arrays.asList(Console.readLine().split(","));

        for (int i = 0; i < car_name.size(); i++) {
            car_score.add(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        play_count = Integer.parseInt(Console.readLine());
    }

}
