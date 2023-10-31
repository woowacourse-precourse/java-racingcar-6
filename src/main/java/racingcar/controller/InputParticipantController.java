package racingcar.controller;

import racingcar.model.Participant;
import racingcar.model.Participants;

import java.util.ArrayList;
import java.util.List;

public class InputParticipantController {
    NameValidator nameValidator = new NameValidator();

    public List<String> nameParsing(String nameString) {
        String[] namesArray = nameString.split(",");
        List<String> names = new ArrayList<>();
        for(int i=0; i< namesArray.length; i++){
            nameValidator.isValidName(namesArray[i]);
            names.add(namesArray[i]);
        }
        return names;
    }

    public List<Participant> initializeParticipants(List<String> names) {
        List<Participant> participants = new ArrayList<>();
        for(int i=0; i<names.size(); i++){
            Participant participant = new Participant(i, names.get(i));
            participants.add(participant);
        }
        return participants;
    }
}
