package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int LIMIT_NUMBER = 4;

    private final String name;
    private int move;

    public Car(String name){
        validateName(name);
        this.name = name;
        this.move = 0;
    }
    public Car (String name, int move){
        this.name = name;
        this.move = move;
    }

    public void run(int randomNum){
        if(canMove(randomNum)){
            addMove();
        }
    }

    public void addMove(){
        this.move++;
    }

    public String getName(){
        return this.name;
    }

    public int getMove(){
        return this.move;
    }


    private boolean canMove(int randomNum){
        return randomNum >= LIMIT_NUMBER;
    }

    public void validateName(String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] The name must not be more than 5 characters.");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("[ERROR] Car's name shouldn't be null.");
        }
    }

}