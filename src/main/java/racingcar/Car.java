package racingcar;

public class Car {
    //자동차 생성 클래스
    private String name;
    private int move = 0;
    private int ranNumber;

    public Car(String name){
        this.name = name;
    }

    public void MoveCar(){
        move += 1;
    }

    public String ReturnCarName(){
        return name;
    }
    public int ReturnRanNum(){
        return ranNumber;
    }

    public int ReturnMove(){
        return move;
    }



}
