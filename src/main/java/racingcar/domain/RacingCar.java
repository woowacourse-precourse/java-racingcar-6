package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<Player> players;
    // maxCount: 게임을 진행하는 플레이어 중 최고 전진 수
    private static int maxCount = Integer.MIN_VALUE;

    public RacingCar(List<Player> players) {
        this.players = players;
    }

    public void run() {
        // 모든 player에 대해 racingcar 게임을 진행해준다.
        for (Player player : this.players) {
            player.run();

            // player의 게임을 진행한 후, 최고 전진 수를 비교하여 갱신
            if (player.getRunCount() > this.maxCount) {
                this.maxCount = player.getRunCount();
            }

            player.print();
        }
    }

    public List<Player> getWinnerList(){
        // 가장 멀리간 최종 우승자를 List 자료형으로 반환.
        List<Player> winnerList = new ArrayList<>();
        for (Player player : this.players) {
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
