package racingcar.domain;

public class Result {
    public void printRapResult(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            printCarPosition(positions[i]);
        }
        System.out.println();
    }

    private void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void pickWinners() {

    }

    public void printWinner() {

    }
}
