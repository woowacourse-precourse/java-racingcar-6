package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import data.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final static int GO = 4;
    List<Car> cars;
    int tryLimit;
    int max;
    List<Car> winnerCars;

    public RacingCarGame(){
        cars = new ArrayList<>();
        tryLimit = 0;
        int max = -1;
        winnerCars = new ArrayList<Car>();
    }

    public void run() {
        inputNames(splitInputNames());
        inputTryLimit();
        System.out.println();
        System.out.println(race());
        setMax();
        setWinnerCars();
        System.out.println(getWinnerNames());
    }

    private String[] splitInputNames(){
        String[] names;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        names = inputNames.split(",");
        return names;
    }

    private void inputNames(String[] names){
        if(names.length>0){
            for(String name : names){
                cars.add(new Car(name));
            }
        }
    }

//    //only for test
//    public ArrayList<String> carsToString(List<Car> cars){
//        ArrayList<String> s = new ArrayList<>();
//        if(winnerCars.size()>0){
//            for(Car car : cars){
//                s.add(car.getName());
//            }
//        }
//        return s;
//    }

    private void inputTryLimit(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryLimit = Console.readLine();
        tryLimit = Integer.parseInt(inputTryLimit);
    }

    private String raceForOneTry(){
        StringBuilder result = new StringBuilder();
        int command;
        for(Car car : cars){
            command = Randoms.pickNumberInRange(1,9);
            if(command >= GO)
                car.add();
            result.append(car)
                    .append("\n");
        }
        return result.toString();
    }

    private String race(){
        StringBuilder result = new StringBuilder();
        System.out.println("실행 결과");
        for(int tryNum = 0; tryNum < tryLimit; tryNum++){
            result.append(raceForOneTry())
                    .append("\n");
        }
        return result.toString();
    }

    private void setMax(){
        for(Car car : cars){
            int currentLength = car.getTrackLength();
            if(currentLength>max) {
                max = currentLength;
            }
        }
    }

    private void setWinnerCars(){
        for(Car car : cars){
            if(car.getTrackLength() == max)
                winnerCars.add(car);
        }
    }

    private String getWinnerNames(){
        StringBuilder winners = new StringBuilder();
        winners.append("최종 우승자 : ");
        for(int index = 0; index < winnerCars.size(); index++){
            Car car = winnerCars.get(index);
            winners.append(car.getName());
            if(index != winnerCars.size()-1)
                winners.append(", ");
        }
        return winners.toString();
    }
}
