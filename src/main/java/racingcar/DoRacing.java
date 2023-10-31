package racingcar;

public class DoRacing {

    private String[] carNames;
    private int carNumber;
    private int[] statusCarMovement;

    private MoveCar moveCar;

    public int[] startRacing(RacingInfo racingInfo) {

        carNames = racingInfo.carNames;
        carNumber = carNames.length;
        statusCarMovement = new int[carNumber];

        moveCar = new MoveCar();

        doTotalRacing(racingInfo.racingTimes);

        return statusCarMovement;
    }

    public void doTotalRacing(int racingTimes) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < racingTimes; i++) {
            moveCarsOneTime();
            printCarStatus();
        }
    }

    private void moveCarsOneTime() {
        for (int i = 0; i < carNumber; i++) {
            statusCarMovement[i] += moveCar.moveCarByRandomNumber();
        }
    }

    private void printCarStatus() {
        for (int i = 0; i < carNumber; i++) {
            System.out.print(carNames[i] + " : " + "-".repeat(statusCarMovement[i]) + "\n");
        }
        System.out.println();
    }
}
