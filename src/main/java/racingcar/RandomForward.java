package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class RandomForward {
    public static void randomForwardTheCar() {
        String[] player = InputCarName.inputCarName();
        int playTime = InputPlayTime.inputPlayTime();
        String[] playerDash = new String[player.length];
        Arrays.fill(playerDash,"");

        System.out.println("실행 결과");
        for (int i = 0; i < playTime; i++) {
            for (int j = 0; j < player.length; j++) {
                if (Randoms.pickNumberInRange(0, 9) > 3) {
                    playerDash[j] = playerDash[j]+"-";
                }
            }
            for(int k = 0; k < player.length; k++){
                System.out.println(player[k]+" : "+playerDash[k]);
            }
            System.out.println();
        }

        SelectWinner.selectWinner(player, playerDash);
    }
}