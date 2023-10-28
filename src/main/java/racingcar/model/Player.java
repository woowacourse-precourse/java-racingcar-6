package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {
    private final static Integer MIN = 0;
    private final static Integer MAX = 9;
    private String name;
    private Integer forward;

    public Player(String name) {
        this.name = name;
        this.forward = 0;
    }

    public boolean ForwardOrNot() {
        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);

        if (randomNumber < 4) return false;
        forward++;
        return true;
    }
}
