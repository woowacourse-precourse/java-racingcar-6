package racingcar;

public class Car {
    private String name;
    private String move;

    Car(String name, String move){
        this.name = name;
        this.move = move;
    }

    public void setMove(String move){
        this.move += move;
    }

    @Override
    public String toString(){
        return String.format("%s : %s", this.name, this.move);
    }
}
