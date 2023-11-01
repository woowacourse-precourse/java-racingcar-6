package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Car{
    private String name;
    public int position =0;

    public Car(String name){
        this.name=name;
    }

    public String getCarName(){
        return name;
    }

    public int getCarPositioin(){
        return position;
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input= Console.readLine();
        String[] carNames=input.split(",");
        List<Car> cars=new ArrayList<>();
        for (String carName: carNames){
            if(carName.isEmpty()){
                throw new IllegalArgumentException();
            }
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount;
        try {
            tryCount=Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(tryCount<1){
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        for (int i=1;i<tryCount+1;i++){
            for (Car car : cars){
                // 자동차 이동
                int randomNumber= Randoms.pickNumberInRange(0,9);
                if(randomNumber>=4){
                    car.position++;
                }
                //실행값 출력
                System.out.println(car.getCarName()+" : "+"-".repeat(car.getCarPositioin()));
            }
            System.out.println();
        }



    }
}
