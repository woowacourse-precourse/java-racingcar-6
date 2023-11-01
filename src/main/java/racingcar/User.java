package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class User {
    static int howMuchTry(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTry = readLine();
        int moveTime = CheckException.checkRightNumberOfMove(inputTry);
        moveTime = CheckException.checkPositiveNumberOfMove(moveTime);
        return moveTime;
    }
}
