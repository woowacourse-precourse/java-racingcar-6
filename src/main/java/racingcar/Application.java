package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String[] carname_list = getCarName();
        int n = Integer.parseInt(Console.readLine());

        for(int i=0;i<carname_list.length;i++){
            checkInput(carname_list[i]);
        }

        for(int i=0;i<carname_list.length;i++){
            System.out.println(carname_list[i]);
        }
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
