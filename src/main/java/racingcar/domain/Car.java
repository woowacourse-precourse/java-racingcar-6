package racingcar.domain;

public class Car {
    private String name;
    private Integer successMoveForwardCount = 0;



    private String moveForwardStatus = "";

    public String getMoveForwardStatus() {
        return moveForwardStatus;
    }

    public void setMoveForwardStatus() {
        String moveForwardCountTemp = "";
        for (int i = 0; i < this.successMoveForwardCount; i++) {
            moveForwardCountTemp += "-";
            this.moveForwardStatus = moveForwardCountTemp;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSuccessMoveForwardCount() {
        return successMoveForwardCount;
    }

    public void increaseSuccessMoveForwardCount() {
        this.successMoveForwardCount++;
    }

    public void setSuccessMoveForwardCount(Integer successMoveForwardCount) {
        this.successMoveForwardCount = successMoveForwardCount;
    }
}
