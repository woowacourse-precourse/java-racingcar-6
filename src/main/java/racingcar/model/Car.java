package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validate;

public class Car {
    private Integer position;
    private final String member;

    public Car(String member) {
        // Instance 생성 시 member 유효성 검사
        Validate.carNameNumeric(member);
        Validate.carNameLength(member);

        this.member = member;

        // 처음 객체 생성 시 전진은 없으므로 0으로 초기화
        this.position = 0;
    }

    public String getMember() {
        return this.member;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward() {
        this.position++;
    }

    // 현재 위치 정보 출력 (예시: member : --- (position = 3))
    public String getForwardPosition() {
        return this.member + " : " + "-".repeat(this.position);
    }

    public boolean move() {
        int randomValue = Randoms.pickNumberInRange(1, 9);

        return (randomValue >= 4);
    }
}
