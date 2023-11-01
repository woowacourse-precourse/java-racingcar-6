package domain;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name){
        this.name = name;
    }

    public Car(String name, int moveCount){
        this.name = name;
        this.moveCount = moveCount;
    }

    //차 이름이 같다면 같은 객체로 판단
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;

        Car car = (Car)o;
        return this.name.equals(car.getName());
    }

    public void move(){
        this.moveCount++;
    }

    public String getName(){
        return name;
    }

    public int getMoveCount(){
        return moveCount;
    }
}
