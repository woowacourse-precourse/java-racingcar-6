package domain;

import java.util.Objects;

public class Car {
    String name;
    int forward;

    public Car(String name){
        this.name = name;
        forward=0;
    }
    public Car(String name,int forward){
        this.name = name;
        this.forward = forward;
    }
    public void moveForward(){
        forward++;
    }
    public String getName(){
        return name;
    }
    public int getForward(){
        return forward;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Car otherCar = (Car)obj;
        return Objects.equals(this.name,otherCar.name) && Objects.equals(this.forward,otherCar.forward);
    }

    @Override
    public int hashCode() {
        return (name + forward).hashCode();
    }
}
