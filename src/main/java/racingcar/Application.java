package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    
    static class Car {
        private String carName;
        private int position;

        public Car (String carName){
            this.carName = carName;
            this.position = 0;
        }
        
        public void move(){
            if(Randoms.pickNumberInRange(0,9)>=4){
                this.position += 1;
            }
        }
        
        public String getCarName(){
            return this.carName;
        }

        public int getCarPosition(){
            return this.position;
        }
    }
    public static List<Car> carListMoving(List<Car> carList, StringBuilder sb){
        for(Car car : carList){
            car.move();
            sb.append(car.getCarName() + " : " + car.getCarPosition() +"\n");
        }
        return carList;
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        List<Car> carList = new ArrayList<>();
        
        
        //리스트 생성
        while (st.hasMoreTokens()) {
            carList.add(new Car(st.nextToken()));
        }
        
        System.out.println("시도할 회수는 몇회인가요?\n");
        int count = Integer.parseInt(Console.readLine());
        
        StringBuilder sb = new StringBuilder().append("실행결과\n");

        for(int i = 0; i < count; i++){
            carListMoving(carList, sb);
        }
        System.out.println(sb.toString());
    }    
}

