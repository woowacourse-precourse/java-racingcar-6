package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Car {
    private static final int MIN = 0;
    private static final int MAX = 9;

    private String name;
    private int progress = 0;

    public Car(String str){
        this.name=str;
    }
    public boolean checkFoward(){
        int number = Randoms.pickNumberInRange(MIN,MAX);

        if(number>3){
            return true;
        }
        return false;
    }

    public void checkProgress(){
        if(checkFoward()){
            this.progress++;
        }
    }

    public int getProgress(){
        return this.progress;
    }

    public String getName(){
        return name;
    }

    public void printProgress(){
        System.out.print(name+" : ");
        for(int i=0;i<progress;i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
