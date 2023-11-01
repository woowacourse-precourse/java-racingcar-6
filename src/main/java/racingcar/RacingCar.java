package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int count=0;

    public RacingCar(String input_name) {
        if(!is_valid_input_name(input_name)){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name=input_name;
    }

    static boolean is_valid_input_name(String inputName) {
        return 0<inputName.length() && inputName.length()<6;
    }

    public void move() {
        if(getRandomNum()>=4)
            this.count++;
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void printNowCount(){
        System.out.print(this.name + " : ");
        for(int i=0;i<this.count;i++){
            System.out.print('-');
        }
        System.out.println();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                '}';
    }
}
