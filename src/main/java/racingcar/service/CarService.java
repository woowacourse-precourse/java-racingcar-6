package racingcar.service;

import racingcar.object.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarService {
    public void printGuide_InputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public int countCommas(String input){
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ',')
                count++;
        }
        return count;
    }
    public List<String> checkCarsNameLength(String input_cars_name){
        String[] cars_name = input_cars_name.split(",");
        int count_Commas = countCommas(input_cars_name);
        if(cars_name.length != count_Commas + 1){
            throw new IllegalArgumentException("입력값이 없습니다. 자동차 이름을 입력해주세요.");
        }

        List<String> final_cars_name = new ArrayList<>();
        for(String name : cars_name){
            String striped_name = name.strip();

            if(striped_name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
            } else if(striped_name.length() < 1) {
                throw new IllegalArgumentException("자동차 이름으로 공백만을 지정할 수 없습니다.");
            }

            final_cars_name.add(striped_name);
        }
        return final_cars_name;
    }

    public List<Car> inputCarsName(){
        String input_cars_name = readLine();
        List<String> cars_name = checkCarsNameLength(input_cars_name);

        List<Car> carList = new ArrayList<>();
        for(String name : cars_name){
            Car car = Car.createCar(name, "");
            carList.add(car);
        }
        return carList;
    }

    public void appendCarStatus(Car car, String append_status){
        car.setStatus(car.getStatus() + append_status);
    }

    public void printCarStatus(List<Car> carList) {
        System.out.println("\n실행 결과");
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getStatus());
        }
    }

    public void moveCars(List<Car> carList){
        for(Car car : carList){
            int move_count = pickNumberInRange(0 ,9);
            if(move_count >= 4){
                appendCarStatus(car, "-");
            }
        }
    }

    public List<String> checkWinner(List<Car> carList){
        List<String> winners_name = new ArrayList<>();

        int maxLength = 0;
        for(Car car : carList){
            maxLength = Math.max(maxLength, car.getStatus().length());
        }

        for(Car car : carList){
            if(car.getStatus().length() == maxLength){
                winners_name.add(car.getName());
            }
        }
        return winners_name;
    }

    public void printWinners(List<Car> carList){
        System.out.print("\n최종 우승자 : ");
        List<String> winners_name = checkWinner(carList);

        System.out.println(String.join(", ", winners_name));
    }
}
