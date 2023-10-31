package racingcar;

public class SelectWinner {
    public static void selectWinner(String[] player, String[] playerDash) {
        int max = 0;

        for (String dash : playerDash) {
            max = Math.max(max, dash.length());
        }
        OutputWinner.outputWinner(player, playerDash, max);
    }
}