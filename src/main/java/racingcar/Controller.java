package racingcar;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.vo.CarName;

public class Controller {
    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Racing racing = creatRacingByUserInput();
    }

    private Racing creatRacingByUserInput() {
        List<String> nameStringList = inputView.inputCarNameStrings();
        List<CarName> carNameList = getCarNameList(nameStringList);
        return new Racing(carNameList);
    }

    private static List<CarName> getCarNameList(List<String> nameStringList) {
        return nameStringList.stream().map(CarName::new).toList();
    }
}
