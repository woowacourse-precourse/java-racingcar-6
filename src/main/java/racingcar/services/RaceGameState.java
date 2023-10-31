package racingcar.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.validate.Validator;
import racingcar.validate.impls.RaceGameStateValidator;

public class RaceGameState {
    private final Map<String, Integer> stateOfEachCar;

    public RaceGameState(String inputStringOfParticipant) {
        List<String> listOfCarNames = enumerateCarNames(inputStringOfParticipant);
        stateOfEachCar = convertListToMap(listOfCarNames);
    }
    private List<String> enumerateCarNames(String inputStringOfParticipants){
        Validator validator = new RaceGameStateValidator();
        String [] parsed = inputStringOfParticipants.replaceAll(" ", "").split(",");
        List<String> parsedNames = Arrays.asList(parsed);
        validator.validate(parsedNames);
        return parsedNames;
    }

    public Map<String, Integer> getStateOfEachCar() {
        return stateOfEachCar;
    }

    private Map<String, Integer> convertListToMap(List<String> names){
        return names.stream()
                .collect(Collectors.toMap(name -> name, name->0));
    }

    private String StringOfCurrentProgress(String name){
        int currentProgress = stateOfEachCar.get(name);
        String indicationChar = "-";
        String repeatedIndicate = indicationChar.repeat(currentProgress);
        return name + " : "+ repeatedIndicate +"\n";
    }


}
