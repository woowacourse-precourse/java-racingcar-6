package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.RandomUtils;
import racingcar.utils.StringUtils;

public class Car {
    private int forward;
    private String name;
    private int randomNumber;

    public Car(int forward, String name, int randomNumber){
        this.forward = forward;
        this.name = name;
        this.randomNumber = randomNumber;
    }
}
