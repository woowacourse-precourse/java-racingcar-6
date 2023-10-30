package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    //사람 추가
    public List<String> addPerson(String persons){
        String[] personArray = persons.split(",");
        List<String> people = new ArrayList<>();
        for(int i = 0; i < personArray.length; i++){
            if(personArray[i].length() > 5){
                throw new IllegalArgumentException("길이가 너무 김");
            }
            people.add(personArray[i]);
        }
        return people;
    }

    // 자동차 클래스 추가
    public List<Car> addCar(List<String> people){
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < people.size(); i++){
            Car car = new Car(people.get(i));
            carList.add(car);
        }
        return carList;
    }

    // 랜덤 숫자 뽑기
    public int randomNumber(){
        int number = Randoms.pickNumberInRange(0,9);
        return number;
    }

    public int randomNumber(int number){
        return number;
    }

    // 랜덤 숫자를 이용해서 자동차 움직임 추가
    public void move(List<Car> carList){
        for(int i = 0; i < carList.size(); i++){
            int randNum = randomNumber();
            carList.get(i).move(randNum);
        }
    }

    public void move(List<Car> carList, int randNumber){
        for(int i = 0; i < carList.size(); i++){
            int randNum = randomNumber(randNumber);
            carList.get(i).move(randNum);
        }
    }

    // 이동 결과 출력하기
    public void result(List<Car> carList){
        for(int i = 0; i < carList.size(); i++){
            carList.get(i).printResult();
        }
    }

    // 숫자인지 확인
    public boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    // 실행 횟수
    public int count(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String strCount = Console.readLine();
        if(!isNumber(strCount)){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        int count = Integer.parseInt(strCount);
        return count;
    }

    // 게임 실행결과
    public void gameResult(List<Car> carList, int count){
        System.out.println("실행 결과");
        for(int i = 0; i < count; i++){
            move(carList);
            result(carList);
            System.out.println();
        }
    }

    public void gameResult(List<Car> carList, int randNumber, int count){
        System.out.println("실행 결과");
        for(int i = 0; i < count; i++){
            move(carList, randNumber);
            result(carList);
            System.out.println();
        }
    }

    // 이동한 숫자중 가장 큰 숫자 뽑기
    public int maxCount(List<Car> carList){
        List<Integer> countList = new ArrayList<>();
        for(int i = 0; i < carList.size(); i++){
            countList.add(carList.get(i).getCount());
        }
        Integer maxInteger = Collections.max(countList);
        int max = maxInteger.intValue();
        return max;
    }

    // 우승자 가리기
    public List<String> winner(List<Car> carList, int max){
        List<String> winnerList = new ArrayList<>();
        for(int i = 0; i < carList.size(); i++){
            if(carList.get(i).getCount() == max){
                winnerList.add(carList.get(i).getName());
            }
        }
        return winnerList;
    }

    // 우승자 출력하기
    public void printWinner(List<String> winnerList){
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winnerList.size(); i++){
            if(i < winnerList.size() - 1){
                System.out.printf("%s, ", winnerList.get(i));
            }else{
                System.out.print(winnerList.get(i));
            }
        }
    }

}
