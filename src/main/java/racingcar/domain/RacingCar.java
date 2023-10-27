package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.interfaces.Car;
import racingcar.util.OutputUtil;

public class RacingCar implements Car {

    private final String name;
    private int progress;

    public RacingCar(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < progress; i++) {
            sb.append("-");
        }
        OutputUtil.printWithLine(sb.toString());
    }

    public void doTrial() {
        int number = pickRandomNumber();
        if (number >= 4) {
            progress++;
        }
        printInfo();

    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


}
