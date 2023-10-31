package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String[] carname_list = getCarName();
        int n = Integer.parseInt(Console.readLine());
        List<Car> car_list = makeCarlist(carname_list);
    }

    public static List<Car> makeCarlist(String[] cname_list){
        List<Car> res_list = new ArrayList<>();

        for(int i=0;i<cname_list.length;i++){
            checkInput(cname_list[i]);
            Car new_car = new Car();
            new_car.InitCarInfo(cname_list[i]);
            res_list.add(new_car);
        }
        return res_list;
    }


    public static String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname_str = Console.readLine();
        return carname_str.split(",");
    }

    public static void checkInput(String c_name){
        try {
            if (!checkInput_len(c_name)) {
                throw new IllegalArgumentException("input error");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("input error");
        }
    }

    public static boolean checkInput_len(String c_name){
        boolean res_checkinput = true;

        if(c_name.length()>5){
            res_checkinput =  false;
        }
        return res_checkinput;
    }


}
