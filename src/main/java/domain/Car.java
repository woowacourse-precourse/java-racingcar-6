package domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {

    private final String name;
    private int position =0;

    public Car(String name){
        this.name=name;
    }

    public void go(){
        if(RandomNumberGenerator()){
            position++;
        }
    }

    public int getPosition()
    {
        return position;
    }
    public String getName(){
        return name;
    }

    private boolean RandomNumberGenerator(){
        int num= Randoms.pickNumberInRange(0,9);
        return (num>=4);
    }



}
