package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;

public class Race {
    DriveCar[] driveCars;
    int iter;
    Race(DriveCar[] driveCars, int iter){
        this.driveCars = driveCars;
        this.iter = iter;
    }
    int Dice(){
        return Randoms.pickNumberInRange(0,9);
    }

    void Racing() {
        for (int i = 0; i < iter; i++) {
            RacePoint();
            RaceResult();
            System.out.println();
        }
        System.out.println(FinalResult());
    }

    void RacePoint(){
        for (DriveCar driveCar : driveCars) {
            driveCar.setScore(driveCar.getScore() + RacePointCal());
        }
    }

    int RacePointCal(){
        if(Dice() >= 4)
            return 1;
        else
            return 0;
    }

    void RaceResult(){
        for(DriveCar driveCar : driveCars){
            System.out.print(driveCar.name + " : " );
            ShowRacePoint(driveCar);
        }
    }

    void ShowRacePoint(DriveCar driveCar){
        for(int i = 0; i < driveCar.score; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    String FinalResult(){
        Arrays.sort(driveCars, (Comparator<DriveCar>) (car1, car2) -> Integer.compare(car2.getScore(), car1.getScore()));

        String final_result = "최종 우승자 : ";
        int max_score = -1;

        for(DriveCar driveCar : driveCars) {
            if (max_score <= driveCar.score) {
                final_result = final_result + driveCar.name + ", ";
                max_score = driveCar.score;
            }else {
                break;
            }
        }
        final_result = final_result.trim();
        final_result = final_result.substring(0, final_result.length() - 1);

        return final_result;
    }
}