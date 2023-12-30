package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Racingprocess {
    public static void randomForward(ArrayList<Integer> progress, int carindex){
        int randomnumber = Randoms.pickNumberInRange(0,9);
        if(randomnumber >= 4){
            progress.set(carindex, progress.get(carindex) + 1);
        }
    }
    public String makingStatusBar(ArrayList<String> cars, ArrayList<Integer> progress, int carindex){
        String progressbar = "";
        for(int i=0; i<progress.get(carindex); i++){
            progressbar += "-";
        }

        String result = cars.get(carindex) + " : " + progressbar;
        return result;
    }
    public void doRace(int rounds, ArrayList<String> cars, ArrayList<Integer> progress){
        for(int i=0; i<rounds; i++){
            for(int j=0; j<cars.size(); j++){
                randomForward(progress, j);
                Userconsole.printRaceStatus(makingStatusBar(cars, progress, j));
            }
            System.out.println(" ");
        }
    }
}
