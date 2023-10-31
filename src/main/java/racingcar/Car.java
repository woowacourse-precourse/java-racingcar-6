package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    Integer go;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getGo() {
        return go;
    }
    public void setGo(Integer go) {
        this.go = go;
    }

    public void GoOrStop(){
        int randnum = makerandom();
        if(randnum >= 4){
            this.setGo(this.getGo()+1);
        }

    }

    public int makerandom(){
        return Randoms.pickNumberInRange(0, 9);
    }

}
