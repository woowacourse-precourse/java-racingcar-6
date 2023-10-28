package racingcar.view;

public class GameView {

    public static void displayStartGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void displayAskTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void displayResultMessage() {
        System.out.println("실행결과");
    }

    public void displayFinalWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void displayCurrentCarPosition(String currentPariticipantCarPosition) {
        System.out.println(currentPariticipantCarPosition + "\n");
    }
}
