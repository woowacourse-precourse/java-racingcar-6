package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    public String[] contestantSignup(String input) {
        String[] contestants = input.split(",");

        for (String contestant : contestants){
            nameCheck(contestant);
        }

        return contestants;
    }
    public int goStop(int previousRound) {
        int randomNum  = Randoms.pickNumberInRange(0,9);
        if (randomNum > 3) {
            previousRound++;
        }
        return previousRound;
    }

    public void printMove(String contestant, int move) {
        System.out.print(contestant+" : ");
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int showCurrentRound(String contestant, int move) {
        move = goStop(move);
        printMove(contestant, move);
        return move;
    }

    public void nameCheck(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("이름 길이가 5를 초과할 수 없습니다.");
        }
    }

    public String[] theWinnerIs(String[] contestants, int[] move) {
        int max = move[0];
        List<String> winner_list = new ArrayList<>();
        for (int i = 1; i < move.length; i++) {
            winner_list.add(contestants[i]);
            if (max <= move[i]) {
                max = move[i];
                winner_list.remove(contestants[i-1]);
            }
        }
        if (winner_list.isEmpty()||max==move[0]) {
            winner_list.add(contestants[0]);
        }

        String[] winners = winner_list.toArray(new String[0]);

        return winners;
    }

    public void printWinners(String[] winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i]);
            if (i < winners.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
