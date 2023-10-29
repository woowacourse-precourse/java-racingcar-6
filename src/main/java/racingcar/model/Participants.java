package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class Participants {
    HashMap<String, Integer> participants = new HashMap<>();
    HashMap<Integer, String> indexMap = new HashMap<>() ;

    public String getIndex(int i) {
        return indexMap.get(i);
    }

    public void setIndex(List<String> names) {
        for(int i=0; i<names.size(); i++){
            indexMap.put(i, names.get(i));
        }
    }

    public void setParticipants(List<String> names){
        for(int i=0; i<names.size(); i++){
            participants.put(names.get(i), 0);
        }
    }

    public HashMap<String, Integer> getParticipants() {
        return participants;
    }

    public void setPoint(String name, int point){
        participants.replace(name, point);
    }

    public int getPoint(String name){
        return participants.get(name);
    }

}
