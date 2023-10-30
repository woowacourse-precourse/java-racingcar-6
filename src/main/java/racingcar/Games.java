package racingcar;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Games {
    int move_num;
    HashMap<String, Integer> car_situations = new HashMap<String, Integer>();

    Games(String[] names, int move_num) {
        for (String name : names) {
            car_situations.put(name, 0);
        }
        this.move_num = move_num;
    }

    public void racingcar_game() {
        for (String car_name : car_situations.keySet()){
            int random_num = Randoms.pickNumberInRange(0, 9);
        }
    }
}
