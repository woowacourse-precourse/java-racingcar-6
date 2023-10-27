package racingcar;

public class Car {
    private String name;
    private int movingCount = 0;

    public void setName(String name){
        this.name = name;
    }
    public void increaseMovingCount(int movingCount){
        this.movingCount ++;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
