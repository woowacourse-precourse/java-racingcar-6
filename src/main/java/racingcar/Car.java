package racingcar;

public class Car {
    private String name;
    private int position = 0;


    public Car(String name){
        setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addPosition(int n){
        this.position = this.position + n;
    }

    public int getPosition(){
        return this.position;
    }
}
