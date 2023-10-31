package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String[] carname_list = getCarName();
        int n = Integer.parseInt(Console.readLine());
        List<Car> car_list = makeCarlist(carname_list);
        for(int i=0;i<n;i++){
            Game(car_list);
        }
        findWinner(car_list);
    }

    public static void Game(List<Car> c_list){
        for(int i=0;i<c_list.size();i++){
            c_list.get(i).GoOrStop();
        }
        System.out.println();
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

    public static void findWinner(List<Car> c_list){
        Collections.sort( c_list, (o1,o2) -> o2.go - o1.go );
        int max_score = c_list.get(0).getGo();
        String res_winner = c_list.get(0).getName()+",";
        for(int i=1;i<c_list.size();i++){
            if(c_list.get(i).getGo() == max_score){
                res_winner += c_list.get(i).getName()+",";
            }else{
                break;
            }
        }
        System.out.println(res_winner);
    }


}
