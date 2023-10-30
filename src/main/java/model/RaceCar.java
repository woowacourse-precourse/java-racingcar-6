package model;

import message.ErrorMessage;

public class RaceCar {
    private final String name;
    private int moveForwardCount;

    public RaceCar(String name) {
        if(name == null) {
            throw new NullPointerException(ErrorMessage.EXCEPTION_OBJECT_NULL);
        }

        this.name = name;
    }

    public void MoveForward() {
        ++moveForwardCount;
    }

    public String getName() {
        return new String(name);
    }

    public int getMoveForwardCount() {
        int copyMoveForwardCount = moveForwardCount;

        return copyMoveForwardCount;
    }

}
