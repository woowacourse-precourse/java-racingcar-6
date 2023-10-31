package racingcar.validate.impls;

import java.util.List;
import racingcar.validate.Validator;

public class WinnerDetectorValidator implements Validator {
    @Override
    public void validate(Object obj) {
        List<String> winners = (List<String>) obj;
        if (detectNoWinner(winners)){
            throw new IllegalArgumentException("우승자가 없습니다.");
        }
    }

    private boolean detectNoWinner(List<String> winners){
        return winners.isEmpty();
    }

}
