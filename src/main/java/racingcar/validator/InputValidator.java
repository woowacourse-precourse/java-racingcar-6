package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ExceptionMessage;

public class InputValidator {

    private List<String> validateCarNames;

    public InputValidator(String validateCarNames) {
        convertValidateList(validateCarNames);
        try{
            hasDuplicatedName();
        }catch (IllegalArgumentException e){
            Console.close();
            e.printStackTrace();
        }
    }

    private void convertValidateList(String carNames) {
        this.validateCarNames = Arrays.stream(carNames.split(",")).toList();
    }

    private void hasDuplicatedName() {
        HashSet<String> duplicateValidSet = new HashSet<>(validateCarNames);
        if (duplicateValidSet.size()!=this.validateCarNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    protected List<String> removeSpaceInCarName(){
        return this.validateCarNames.stream().map(carName->carName.replaceAll("\\s",""))
                .collect(Collectors.toList());
    }

}
