package racingcar;

public class Car {
    private int cnt;
    private String name;

    public Car(String carName) {
        this.name = carName;
        this.cnt = 0;
    }
    public void moveForward(){
        cnt ++;
    }
    @Override
    public String toString() {
        StringBuilder bar = new StringBuilder();
        bar.append(this.name + " : ");
        for (int i = 0; i <cnt ; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    public  int getCnt(){
        return cnt;
    }
    public String getName(){
        return name;
    }

    public boolean isMax(int max){
        if(max == cnt){
            return true;
        }else {
            return false;
        }
    }
}
