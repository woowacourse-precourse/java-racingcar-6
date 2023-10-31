package racingcar.domain;
import java.util.List;
public class Judgment {

    public void checkCarNameUnderFive(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name is too long");
            }
        }
    }

    public void inputHowManyMoves(Integer moveCount){


    }
}
