package racingcar;

import racingcar.core.generate.GenerateRacer;
import racingcar.entity.Racer;
import racingcar.entity.TargetScore;
import racingcar.property.ValidateType;
import racingcar.tool.InputTool;
import racingcar.validation.ValidateForm;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView.outputForRaceStart();
        race();
    }

    private static void race(){
        String inputValue = InputTool.readLineByConsole();
        validateRacerNameList(inputValue);
    }

    private static void validateRacerNameList(String inputValue){
        ValidateForm.validateForValidateType(ValidateType.NAME_LIST,inputValue);
        List<String> racerNameList = Arrays.asList(inputValue.split(" "));
        racerNameList.stream()
                            .forEach(racerName->ValidateForm.validateForValidateType(
                                    ValidateType.NAME,racerName
                            ));
    }
}
