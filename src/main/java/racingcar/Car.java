package racingcar;

public class Car {
    int randomNumber;
    String[] result; // 각 회차의 결과를 저장하는 배열


    void createRandomNumber() {
        // 0~9 사이의 무작위 값을 추출
        this.randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }

    void goOrStop() {
        // 무작위 값이 4 이상이면 전진
        if (randomNumber >= 4) go();
    }

}
