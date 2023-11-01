package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import racingcar.constant.ErrorMessage;
public class viewInputNumber {
    private final String NUMERIC_PATTERN = "^[0-9]*$";

    public int viewInputNumber(){
        String movementTimeStr = Console.readline();
        if(!Pattern.matches(NUMERIC_PATTERN, movementTimeStr)){
            throw new IllegalArgumentException(ErrorMessage.MOVEMENT_TIME_TYPE_EXCEPTION.getMessage());
        }
        int movementTimeInt = Integer.parseInt(movementTimeStr);

        return movementTimeInt;
    }
}
