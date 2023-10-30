package racingcar;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;


import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame {
    List<Integer> moveCount;
    List<String> nameList;

    PlayGame(List<String> argumentNameList) {
        nameList = argumentNameList;
        moveCount = new ArrayList<>(Collections.nCopies(nameList.size(), 0));

    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void simulation() {
        final int go = 4;
        for (int i = 0; i < moveCount.size(); i++) {
            if (getRandomNumber() >= go) moveCount.set(i, moveCount.get(i) + 1);
        }
    }

    public void printCount(int index) {
        for (int i = 0; i < moveCount.get(index); i++)
            System.out.print("-");
        System.out.println();
    }

    public void printResult() {
        System.out.println("실행 결과");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.print(nameList.get(i) + " : ");
            printCount(i);
        }
        System.out.println();
    }

    public int maxScore() {
        return Collections.max(moveCount);
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < moveCount.size(); i++) {
            if (moveCount.get(i) == maxScore()) winnerList.add(nameList.get(i));
        }
        return winnerList;
    }

    public void printWinnerList() {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < getWinnerList().size(); i++) {
            System.out.print(getWinnerList().get(i));
            if (i < getWinnerList().size() - 1) System.out.print(",");
        }
        System.out.println();
    }

}
