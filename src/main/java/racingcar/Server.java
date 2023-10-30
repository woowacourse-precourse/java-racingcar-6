package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private List<Racer> racerList ;
    private Player player;
    private Validator validator;
    Server(){
        player = new Player();
        racerList = new ArrayList<>();
        validator = new Validator();
    }

    public void confirmRacerList(){
    }
    public List<Racer> getRacerList(){ return racerList; }

}
