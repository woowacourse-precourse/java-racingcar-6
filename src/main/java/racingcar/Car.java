package racingcar;

public class Car {
    private String name;
    private String move;

    Car(String name, String move){
        this.name = name;
        this.move = move;
    }

    public String getName(){
        return this.name;
    }

    public String getMove(){
        return this.move;
    }

    public void setMove(String move){
        this.move += move;
    }

    @Override
    public String toString(){
        return String.format("%s : %s", this.name, this.move);
    }
}
