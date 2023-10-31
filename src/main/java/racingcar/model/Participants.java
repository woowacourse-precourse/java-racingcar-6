package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class Participants {
    HashMap<Integer, Participant> map = new HashMap<>() ;

    public void addParticipant(Participant participant) {
        map.put(participant.getIndex(), participant);
    }

    public HashMap<Integer, Participant> getParticipants() {
        return map;
    }

    public void setParticipants(List<Participant> people) {
        for(int i=0; i< people.size(); i++){
            map.put(people.get(i).getIndex(), people.get(i));
        }
    }

    public void setPoint(int index){
        int point = map.get(index).getPoint();
        map.get(index).setPoint(point+1);
    }
}
