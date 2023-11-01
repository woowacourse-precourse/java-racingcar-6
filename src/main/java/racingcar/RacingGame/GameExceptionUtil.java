package racingcar.RacingGame;

import camp.nextstep.edu.missionutils.Console;

public class GameExceptionUtil {

    public void checkUserNameLength(String userName){
        if(userName.length() > 5)
            throw new IllegalArgumentException("문자의 길이는 5를 넘을 수 없습니다.");
    }


    public int interationValidation(String sIteration){
        try{
            int iteration = Integer.parseInt(sIteration);
            return iteration;

        } catch(NumberFormatException e){
            throw new IllegalArgumentException("적합하지 않은 숫자 형태입니다.");
        }
    }
}
