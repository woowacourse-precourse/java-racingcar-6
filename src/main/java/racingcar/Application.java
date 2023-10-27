package racingcar;

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
    }
}

class Event {
    private String inputName;
    private int movePoint;
    public int moveTimes;
    private int[] scoreBoard;
    private String[] players;

    void filterName() {
        inputName = Console.readLine();
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
            movePoint = Randoms.pickNumberInRange(0,9);

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

}
