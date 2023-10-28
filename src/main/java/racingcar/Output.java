package racingcar;

import java.util.HashMap;

public class Output {

    public static void tellStartAndWantName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    };

    public static void tellGroupName(String [] groupName){
        System.out.println(String.join(",",groupName));
        }

   public static void tellCurrent(HashMap map,String [] groupCar){
        for(String name : groupCar){
            System.out.println(name+" : "+map.get(name));
        }
   }

    }




