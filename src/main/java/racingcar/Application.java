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

import static racingcar.validation.ValidateForm.*;

public class Application {
    public static void main(String[] args) {
        OutputView.outputForRaceStart();
        raceBefore();
    }

    private static void raceBefore(){
        List<String> racerNameList = racerNameForm();
        TargetScore targetScore = targetScoreForm();
    }

    private static void race(List<String> racerNameList,TargetScore targetScore){

    }

    private static List<String> racerNameForm(){
        String racerNameListInput = InputTool.readLineByConsole();
        List<String> racerNameList = Arrays.asList(racerNameListInput.split(","));
        validateRacerNameList(racerNameListInput);
        validateRacerName(racerNameList);
        return racerNameList;
    }

    private static TargetScore targetScoreForm(){
        OutputView.outputForRaceTargetScore();
        String targetScoreInput = InputTool.readLineByConsole();
        return new TargetScore(validateTargetScore(targetScoreInput));
    }

    private static void validateRacerNameList(String racerNameList){
        validateForValidateType(ValidateType.NAME_LIST,racerNameList);
    }

    private static void validateRacerName(List<String> racerNameList){
        racerNameList.stream()
                            .forEach(racerName-> validateForValidateType(
                                    ValidateType.NAME,racerName
                            )
                );
    }

    private static int validateTargetScore(String targetScore){
        validateForValidateType(ValidateType.SCORE,targetScore);
        return Integer.parseInt(targetScore);
    }
}
