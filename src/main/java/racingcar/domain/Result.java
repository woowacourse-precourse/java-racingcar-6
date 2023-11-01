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

    private int pickWinners(int[] positions) {
        int winner = 0;
        for (int position : positions) {
            winner = Math.max(winner, position);
        }
        return winner;
    }


    public void printWinner(String[] carNames, int[] positions) {
        int winner = pickWinners(positions);
        System.out.print("최종 우승자 : ");
        boolean isFinalWinner = true;
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == winner) {
                if (!isFinalWinner) {
                    System.out.print(", ");
                }
                System.out.print(carNames[i]);
                isFinalWinner = false;
            }
        }
    }
}
