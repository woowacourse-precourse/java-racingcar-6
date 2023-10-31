package racingcar.services;

import java.util.Arrays;
import java.util.List;
import racingcar.validate.Validator;
import racingcar.validate.impls.RaceGameStateValidator;

public class RaceGameState {
    private List<String> enumerateCarNames(String inputStringOfParticipants){
        Validator validator = new RaceGameStateValidator();
        String [] parsed = inputStringOfParticipants.replaceAll(" ", "").split(",");
        List<String> parsedNames = Arrays.asList(parsed);
        validator.validate(parsedNames);
        return parsedNames;
    }


}
