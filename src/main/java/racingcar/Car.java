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

    public void InitCarInfo(String c_name){
        this.setName(c_name);
        this.setGo(0);
    }
    public void GoOrStop(){
        int randnum = makerandom();
        if(randnum >= 4){
            this.setGo(this.getGo()+1);
        }
        System.out.println(printInfo(this.getGo()));
    }

    public String printInfo(int r_num){
        String res_print = this.getName() + " : ";
        for(int i=0;i<r_num;i++){
            res_print += "-";
        }
        return res_print;
    }

    public int makerandom(){
        return Randoms.pickNumberInRange(0, 9);
    }

}
