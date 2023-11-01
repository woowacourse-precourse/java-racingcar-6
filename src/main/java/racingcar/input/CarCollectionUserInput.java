package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.StringValidateUtils;
import racingcar.vo.CarInfo;
import racingcar.vo.CarCollection;

import java.util.List;
import java.util.stream.Collectors;

class CarCollectionUserInput implements UserInput<CarCollection>{

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    CarCollectionUserInput() {
    }

    @Override
    public CarCollection input() {
        System.out.println(START_MESSAGE);
        final String userInput = Console.readLine();
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

    private void validateNameLength(String name){
        if(name.length()>5)
            throw new IllegalArgumentException();
    }
}
