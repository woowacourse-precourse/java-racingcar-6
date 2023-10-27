package racingcar.domain;

public class Car {
    private String name;
    private Integer successMoveForwardCount;

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
