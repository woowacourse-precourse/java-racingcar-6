package car;

public class Car {
    private String name;

    private int count;

    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public void move(int readNumber){
        if(readNumber >= 4){
            count++;
        }
    }



}
