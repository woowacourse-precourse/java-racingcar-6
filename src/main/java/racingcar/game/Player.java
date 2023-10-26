package racingcar.game;

public class Player {
    private String name;
    private int distance = 0;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }

    public void forward(){
        this.distance++;
    }
}
