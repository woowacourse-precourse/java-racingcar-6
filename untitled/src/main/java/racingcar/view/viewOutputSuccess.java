package racingcar.view;

import java.util.ArrayList;

public class viewOutputSuccess {
    public void viewOutputSuccess(ArrayList<String> winArrayList){
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winArrayList.size();i++){
            if(i != 0){
                System.out.print(", ");
            }
            System.out.printf("%s",winArrayList.get(i));
        }
    }
}
