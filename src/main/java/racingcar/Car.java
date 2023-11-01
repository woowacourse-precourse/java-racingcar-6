package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{
    private String name;
    public int position =0;

    public Car(String name){
        this.name=name;
    }

    public String getCarName(){
        return name;
    }

    public int getCarPosition(){
        return position;
    }

    public void move(){
        int randomNumber= Randoms.pickNumberInRange(0,9);
        if(randomNumber>=4){
            position++;
        }
    }
}
