package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Racer{
    String name;
    int distance;

    public Racer(String name){
        this.name = name;
    }
    public void forward(){
        this.distance++;
    }

    public int getDistance(){
        return this.distance;
    }
}
