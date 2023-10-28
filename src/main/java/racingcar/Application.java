package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Vector;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carNameList = carNames.split(",");
        Vector<Car> cars = new Vector<Car>();
        try{
            for(String carName:carNameList){
                Car car = new Car(carName);
                cars.add(car);
            }
            System.out.println("시도할 회수는 몇회인가요?");
            int round = Integer.parseInt(Console.readLine());
            System.out.println("실행 결과");
            for(int i=0;i<round;i++){
                race(cars);
                System.out.println();
            }
            int winnersLength=0;
            for(Car car:cars){
                if(car.getLength()>winnersLength)
                    winnersLength = car.getLength();
            }
            for(int i=cars.size()-1;i>=0;i--){
                if(cars.get(i).getLength()<winnersLength)cars.remove(cars.get(i));
            }
            String winnerList="최종 우승자: ";
            for(Car car:cars){
                winnerList = winnerList+car.getName()+", ";
            }
            winnerList = winnerList.substring(0,winnerList.length()-2);
            System.out.println(winnerList);
        }catch (IllegalArgumentException e){return;}

    }

    private static void race(Vector<Car> cars) {
        for(Car car:cars) car.doRace();
    }
}
