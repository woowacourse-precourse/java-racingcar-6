package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class game_attempt {

    public static HashMap<String, Integer> game_record(HashMap<String, Integer> setting) {
        for (String car_name : setting.keySet()) {
            int move = moving();
            setting.put(car_name, setting.get(car_name) + move);
        }
        return setting;
    }

    public static int moving() {
        int move = Randoms.pickNumberInRange(0, 9);
        if (move >= 4) {
            return 1;
        } else {
            return 0;
        }
    }

}
