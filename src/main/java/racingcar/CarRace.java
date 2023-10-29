package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {
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
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이가 5를 초과할 수 없습니다.");
        }
    }
}
