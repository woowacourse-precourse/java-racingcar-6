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

        List<String> nameList = removeBlank(splitByComma(input));

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

    private List<String> removeBlank(List<String> nameList) {

        for (int i = 0; i < nameList.size(); i++) {
            String trimmedString = nameList.get(i).trim();
            nameList.set(i, trimmedString);
        }

        return nameList;
    }

}
