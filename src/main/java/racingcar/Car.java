
package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String car_name; // 자동차 이름은 프로그램 실행 과정에서 변경되면 안되기 때문에 final로 했다.
    private int car_forward_count;

    public Car(String cname) {
        this.car_name = cname;
        this.car_forward_count = 0;
    }

    public String Get_Car_Name() {
        return this.car_name;
    }

    public int Get_Car_Forward_Count() {
        return this.car_forward_count;
    }

    public int Make_Random_num() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void Forward_Or_Not() {
        int num = Make_Random_num();
        if (num <= 4) {
            car_forward_count++;
        }
    }

    public void Print_Car_Data() {
        System.out.print(car_name + " : ");
        for (int i = 0; i < car_forward_count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int compareTo(Car obj) //Sort 수행시 정렬 기준.
    {
        return obj.Get_Car_Forward_Count() - this.car_forward_count;
    }

}
