package racingcar.Model;

import racingcar.View.TextInterface;

public class Car {
    TextInterface textInterface = new TextInterface();
    private String name;
    private int distance;

    public Car(String name){
        this.name = name;
        distance = 0;
    }
    public void go(int num){
        if(num >= 4){
            distance ++;
        }
        textInterface.printDistance(name, distance);
    }
    public int getDistance(){
        return distance;
    }

    public void win(){
        textInterface.printWinner(name);
    }

    public void jointWin(){
        textInterface.printJointWinner(name);
    }

}
