package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //사람 추가
    public List<String> addPerson(String persons){
        String[] personArray = persons.split(",");
        List<String> people = new ArrayList<>();
        for(int i = 0; i < personArray.length; i++){
            if(personArray[i].length() > 5){
                throw new IllegalArgumentException("길이가 너무 김");
            }
            people.add(personArray[i]);
        }
        return people;
    }

}
