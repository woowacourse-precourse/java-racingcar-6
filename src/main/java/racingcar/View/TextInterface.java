package racingcar.View;

import static racingcar.Util.Constants.ENTER_REPETITION;
import static racingcar.Util.Constants.ENTER_USER;

import camp.nextstep.edu.missionutils.Console;

public class TextInterface {
    public String enterPlayer(){
        System.out.println(ENTER_USER);
        return Console.readLine();
    }

    public String enterRepetition(){
        System.out.println(ENTER_REPETITION);
        return Console.readLine();
    }

    public void printDistance(String name, int distance){
        System.out.print(name+ " : ");
        for(int i=0; i<distance; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(String name){
        System.out.print("최종 우승자 : "+ name);
    }

    public void printJointWinner(String name){
        System.out.print(", "+name);
    }
}
