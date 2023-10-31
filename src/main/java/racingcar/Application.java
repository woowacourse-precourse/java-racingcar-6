package racingcar;

public class Application {
    public static void main(String[] args) {
        View.print("Start");                   // 게임 시작 멘트 출력
        View.input("Name");               // 자동차 이름 입력
        View.print("Try");                     // 시도할 횟수 멘트 출력
        View.input("NumberOfAttempts");   // 시도할 횟수 입력
        View.print("Result");                  // "실행 결과" 멘트 출력
        Control.playGame();                    // 게임 시작 및 진행 상황 출력
        Control.calculateWinner();             // 우승자 계산
        View.print("Winner");                  // 우승자 출력
    }
}
