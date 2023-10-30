package racingcar;

import racingcar.core.generate.GenerateRacer;
import racingcar.entity.Racer;
import racingcar.property.ValidateType;
import racingcar.tool.InputTool;
import racingcar.validation.ValidateForm;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView.outputForRaceStart();
        raceBefore();
    }

    private static void raceBefore(){
        String inputValue = InputTool.readLineByConsole();
        List<String> racerNameList = Arrays.asList(inputValue.split(" "));
        validateRacerNameList(inputValue);
        validateRacerName(racerNameList);
    }

    private static void validateRacerNameList(String racerNameList){
        ValidateForm.validateForValidateType(ValidateType.NAME_LIST,racerNameList);
    }

    private static void validateRacerName(List<String> racerNameList){
        racerNameList.stream()
                            .forEach(racerName->ValidateForm.validateForValidateType(
                                    ValidateType.NAME,racerName
                            )
                );
    }

}
