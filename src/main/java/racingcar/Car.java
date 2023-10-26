package racingcar;

public class Car {
    private int cnt;

    public Car() {
        this.cnt = 0;
    }
    public void moveForward(){
        cnt ++;
    }
    @Override
    public String toString() {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i <cnt ; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    public int getCnt(){
        return cnt;
    }
}
