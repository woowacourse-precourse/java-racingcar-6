package racingcar;

public class OutputManager {
    // TODO: 문자열 상수로 리팩토링
    public void printCarNameRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountRequestMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println("게임 결과 출력");
        // TODO: 게임 결과 출력 구현
    }
}
