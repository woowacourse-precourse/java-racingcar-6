package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static boolean firstWinner = true;

    public List<Car> inputCarName(String cars){ // 컬렉션의 스트림을 통해 콤마로 이름을 구분하고, 구분한 이름을 Car 객체에 넣음
        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    } // inputCarName

    public int inputForwardCar(){ // 시도 횟수 정하는 메소드
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    } // forwardCar

    public static void printFinalWinner(List<Car> cars){ // 최종 우승자 메소드

        int maxForward = maxForward(cars);

        System.out.print("최종 우승자 : ");

        for(Car car : cars){
            oneOrOtherWinner(car, maxForward);
        }

    } // printFinalWinner

    private static int maxForward(List<Car> cars) { // 제일 많이 전진한 것 찾기
        int maxForwardCar = 0;

        for(Car car : cars){
            maxForwardCar = Math.max(maxForwardCar, car.getForwardCount());
        }

        return maxForwardCar;
    }

    public static void printRaceState(List<Car> cars) { // 전진 횟수에 따라 - 찍기
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }

    public static void oneOrOtherWinner(Car car, int maxForward){ // 우승자가 한명 또는 여러명일 때 출력 메소드


        if(car.getForwardCount() == maxForward){

            if(!firstWinner){
                System.out.print(", ");
            } // if

            System.out.print(car.getName());
            firstWinner = false;

        } // if

    }

} // end class
