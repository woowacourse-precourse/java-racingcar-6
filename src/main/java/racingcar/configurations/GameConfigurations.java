package racingcar.configurations;

public enum GameConfigurations {
    MINIMUM_OF_RANGE(0),
    MAXIMUM_OF_RANGE(9),
    CONTROL_VALUE(4),
    MOVING_DISTANCE(1);

    int value;
    GameConfigurations(int value){
        this.value = value;
    }

    public int get(){
        return value;
    }
}
