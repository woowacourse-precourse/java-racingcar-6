package racingcar;

public class Car {

    private String name;
    private int move;

    public Car(String name){
        this.name = nameLengthCheck(name);
        this.move = 0;
    }
    private String nameLengthCheck(String name){
        if(name.length() >= 5)
            throw new IllegalArgumentException();
        return name;
    }

    public String getName(){
        return this.name;
    }
    public int getMove(){
        return this.move;
    }
    public void plusMove(){
        this.move++;
    }
}
