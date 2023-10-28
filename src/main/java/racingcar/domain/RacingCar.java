package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<Player> players;
    private static int maxCount = Integer.MIN_VALUE;

    public RacingCar(List<Player> players) {
        this.players = players;
    }

    public void run() {
        for (Player player : players) {
            player.run();

            if (player.getRunCount() > this.maxCount) {
                maxCount = player.getRunCount();
            }

            player.print();
        }
    }

    public List<Player> getWinnerList(){
        // 가장 멀리간 최종 우승자를 List 자료형으로 반환.
        List<Player> winnerList = new ArrayList<>();
        for (Player player : players) {
            if (player.getRunCount() == this.maxCount) {
                winnerList.add(player);
            }
        }

        return winnerList;
    }

    // 최종 우승자 출력
    public void printWinner() {
        List<Player> winnerList = getWinnerList();

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            sb.append(winnerList.get(i).getName());

            //우승자가 여러명일 경우 ","를 붙여서 출력
            if (i < winnerList.size() - 1) {
                sb.append(", ");
            }
        }

        System.out.println(sb);
    }
}
