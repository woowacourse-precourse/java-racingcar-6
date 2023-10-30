package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName();
    }

    public static void inputCarName(){
       String input = Console.readLine();
       String[] name = input.split(",");

       try {
           if(!checkLength(name)) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
           else if(!duplicateName(name)) throw new IllegalArgumentException("이미 이름이 존재합니다.");
       }catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
       }

    }

    private static boolean checkLength(String[] arr){
        boolean flag = false;

        for(String s : arr){
            flag = s.length() <= 5;
        }
        return flag;
    }

    private static boolean duplicateName(String[] arr){
        boolean flag = true;
        List<String>  list = new ArrayList<>();

        for(String s : arr){
            if(list.contains(s)) flag = false;
            else{
                list.add(s);
            }
        }

        return flag;
    }
}
