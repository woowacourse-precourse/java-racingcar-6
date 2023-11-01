package racingcar.Model;

import java.util.List;
import racingcar.Domain.CarGroup;
import racingcar.Factory.Factory;
import racingcar.Validator.CarNameValidator;

public class CarModelImpl implements CarModel {

    public Factory factory = new Factory();
    private final CarNameValidator carNameValidator = factory.getCarNameValidator();
    private static final String DELIMITER = ",";
    public CarGroup preProcessing(String carNames) {
        List<String> carNameList = divideCarNameByDelimiter(carNames);
        for (String carName : carNameList) {
            carNameValidator.isValidLength(carName);
            carNameValidator.hasWhiteSpace(carName);
        }
        carNameValidator.hasDuplicateName(carNameList);
        return CarGroup.of(carNameList);
    }
    public List<String> divideCarNameByDelimiter(String carName) {
        return List.of(carName.split(DELIMITER));
    }
}