package racingcar;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        View.print("Start"); // 게임 시작 멘트 출력
        View.input("Name"); // 이름 입력
        View.print("Try"); // 시도 횟수 출력
        View.input("NumberOfAttempts"); // 시도 횟수 입력
        View.print("Result");
        Control.playGame(); // 게임 시작
        Control.calculateWinner();
        View.print("Winner");
        // TODO: 프로그램 구현
    }
}
