package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Integer position;

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            this.position++;
        }
    }

    public String showCarPosition(){
        StringBuilder trace = new StringBuilder();
        for(int i = 0; i < this.position; i++){
            trace.append("-");
        }
        return this.name+" : "+trace.toString();
    }


}
