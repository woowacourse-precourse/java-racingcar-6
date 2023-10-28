package racingcar;

import camp.nextstep.edu.missionutils.Console;


import java.io.IOException;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String[] names = getCarNames();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            exit(0);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int trial = getTrialNum();

        for(int i=0; i<trial; i++){

        }

    }

    public static String[] getCarNames() throws IllegalArgumentException{
        String name;

        name = Console.readLine();
        String[] nameslist = name.split(",");

        for(int i=0; i<nameslist.length; i++){
            if(nameslist[i].length() >5){
                throw new IllegalArgumentException();
            }
        }

        return nameslist;
    }

    public static int getTrialNum(){
        int trial = 0;
        try {
            trial = Integer.parseInt(Console.readLine());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. You should input an integer type variable");
            exit(0);
        }

        return trial;
//        if(isInteger()){
//            throw new IllegalArgumentException();
//        }

    }
}
