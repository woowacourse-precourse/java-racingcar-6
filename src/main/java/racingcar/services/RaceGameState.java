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
    }
    private List<String> enumerateCarNames(String inputStringOfParticipants){
        Validator validator = new RaceGameStateValidator();
        String [] parsed = inputStringOfParticipants.replaceAll(" ", "").split(",");
        List<String> parsedNames = Arrays.asList(parsed);
        validator.validate(parsedNames);
        return parsedNames;
    }


}
