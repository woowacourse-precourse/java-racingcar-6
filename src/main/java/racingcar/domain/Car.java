package racingcar.domain;

public class Car {
    String name;
    int location=0;
    public Car(String name){
        if(name.length()>5)
            throw new IllegalArgumentException();
        this.name=name;
    }
    public String showLocation(){
        return name+" : "+"-".repeat(location);
    }
}
