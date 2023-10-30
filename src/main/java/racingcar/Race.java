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
}
