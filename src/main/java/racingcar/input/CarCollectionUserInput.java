package racingcar.input;

import racingcar.utils.StringValidateUtils;
import racingcar.vo.CarCollection;
import racingcar.vo.CarInfo;

import java.util.List;
import java.util.stream.Collectors;

public class CarCollectionUserInput implements UserInput<CarCollection>{

    private final ConsoleUserInput consoleUserInput;

    public CarCollectionUserInput(ConsoleUserInput consoleUserInput) {
        this.consoleUserInput = consoleUserInput;
    }

    @Override
    public CarCollection input() {
        final String userInput = consoleUserInput.input();
        final List<String> carInfo = List.of(userInput.split(","));
        validateUserInput(carInfo);
        return new CarCollection(carInfo.stream().map(CarInfo::new).collect(Collectors.toList()));
    }

    private void validateUserInput(List<String> userInput){
        userInput.forEach(this::validateName);
    }

    private void validateName(String name){
        StringValidateUtils.validateStringLength(name, 5);
        StringValidateUtils.validateEmptyString(name);
    }
}
