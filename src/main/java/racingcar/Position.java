package racingcar;

public class Position {
    public int position;
    private static final int FORWARD_THRESHOLD=4;

    public Position(){
        position=0;
    }

    public boolean checkValueIsOverFour(int value){
        return value>=FORWARD_THRESHOLD;
    }
}
