package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int distance){
        if(distance>=4){
            position++;
        }
        showPosition();
    }

    public void showPosition(){
        System.out.print(name + " : ");
        for(int i=0;i<position;i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }
}
