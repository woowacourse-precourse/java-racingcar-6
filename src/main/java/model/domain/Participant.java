package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Participant {

    List<Car> participant;

    public Participant(List<String> nameList){

        this.participant = new ArrayList<>();

        for (String name : nameList) {
            this.participant.add(new Car(name));
        }

    }

    public List<Car> getParticipant() {
        return participant;
    }

}
