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
        private String movement;
        public Car (String carName){
            this.carName = carName;
            this.position = 0;
            this.movement = "";
        }
        
        public void move(){
            if(Randoms.pickNumberInRange(0,9)>=4){
                this.position += 1;
                this.movement = movement + "-";
            }
        }


        public String getCarName(){
            return this.carName;
        }

        public int getCarPosition(){
            return this.position;
        }

        public String getMovement(){
            return this.movement;
        }
    }
    public static List<Car> carListMoving(List<Car> carList, StringBuilder sb){
        for(Car car : carList){
            car.move();
            sb.append(car.getCarName() + " : " + car.getMovement() +"\n");
        }

        sb.append("\n");
        
        return carList;
    }
    public static void winnerCheck(List<Car> carList, StringBuilder sb){
        int winnerPosition = 0, position;
        for(Car car : carList){
            position = car.getCarPosition();
            winnerPosition = isBiggerThanPosition(position, winnerPosition);
        }
        sb.append("최종 우승자 : ");
        for(Car car : carList){
            if(winnerPosition == car.getCarPosition()){
                sb.append(car.getCarName()+", ");
            }
        }
        sb.setLength(sb.length()-2);
    }
    public static int isBiggerThanPosition(int position, int winner){
        if(position>winner){
            return position;
        }
        return winner;
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
            carList = carListMoving(carList, sb);
        }

        winnerCheck(carList, sb);
        System.out.println(sb.toString());
    }    
}

