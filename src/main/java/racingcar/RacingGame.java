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

    public static String printFinalWinner(List<Car> cars){ // 최종 우승자 메소드
        StringBuffer sb = new StringBuffer();
        int maxForward = maxForward(cars);

        sb.append("최종 우승자 : ");

        for(Car car : cars){
            String winner = oneOrOtherWinner(car, maxForward);
            sb.append(winner);
        }
        return sb.toString();
    } // printFinalWinner

    public static int maxForward(List<Car> cars) { // 제일 많이 전진한 것 찾기
        int maxForwardCar = 0;

        for(Car car : cars){
            maxForwardCar = Math.max(maxForwardCar, car.getForwardCount());
        }

        return maxForwardCar;
    }

    public static String printRaceState(List<Car> cars) { // 전진 횟수에 따라 - 찍기
        StringBuffer sb = new StringBuffer();

        for (Car car : cars) {
            sb.append(car.getName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static String oneOrOtherWinner(Car car, int maxForward) {
        StringBuffer sb = new StringBuffer();

        if (car.getForwardCount() == maxForward) {
            if (!firstWinner) {
                sb.append(", ");
            }

            sb.append(car.getName());
            firstWinner = false;
        }

        return sb.toString();
    }

} // end class
