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

    /**
     * 자동차의 전진 상태를 출력
     */
    public void showStatus(){
        System.out.println(name+" : "+getProgress());
    }

    /**
     * 필드의 forwardCount를 1 증가
     */

    public void incrementForwardCount(){
        forwardCount++;
    }
}
