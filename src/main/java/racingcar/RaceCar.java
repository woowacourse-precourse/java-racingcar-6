package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class RaceCar {
    private static int maxDistanceTraveled=0;
    private int position;
    private String name;
    public RaceCar(){
        name = " ";
        position =0;
    }
    public RaceCar(String name){
        this.name = name;
        position =0;
    }
    public RaceCar(String name, int pos){
        this.name = name;
        position =pos;
    }

    public void raceForward(){
        if(Randoms.pickNumberInRange(0,9)>=4) position+=1;
        renewMaxDistanceTraveled();
    }

    private void renewMaxDistanceTraveled(){
        if(maxDistanceTraveled < position ) maxDistanceTraveled = position;
    }

    public String winnerCarName(){
        if(maxDistanceTraveled == position)
            return name;
        else
            return "";
    }


    public void currentPosition(){
        String underBar = "-";
        System.out.println(name+" : "+ underBar.repeat(position));
    }

}
