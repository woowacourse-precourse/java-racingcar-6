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

        checkNotInput(nameList);
        checkMoreTwo(nameList);
        checkDuplication(nameList);

        this.participant = new ArrayList<>();
        for (String name : nameList) {
            this.participant.add(new Car(name));
        }

    }

    public List<Car> getParticipant() {
        return participant;
    }

    private List<String> splitByComma(String input) {
        return Arrays.asList(input.split(SEPERATOR));
    }

    private List<String> removeBlank(List<String> nameList) {

        nameList.replaceAll(String::trim);

        return nameList;
    }

    private void checkDuplication(List<String> nameList) {

        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNotInput(List<String> nameList) {

        if (nameList.isEmpty() || nameList.contains("")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMoreTwo(List<String> nameList) {

        if (nameList.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

}
