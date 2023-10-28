package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        
    }


    static class Car{
        String car_name;
        int current_location;

        Car(String car_name){
            this.car_name = car_name;
            this.current_location = 0;
        }

        private void carMoving(){
            int rnd_num = Randoms.pickNumberInRange(0, 9);
            if(rnd_num >= 4){
                current_location +=1;
            }
        }

        private int getCurrentLocation(){
            return current_location;
        }

        private void printCurrentLocation(){
            System.out.print(car_name + " : ");
            for (int cnt; cnt < current_location; cnt++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
