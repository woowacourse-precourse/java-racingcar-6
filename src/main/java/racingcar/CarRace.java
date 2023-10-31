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
        List<String> winnerList = new ArrayList<>();
        int max = move[0];
        for (int i = 0; i < move.length; i++) {
            if (move[i] > max) {
                max = move[i];
                winnerList.clear(); // 새로운 최대값을 발견하면 최대값 인덱스 목록 초기화
                winnerList.add(contestants[i]);
            } else if (move[i] == max) {
                winnerList.add(contestants[i]); // 같은 최대값을 가진 요소의 인덱스 추가
            }
        }
        String[] winners = new String[winnerList.size()];
        winners = winnerList.toArray(winners);

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
