package racingcar;

public class Car {
    private String name;
    private String distance;

    public Car(String name){
        this.name = name;
        validateCarNameLength(name);
        this.distance = "";

    }

    public void validateCarNameLength(String name){
        if(!(0 < name.length() && name.length() <=5))
            throw new IllegalArgumentException();
    }

    public final String getName(){
        return this.name;
    }

    public final String getDistance(){
        return this.distance;
    }

    public final void addDistance(String distance){
        this.distance += distance;
    }


}
