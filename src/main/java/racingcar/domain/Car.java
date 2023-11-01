package racingcar.domain;

public class Car {
    private final String name;
    private int location=0;
    private long id;

    public Car(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return id;
    }
    public void incLocation(){
        location++;
    }

    public int getLocation(){
        return location;
    }
}
