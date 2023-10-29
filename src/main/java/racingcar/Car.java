package racingcar;

public class Car {
    private String name;
    private int distance;

    Car(String name){
        PutName(name);
        PutDistance(0);
    }

    public int GetDistance() {
        return distance;
    }

    public String GetName() {
        return name;
    }

    public void PutName(String name) {
        this.name = name;
    }

    public void PutDistance(int distance) {
        this.distance = distance;
    }

    public void PlusDistance(int distance){
        int newDistance = GetDistance()+distance;
        PutDistance(newDistance);
    }

    @Override
    public String toString() {
        String result = name + " : ";
        for(int i=0 ; i<GetDistance() ; i++)
            result = result + "-";
        return result;
    }
}
