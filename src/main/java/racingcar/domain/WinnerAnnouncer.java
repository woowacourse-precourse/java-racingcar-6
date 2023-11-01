package racingcar.domain;

import java.util.List;

public class WinnerAnnouncer {
    public void announceSoloWinner(String winner) {
        System.out.println("최종 우승자: " + winner);
    }

    public void announceJointWinners(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
