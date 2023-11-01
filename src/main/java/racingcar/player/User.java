package racingcar.player;

public class User {
    private final String userName;

    private int forwardDistance = 0;


    public User(String userName) { //setter 이기 떄문에 final 로 선언하여 초기화 이후에 데이터의 변조를 막음
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }//getter

    public int getForwardDistance() {
        return this.forwardDistance;
    } //getter

    public void forward() {
        forwardDistance++;
    }
}
