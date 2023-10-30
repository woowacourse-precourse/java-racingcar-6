package racingcar.Model;

import java.util.List;
import racingcar.Domain.CarGroup;

public interface CarModel {

    CarGroup preProcessing(String carNames);

    List<String> divideCarNameByDelimiter(String carNames);
}
