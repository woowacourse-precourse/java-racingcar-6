package racingcar.model;

public class Participant {
    String name;
    int index;
    int point;

    public Participant(int index, String name) {
        this.name = name;
        this.index = index;
        this.point = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void go(int randomNumber){
        if(randomNumber >= 4)
            point++;
    }
}
