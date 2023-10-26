package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars=inputCars();
        int tryOut=tryGameCount();

        for(int i=0;i<tryOut;i++){
            List<Integer> randomCondition=forwardCondition(cars.size());

        }

    }
    public static List<String> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars=new ArrayList<>();

        String car=camp.nextstep.edu.missionutils.Console.readLine();
        String checkCar[]=car.split(",");

        for(int i=0;i<checkCar.length;i++){

            if(checkCar[i].length()<=5)
                cars.add(checkCar[i]);
            else if (checkCar[i].length()>5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다");


        }
        return cars;
    }
    public static int tryGameCount(){
        System.out.println("시도할 회수는 몇 회인가요?");
        String firstInput= camp.nextstep.edu.missionutils.Console.readLine();
        int tryOut=0;

        try{
            tryOut=Integer.parseInt(firstInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도할 횟수는 숫자로 표현해야 한다");
        }

        return tryOut;
    }
    public static List<Integer> forwardCondition(int carSize){
        List<Integer> randomNumber=new ArrayList<>();
        int repeatNumber=0;

        for(int i=0;i<carSize;i++){
            repeatNumber= Randoms.pickNumberInRange(0,9);

            if(repeatNumber>=4)
                randomNumber.add(1); //1: 전진 가능
            else if(repeatNumber<4)
                randomNumber.add(0); //0: 전진 불가능


        }

        return randomNumber;
    }
}
