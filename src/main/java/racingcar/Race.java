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

    private void play() {
        for (int i = 0; i < car_name.size(); i++) {
            int rand_num = Randoms.pickNumberInRange(0,9);
            if (rand_num >= 4) car_score.add(i, car_score.get(i) + 1);

            StringBuilder result = new StringBuilder();
            result.append(car_name.get(i));
            result.append(" : ");
            System.out.print(car_name.get(i) + " : ");

            if (car_score.get(i) > 0) {
                for (int j = 0; j < car_score.get(i); i++) {
                    result.append("-");
                }
            }
            System.out.println(result);
        }
        System.out.println();
    }

}
