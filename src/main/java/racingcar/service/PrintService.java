package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public interface PrintService {
    public void printInputNameNotice();
    public void printInputCountNotice();
    public void printResultNotice();
    public void printGameResult(List<Car> carList);
    public void printFinalGameResult(List<String> carNameList);
}
