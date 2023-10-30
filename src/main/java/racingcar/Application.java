package racingcar;

import racingcar.core.GenerateRacer;
import racingcar.entity.Racing;
import racingcar.entity.Racer;
import racingcar.entity.RaceCount;
import racingcar.property.ValidateType;
import racingcar.tool.InputTool;
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
        RaceCount raceCount = raceCountForm();
        for (int i=0;i<raceCount.inputScore();i++){
            race(racerNameList);
        }
    }

    private static void race(List<String> racerNameList){
        generateRacer(racerNameList);
        for (String racerName:racerNameList){
            Racing racing = new Racing(Racer.getInstance(racerName));
            racing.racingByRacer();
        }
    }

    private static List<String> racerNameForm(){
        String racerNameListInput = InputTool.readLineByConsole();
        List<String> racerNameList = Arrays.asList(racerNameListInput.split(","));
        validateRacerNameList(racerNameListInput);
        validateRacerName(racerNameList);
        return racerNameList;
    }

    private static RaceCount raceCountForm(){
        OutputView.outputForRaceCount();
        String raceCountInput = InputTool.readLineByConsole();
        return new RaceCount(validateRaceCount(raceCountInput));
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

    private static int validateRaceCount(String raceCount){
        validateForValidateType(ValidateType.COUNT,raceCount);
        return Integer.parseInt(raceCount);
    }


    private static void generateRacer(List<String> racerNameList){
        for (String racerName:racerNameList){
            generateRacerByInputValue(racerName);
        }
    }
    private static GenerateRacer generateRacerByInputValue(String inputValue){
        return (racerName)-> Racer.getInstance(inputValue);
    }
}
