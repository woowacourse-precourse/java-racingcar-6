package racingcar;

public class Winner {
    public static void choose(String[] carNames, int[] positions) {
        int maxPosition = 0;
        for (int position : positions) {
            maxPosition = getMaxPosition(maxPosition, position);
        }

        printWinner(carNames, positions, maxPosition);
    }

    private static void printWinner(String[] carNames, int[] positions, int maxPosition) {
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                appendWinners(winners, carNames[i]);
            }
        }

        System.out.println("최종 우승자 : " + winners.toString());
    }

    private static int getMaxPosition(int maxPosition, int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
        return maxPosition;
    }

    private static void appendWinners(StringBuilder winners, String carNames) {
        if (winners.length() > 0) {
            winners.append(", ");
        }
        winners.append(carNames);
    }
}
