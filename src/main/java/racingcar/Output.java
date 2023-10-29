package racingcar;

public class Output {
    private String RoundUserResult;
    public static final String MOVEMENT = "-";

    public void printUserNameInputAnnouncement() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printUserRoundInputAnnouncement() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printUserRoundResult(String carName, int movement) {
        System.out.print(carName + " : ");
        for (int i = 0; i < movement; i++) {
            System.out.print(MOVEMENT);
        }
        printGap();
    }

    public void printRoundResultAnnouncement() {
        printGap();
        System.out.println("실행 결과");
    }

    public void printGap() {
        System.out.println();
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
