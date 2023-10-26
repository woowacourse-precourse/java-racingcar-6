package racingcar.game;

public class Player {
    private String name;
    private int distance = 0;

    Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
