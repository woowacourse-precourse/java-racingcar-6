package racingcar.domain;

public class Car {
    String name;
    int location;
    public Car(String name){
        if(name.length()>5)
            throw new IllegalArgumentException();
        this.name=name;
    }
    public void showLocation(){
        System.out.printf("%s : %s\n",name,"-".repeat(location));
    }
}
