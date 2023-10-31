package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Judging {
    GetUserInput getUserInput = new GetUserInput();
    public Judging(){

    }

    public void judgingMovingOrNot(){
        ArrayList<String> carList = new ArrayList<>();
        carList = getUserInput.getName();
        int attempt = getUserInput.getTryNumber();
        int i = 0;

        System.out.println("실행 결과");

        while(i < attempt){
            addDistance(carList);
            i++;
        }
    }

    public void addDistance(ArrayList<String> carList){
        int randomNumber;
        ArrayList<String>[] moving = new ArrayList[1000];
        randomNumber = Randoms.pickNumberInRange(0, 9);

        for(int i = 0; i < carList.size(); i++){
            if(randomNumber >= 4){
                moving[i].add("-");
            }
            else{
                continue;
            }
        }

        printCurrentStatus(carList, moving);
    }

    public void printCurrentStatus(ArrayList<String> carList, ArrayList<String>[] moving){
        for(int i = 0; i < carList.size(); i++){
            for(int j = 0; j < carList.size(); j++){
                System.out.println(carList.get(i) + " : " + moving[i].get(j));
            }
        }
        System.out.println("\n");
    }

}
