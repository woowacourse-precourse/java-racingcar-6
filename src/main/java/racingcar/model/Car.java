package racingcar.model;

public class Car {
    String name;
    String stat;

    public Car (String name){
        this.name = name;
        this.stat = "";
    }

    public String getName() {
        return name;
    }

    public String getStat() {
        return stat;
    }

    public void updateStat(){
        this.stat += "-";
    }

}
