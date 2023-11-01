package racingcar.domain;

public interface CarCondition {

    int MOVE_CONDITION = 4;
    int NAME_CONDITION = 5;

    boolean isMoreThanCondition(int randomNumber);
    void checkNameLength(String name);
}
