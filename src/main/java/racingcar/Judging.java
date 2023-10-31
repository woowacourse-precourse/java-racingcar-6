package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Judging {
    GetUserInput getUserInput = new GetUserInput();
    Finishing finishing = new Finishing();
    public Judging(){
    }

    public void judgingMovingOrNot(){
        ArrayList<String> carList = new ArrayList<>();
        ArrayList<String>[] result = new ArrayList[100];

        for (int j = 0; j < 100; j++) {
            result[j] = new ArrayList<String>();
        }

        carList = getUserInput.getName();
        int attempt = getUserInput.getTryNumber();

        System.out.println("\n실행 결과");

        for (int i = 0; i < attempt; i++) {
            result = addDistance(carList, result);
        }

        finishing.findingMax(carList, result);
    }

    public ArrayList<String>[] addDistance(ArrayList<String> carList, ArrayList<String>[] result){
        int randomNumber;

        for(int i = 0; i < carList.size(); i++){
            randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber >= 4){
                result[i].add("-");

            }
            else{
                continue;
            }
        }
        printCurrentStatus(carList, result);
        System.out.println("");
        return result;
    }

    public void printCurrentStatus(ArrayList<String> carList, ArrayList<String>[] moving){
        for(int i = 0; i < carList.size(); i++){
            System.out.print(carList.get(i) + " : ");
            for(int j = 0; j < moving[i].size(); j++){
                System.out.print(moving[i].get(j));
            }
            System.out.println("");
        }
    }

}
