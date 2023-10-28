package racingcar;

public class Car {
    private String name;
    private Integer forwardCount;

    private String getName() {
        return name;
    }

    private Integer getForwardCount() {
        return forwardCount;
    }

    private String getProgress(){
        return "-".repeat(getForwardCount());
    }

    public String showStatus(){
        return getName()+" : "+getProgress();
    }

    public void incrementForwardCount(){
        forwardCount++;
    }
}
