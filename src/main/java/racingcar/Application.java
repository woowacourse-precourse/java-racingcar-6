package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        String names_cars_input;
        String[] names_cars;
        String attempts_input;
        int attempts;
        List<Car> cars_list;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names_cars_input = Console.readLine();
        names_cars = names_cars_input.split(",");
        
        System.out.println("시도할 회수는 몇회인가요?");
        attempts_input = Console.readLine();
        try {
            attempts = Integer.parseInt(attempts_input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

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

        private String getCarName(){
            return car_name;
        }
    }


}
