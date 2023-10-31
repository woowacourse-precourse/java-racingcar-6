package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private int inputMove;

    private int randomNum;

    public void inputMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        inputMove = Integer.parseInt(Console.readLine());
        System.out.println(inputMove);
    }

    private boolean isGo(){
        randomNum = Randoms.pickNumberInRange(0,9);
        if (randomNum >= 4){
            return true;
        }
        return false;
    }
}