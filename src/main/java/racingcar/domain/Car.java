package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    //자동차 이름
    private String name;

    //시도 횟수
    private Integer trials;

    //전진횟수
    private Integer forward;

    public Car(String name, Integer trials) {
        this.name = name;
        this.trials = trials;
        this.forward = 0;
    }

    //무작위 값이 4이상일 경우 전진
    public void next() {
        int num = Randoms.pickNumberInRange(0, 9);

        if (num >= 4) {
            forward++;
        }

        trials++;
    }

    public void printResult() {
        System.out.println(name+" : " + "-".repeat(forward));
    }

    public String getName() {
        return name;
    }

    public Integer getForward() {
        return forward;
    }
}
