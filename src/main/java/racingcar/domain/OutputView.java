package racingcar.domain;

public class OutputView {

    public String introduceGameMessage() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public String howManyGamesMessage() {
        return "시도할 회수는 몇회인가요?";
    }

    public String roundResultMessage() {
        return "실행 결과";
    }

    public String finalVictoryCarsMessage() {
        return "최종 우승자 : ";
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
