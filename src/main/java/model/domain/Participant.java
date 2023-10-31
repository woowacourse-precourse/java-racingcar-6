package model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participant {

    private static final String SEPERATOR = ",";

    List<Car> participant;

    public Participant(String input) {

        List<String> nameList = splitByComma(input);

        checkDuplication(nameList);

        this.participant = new ArrayList<>();
        for (String name : nameList) {
            this.participant.add(new Car(name));
        }

    }

    public List<Car> getParticipant() {
        return participant;
    }

    private void checkDuplication(List<String> nameList) {

        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitByComma(String input) {
        return Arrays.asList(input.split(SEPERATOR));
    }

}
