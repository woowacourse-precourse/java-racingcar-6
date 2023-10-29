package racingcar;

import java.util.List;

public class Print {

    public void progress(String name, int move){
        System.out.print(name + " : ");
        for(int i=0; i<move;i++){
            System.out.print("-");
        }
        System.out.println(" ");
    }

    public void winner(List<String> winner){
        System.out.print("최종 우승자 : ");

        for(int i=0 ; i<winner.size() ; i++){
            System.out.print(winner.get(i));
            if(i!=winner.size()-1){
                System.out.print(", ");
            }
        }
    }

}