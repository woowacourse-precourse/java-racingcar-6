package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class Application {

    // 전진 함수
    public static boolean forward(){
        int condition = pickNumberInRange(0, 9);

        if(condition >= 4 ){
            return true;
        }
        else{
            return false;
        }
    }

    // 최종 car 리스트 생성(car distance의 최종 값들을 모아서 정렬하기 위해)
    public static void finalResultSave(Car car, List<Car> finalResult){
        finalResult.add(car);
    }

    // 객체 리스트를 객체의 2번째 인자 값으로 정렬
    public static List<Car> sortCarDistance(List<Car> finalResult){
        Collections.sort(finalResult, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.distance - c2.distance;
            }
        });

        return finalResult;
    }


    // 우승자 리스트 생성
    public static List<String> winnerListGenerator(List<Car> finalResult){
        List<String> winners = new ArrayList<>();


        for(Car c: finalResult){
            if(c.distance == finalResult.get(0).distance){
                winners.add(c.name);
            }
        }

        return winners;
    }




    public static void main(String[] args) {

        // car 리스트 생성
        List<Car> finalResult = new ArrayList<>();

        // car 리스트에 최종 car 객체들 저장

        // car 리스트 distance 값 기준으로 정렬하기
        finalResult = sortCarDistance(finalResult);

        // 우승자 리스트 생성
        List<String> winners = winnerListGenerator(finalResult);




    }
}
