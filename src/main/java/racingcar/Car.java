package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NUMBER=9;
    private static final int MIN_NUMBER=0;
    private static final int MIN_NUMBER_TO_MOVE=4;

    private final String name;
    private int position=0;
    private final StringBuffer report;

    public Car(String name){
        this.name=name;
        this.report=new StringBuffer();
        this.report.append(name);
        this.report.append(" : ");
    }

    public void moveCar(){
        if(Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER)>=MIN_NUMBER_TO_MOVE){
            this.position++;
            this.report.append("-");
        }
    }

    public void statusReport(){
        System.out.println(report);
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}
