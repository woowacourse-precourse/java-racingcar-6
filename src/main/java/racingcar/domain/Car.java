package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private String name;
    private String score;

    public Car() {
        this.score = "";
    }

    public Car(String name) {
        this.name = name;
        this.score = "";
    }

    /**
     * Racing Car 전진 기능
     * - 인자로 넘겨받은 수가 4 이상일 경우에만 전진하고, 그 미만의 경우는 중지한다.
     * @param num
     * @return
     */
    public String advance(int num) {
        if (num >= 4) {
            score += "-";
        }
        return score;
    }

    /**
     * 0~9 중 랜덤의 수 추출 메서드
     * @return
     */
    public int extract() {
        return pickNumberInRange(0, 9);
    }

    public String getName() {
        return name;
    }

}
