package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class User {
    public int howMuchTry(){
        System.out.println("시도할 회수는 몇회인가요?");
        CheckException checkException = new CheckException();
        String inputTry = readLine();
        int moveTime = checkException .checkRightNumberOfMove(inputTry);
        moveTime = checkException .checkPositiveNumberOfMove(moveTime);
        return moveTime;
    }
}
