package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Racingprocess {
    public static void randomForward(String[] cars, Integer[] progress, int carindex){
        int randomnumber = Randoms.pickNumberInRange(0,9);
        if(randomnumber >= 4){
            progress[carindex] += 1;
        }
    }
    public static void printRacingStatus(String[] cars, Integer[] progress, int carindex){
        String progressbar = "";
        for(int i=0; i<progress[carindex]; i++){
            progressbar += "-";
        }
        System.out.println(cars[carindex] + " : " + progressbar);
    }

    public void doRace(int rounds, String[] cars, Integer[] progress){
        for(int i=0; i<rounds; i++){
            for(int j=0; j<cars.length; j++){
                randomForward(cars, progress, j);
                printRacingStatus(cars, progress, j);
            }
            System.out.println(" ");
        }
    }
}
