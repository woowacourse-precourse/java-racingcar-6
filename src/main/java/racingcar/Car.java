package racingcar;

public class Car {
    private String name;
    private int forwardCnt;

    public Car(String name){
        this.name = name;
        this.forwardCnt = 0;
    }

    public void goForward(){
        forwardCnt++;
    }

    public String getName() {
        return this.name;
    }

    public int nowPosition(){
        return this.forwardCnt;
    }

    public String toString() {
        return name + " : " + createProgressString(forwardCnt);
    }

    private String createProgressString(int forwardCount) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < forwardCount; i++) {
            progress.append("-");
        }
        return progress.toString();
    }
}
