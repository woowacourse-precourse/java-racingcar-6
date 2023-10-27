package racingcar.domain;

public class Car {
    private String name;
    private Integer successMoveForwardCount;

    private String moveForwardStatus;

    public String getMoveForwardStatus() {
        return moveForwardStatus;
    }

    public void setMoveForwardStatus(Integer tryRepetitionNumber) {
        for (int i = 0; i < tryRepetitionNumber; i++) {
            this.moveForwardStatus += "-";
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

    public void setSuccessMoveForwardCount(Integer successMoveForwardCount) {
        this.successMoveForwardCount = successMoveForwardCount;
    }
}
