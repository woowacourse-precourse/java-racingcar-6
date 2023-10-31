package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        String[] names_cars;
        int attempts;
        int winners_location = 0;
        List<String> winners_names = new ArrayList<String>();
        List<Car> cars_list = new ArrayList<Car>();
        int attempts_cnt = 0;

        //1
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names_cars = inputCarsNames();

            System.out.println("시도할 회수는 몇회인가요?");
            attempts = inputAttempts();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        //2
        for (String cars_name : names_cars) {
            cars_list.add(new Car(cars_name));
        }

        //4
        System.out.println("\n실행 결과");
        while(attempts_cnt < attempts){
            //3
            for (Car car : cars_list) {
                car.carMoving();
                car.printCurrentLocation();
            }
            System.out.println("");
            attempts_cnt++;
        }

        //5
        for (Car car : cars_list) {
            if (car.getCurrentLocation() > winners_location){
                winners_names.clear();
                winners_names.add(car.getCarName());
                winners_location = car.getCurrentLocation();
            }else if (car.getCurrentLocation() == winners_location){
                winners_names.add(car.getCarName());
            }
        }

        //6
        System.out.println("최종 우승자 : " + String.join(", ", winners_names));
    }


    public static String[] inputCarsNames() throws IllegalArgumentException{
        String[] names_cars;
        names_cars = Console.readLine().split(",");

        for (String car_name : names_cars) {
            if (car_name.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return names_cars;
    }

    public static int inputAttempts() throws IllegalArgumentException{
        int attempts;
        try {
            attempts = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return attempts;
    }

}

class Car{
    String car_name;
    int current_location;

    Car(String car_name){
        this.car_name = car_name;
        this.current_location = 0;
    }

    void carMoving(){
        int rnd_num = Randoms.pickNumberInRange(0, 9);
        if(rnd_num >= 4){
            current_location +=1;
        }
    }

    int getCurrentLocation(){
        return current_location;
    }

    void printCurrentLocation(){
        System.out.print(car_name + " : ");
        for (int cnt =0; cnt < current_location; cnt++){
            System.out.print("-");
        }
        System.out.println();
    }

    String getCarName(){
        return car_name;
    }
}