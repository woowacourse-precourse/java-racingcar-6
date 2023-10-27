package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RaceService {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 1;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceService() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void moveCarAndPrintResult(){
        List<String> carNames = carNamesToList();
        int[] result = new int[carNames.size()];
        for (int i = 0; i < carNames.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (randomNumber >= 4){
                result[i] += 1;
            }
        }
        outputView.printResult(carNames, result);
    }


    private List<String> carNamesToList() {
        String carNames = inputView.enterCarNames();
        String[] carNamesArr = carNames.split(",");
        return Arrays.asList(carNamesArr);
    }
}
