package racingcar;

public class Game {

    private static final int FORWARD_NUM = 1;
    private static final int FORWARD_LIMIT = 4;

    private boolean isForwardAllowed(int number){
        return number >= FORWARD_LIMIT;
    }

    public int forward(int randomNumber, int distance){
        if(isForwardAllowed(randomNumber)) return distance + FORWARD_NUM;
        return distance;
    }

}
