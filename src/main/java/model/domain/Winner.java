package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Name> winner;

    public Winner(){
        winner = new ArrayList<>();
    }

    public List<Name> getWinner() {
        return winner;
    }

    public void add(Name name){
        winner.add(name);
    }

    public void clear(){
        winner.clear();
    }

}
