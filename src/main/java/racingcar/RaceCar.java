package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class RaceCar {
    private static int maxDistanceTraveled=0;
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
        renewMaxDistanceTraveled();
    }

    private void renewMaxDistanceTraveled(){
        if(maxDistanceTraveled < position ) maxDistanceTraveled = position;
    }

    private String winnerCarName(){
        if(maxDistanceTraveled == position)
            return name;
        else
            return "";
    }


    public void currentPosition(){
        String underBar = "_";
        System.out.println(name+" : "+ underBar.repeat(position));
    }

}
