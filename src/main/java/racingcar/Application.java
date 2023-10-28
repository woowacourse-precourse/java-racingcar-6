package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Event carRacing = new Event();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carRacing.filterName();
        carRacing.filterTimes();

        System.out.println("");
        System.out.println("실행 결과");

        int l = 0;
        while (l < carRacing.moveTimes) {
            carRacing.moveForward();
            System.out.println("");
            l++;
        }

        carRacing.announceWinner();
    }
}

class Event {
    public int moveTimes;
    private int[] scoreBoard;
    private String[] players;

    void filterName() {
        String inputName = Console.readLine();
        players = inputName.split(",");

        if ( !(inputName.contains(",")) ) {
            throw new IllegalArgumentException("이름은 쉼표로 구분되어야 합니다.");
        }

        for (int i = 0; i < players.length; i++) {
            if (players[i].length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }

        scoreBoard = new int[players.length];
    }

    void filterTimes() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            moveTimes = Integer.parseInt(Console.readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException("회수가 올바르지 않습니다.");
        }

    }

    void moveForward() {
        int i = 0;
        while (i < players.length ) {
            int movePoint = Randoms.pickNumberInRange(0, 9);

            if (movePoint >= 4) {
                scoreBoard[i] = scoreBoard[i] + movePoint;
            }

            i++;
        }

        for (int j = 0; j < players.length; j++) {
            System.out.print(players[j] + " : ");

            for (int k = 0; k < scoreBoard[j]; k++) {
                System.out.print("-");
            }

            System.out.print("\n");
        }
    }

    void announceWinner() {
        int maxValue = scoreBoard[0];
        int maxIndex = 0;
        ArrayList<String> addWinner = new ArrayList<>();

        for (int i = 1; i < scoreBoard.length; i++) {
            if (scoreBoard[i] > maxValue) {
                maxValue = scoreBoard[i];
                maxIndex = i;
            }
        }

        for (int j = 0; j < scoreBoard.length; j++) {
            if (scoreBoard[j] == scoreBoard[maxIndex]) {
                addWinner.add(players[j]);
            }
        }

        String[] winners = new String[addWinner.size()];
        addWinner.toArray(winners);

        System.out.print("최종 우승자 : " + winners[0]);

        if (winners.length > 1) {
            for (int k = 1; k < winners.length; k++) {
                System.out.print(", " + winners[k]);
            }
        }
    }

}
