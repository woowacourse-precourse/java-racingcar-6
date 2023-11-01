package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarService {
    RacingCarFactory factory;
    List<String> nameList;
    List<RacingCar> carList;
    int attemptInput;
    RacingCarService() {
        nameList = new ArrayList<>();
        carList = new ArrayList<>();
        factory = new RacingCarFactory();
    }
    void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try{
            String names = Console.readLine();
            if(!names.contains(",")){
                throw new IllegalArgumentException();
            }
            nameList = Arrays.asList(names.split(","));
            if(!checkError(nameList)){
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attempt = Console.readLine();
        attemptInput = Integer.parseInt(attempt);
        createRacingCar();
        racingStart();
    }
    boolean checkError(List<String> checkList){ //에러를 체크
        for(String m:checkList) {
            if (m.length() > 5) {
                return false;
            }
        }
        return true;
    }
    void createRacingCar(){ //car 객체를 만드는 부분
      for(String name:nameList){
          carList.add(factory.createCart(name));
      }
    }
    boolean runnableCheck(int randNum){ //달릴 수 있는지 체크
        if(randNum>=4){
            return true;
        }
        return false;
    }
    void printGame(){
        System.out.println("실행 결과");
        for(RacingCar r:carList){
            System.out.println(r.getName()+": "+ r.getDistance());
        }
    }
    void racingStart(){
        while(attemptInput>0){
            for(RacingCar r:carList){ //차 리스트 들의 전진
                r.setRunnable(runnableCheck(Randoms.pickNumberInRange(0,9)));
                if(r.getRunnable()){
                    r.addDistance();
                }
            }
            printGame();
            attemptInput--;
        }
        caculateScore();
    }
    void caculateScore(){
        List<String> winner = new ArrayList<>();
        int maxDistance = 0;
        for(RacingCar car: carList){
            int distanceLength = car.getDistance().length();
            if(distanceLength>maxDistance){
                maxDistance = distanceLength;
                winner.clear(); //새로운 최대 거리에 도달한 경우, 우승자 리스트 초기화
                winner.add(car.getName());
            }else if(distanceLength ==maxDistance){
                winner.add(car.getName());
            }
        }
        String print = String.join(", ",winner);
        System.out.println("최종 우승자 : " +print.replace("[","").replace("]",""));
    }
}
