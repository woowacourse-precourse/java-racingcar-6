package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class RaceCar {
    int position;
    String name;
    public RaceCar(){
        name = " ";
        position =0;
    }
    public RaceCar(String name){
        this.name = name;
        position =0;
    }

    public void raceForward(){
        if(Randoms.pickNumberInRange(0,9)>=4) position+=1;
    }


}
