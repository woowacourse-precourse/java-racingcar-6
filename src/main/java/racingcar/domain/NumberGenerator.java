package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> createRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>(InputView.getNumberOfCars());
        for(int i = 0; i < InputView.getNumberOfCars(); i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumber.add(randomNumber);
        }
        return computerNumber;
    }
}
