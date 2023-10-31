package racingcar.player;

public class User {
    private final String userName;

    private int forwardDistance = 0;


    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getForwardDistance() {
        return this.forwardDistance;
    }

    public void forward(){
        forwardDistance++;
    }
}
