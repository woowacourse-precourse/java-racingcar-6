package racingcar;

public class Car {
    private String name;
    private Integer forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    private String getName() {
        return name;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    private String getProgress(){
        return "-".repeat(getForwardCount());
    }

    public String showStatus(){
        return name+" : "+getProgress();
    }

    public void incrementForwardCount(){
        forwardCount++;
    }
}
