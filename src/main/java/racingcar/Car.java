package racingcar;
import camp.nextstep.edu.missionutils.Randoms;


class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        // 0에서 9 사이에서 무작위 값을 구합니다.
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        // 전진하는 조건은 4 이상일 경우입니다.
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
