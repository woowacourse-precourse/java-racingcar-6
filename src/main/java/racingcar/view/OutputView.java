package racingcar.view;

public class OutputView {
    public static void askCarNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void showRoundResultByCar(String carName, String positionToDash) {
        System.out.println(carName + " : " + positionToDash);
    }

    public static void showGameWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
