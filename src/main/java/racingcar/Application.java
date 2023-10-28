package racingcar;

import camp.nextstep.edu.missionutils.Console;


import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            String[] names = getCarNames();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            exit(0);
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
}
