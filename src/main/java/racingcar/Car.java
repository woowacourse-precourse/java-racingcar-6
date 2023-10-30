package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int distance){
        showMove(distance);
        position += distance;
    }

    public void showMove(int distance){
        System.out.print(name + " : "+showDistance(distance));
    }

    public String showDistance(int distance){
        String distanceStr = "";

        for(int i =0;i<distance;i++){
            distanceStr = distanceStr + "-";
        }
        return distanceStr;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }
}
