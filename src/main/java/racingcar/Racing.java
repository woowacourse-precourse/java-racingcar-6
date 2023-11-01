package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.StringTokenizer;

public class Racing {
    private int tryNumber;
    private List<Car> car;

    public Racing(int tryNumber, List<Car> car) {
        this.tryNumber = tryNumber;
        this.car = car;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer stringTokenizer = new StringTokenizer(Console.readLine(), ",");

    }
}