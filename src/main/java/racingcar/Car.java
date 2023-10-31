package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;


    public Car(String name){
        setName(name);
    }
    public void setName(String name) {
        if(checkValidateName(name)){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPosition(int n){
        this.position = this.position + n;
    }

    public int getPosition(){
        return this.position;
    }

    public static boolean checkMoveCondition(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber >= 4;
    }

    public void moveOrStop(){
        if(checkMoveCondition()){
            setPosition(1);
        }
    }

    public void printPosition(){
        System.out.print(this.name + " : ");
        String position = "";
        for(int i = 0; i < getPosition(); i++){
            position += "-";
        }
        System.out.println(position);
    }

    public static boolean checkValidateName(String name){
        return name == null ||name.isEmpty() ||  name.length() > 5;
    }
}
