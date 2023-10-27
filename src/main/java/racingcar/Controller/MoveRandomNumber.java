package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.View.InputView;

public class MoveRandomNumber {
    InputView inputView = new InputView();

    //camp.nextstep.edu.missionutils에서 제공하는 Randoms API 사용하여 중복되지 않는 랜덤 수 저장
    public List<Integer> generateRandomGameNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0 ;  i < inputView.storeCarName().size() ; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            randomNumbers.set(i, randomNumber);
        }
        return randomNumbers;
    }

}
