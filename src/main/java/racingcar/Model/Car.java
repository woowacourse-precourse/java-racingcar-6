package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private String name;
    private Integer process;

    public Car(String name){
        this.name = name;
        process = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getProcess(){
        return this.process;
    }

    public void trial(){
        int n = Randoms.pickNumberInRange(0, 9);
        if(n >=4)
            this.process++;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.process, o.process);
    }
}
