package racingcar.user.model;

public class User {
    private Integer tryCount;

    public User(Integer tryCount){
        this.tryCount = tryCount;
    }
    public Integer getTryCount() {
        return tryCount;
    }
}
