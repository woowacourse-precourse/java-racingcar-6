package racingcar;

public class Car {
    int randomNumber;

    void createRandomNumber() {
        // 0~9 사이의 무작위 값을 추출
        this.randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }
}
