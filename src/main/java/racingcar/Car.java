package racingcar;

public class Car {
    private String name;
    private Integer forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    private String getProgress(){
        return "-".repeat(getForwardCount());
    }

    public void showStatus(){
        System.out.println(name+" : "+getProgress());
    }

    public void incrementForwardCount(){
        forwardCount++;
    }
}
