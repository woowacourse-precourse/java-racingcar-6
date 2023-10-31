package racingcar;

public class Car {
    int randomNumber;
    int turn = 0; // 현재 턴 숫자(0부터 시작)
    int totalGoNumber = 0; // 총 전진횟수
    String[] result; // 각 회차의 결과를 저장하는 배열


    void createRandomNumber() {
        // 0~9 사이의 무작위 값을 추출
        this.randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }

    void goOrStop() {
        // 무작위 값이 4 이상이면 전진
        if (randomNumber >= 4) go();
            // 무작위 값이 4 미만이면 현재 턴의 값을 공백으로 저장
        else this.result[turn] = " ";
        this.turn++;
    }

    void go() {
        // 현재 턴의 값을 "-"로 저장
        this.result[turn] = "-";
        this.totalGoNumber++;
    }
}
