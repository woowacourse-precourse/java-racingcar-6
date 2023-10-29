package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

public class InputParticipantController {

    NameValidator nameValidator = new NameValidator();

    public List<String> getParticipants(String inputString){
        List<String> seperatedNames = separateString(inputString);
        for(int i=0; i< seperatedNames.size(); i++){
            nameValidator.isValidName(seperatedNames.get(i));
        }
        return seperatedNames;
    }

    public List<String> separateString(String nameString){
        String[] namesArray = nameString.split(",");
        List<String> names = new ArrayList<>();
        for(int i=0; i< namesArray.length; i++){
            names.add(namesArray[i]);
        }
        return names;
    }
}
