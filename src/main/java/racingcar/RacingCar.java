package racingcar;


public class RacingCar {
    private String name; //5자 이하 규정
    private boolean runnable;
    private String distance;
    RacingCar(String name){
        this.name = name;
        this.distance="";
    }
    String getDistance(){
        return this.distance;
    }
    Boolean getRunnable(){
        return this.runnable;
    }
    String getName(){
        return this.name;
    }
    void setRunnable(boolean runnable){
        this.runnable =runnable;
    }
    void addDistance(){
        this.distance+= "-";
    }
}
