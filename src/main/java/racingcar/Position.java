package racingcar;

public class Position {
    public int position;
    private static final int FORWARD_THRESHOLD=4;
    private static final String SLASH="-";

    public Position(){
        position=0;
    }

    public Position(int status){
        position=status;
    }

    public boolean checkValueIsOverFour(int value){
        return value>=FORWARD_THRESHOLD;
    }

    public void moveForward(){
        position+=1;
    }

    public String switchPositionToSlash(){
        return SLASH.repeat(position);
    }
}
