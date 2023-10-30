package racingcar;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame{
    List<Integer> moveCount;
    List<String> nameList ;


    PlayGame(List<String> argumentNameList) {
        nameList=argumentNameList;
        moveCount = new ArrayList<>(Collections.nCopies(nameList.size(), 0));

    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void simulation() {
        int go=4;
        for (int i = 0; i < moveCount.size(); i++) {
            if (getRandomNumber() >= go) moveCount.set(i, moveCount.get(i) + 1);
        }
    }

    public void printCount(int index){
        for (int i=0; i<moveCount.get(index); i++)
            System.out.print("-");
    }


    public void printResult(){
        System.out.println("실행 결과");
        for (int i=0; i<nameList.size(); i++){
            System.out.print(nameList.get(i)+" : ");
            printCount(i);
            System.out.println();
        }
        System.out.println();
    }



}
