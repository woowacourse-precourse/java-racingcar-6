package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.IllegalArgumentException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNum = Console.readLine();
        String[] CarArray = carNum.split(",");

        //CarArray의 입력 check
        CheckCarArray(CarArray);

        System.out.println("시도할 회수는 몇회인가요?");
        String racingStr = Console.readLine();
        int racingNum = Integer.parseInt(racingStr);

        //레이싱 시작
        StartRacing(CarArray, racingNum);
    }
    public static void CheckCarArray(String[] CarArray) {
        for(String s: CarArray) {
            if(s.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력합니다.");
            }
        }
    }

    public static void StartRacing(String[] CarArray, int racingNum) {
        ArrayList<Integer> forwardDistance = new ArrayList<>();

        //차의 개수만큼 진행도 배열에 개수 추가
        for(String s: CarArray) {
            forwardDistance.add(0);
        }

        System.out.println("실행 결과");
        for(int i=0; i< racingNum; i++) {
            //각 사람마다 랜덤함수 돌리고 조건에 따라 전진
            GoOrStop(forwardDistance);

            //차수별 실행 결과 출력
            PrintIntermediateResult(CarArray, forwardDistance);
            System.out.println();
        }


        //다 돌았으니까 우승자 파악
    }

    public static void PrintIntermediateResult(String[] CarName,ArrayList<Integer> distanceArray) {
        for(int c = 0; c < CarName.length; c++) {
            System.out.print(CarName[c] + " : ");

            for(int d=0; d< distanceArray.get(c); d++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void GoOrStop(ArrayList<Integer> distanceArray) {
        //각 진척도를 순회하며 랜덤 값이 4 이상이면 전진
        for(int j=0; j< distanceArray.size(); j++) {
            if(Randoms.pickNumberInRange(0,9) >= 4) {
                int distanceValue = distanceArray.get(j);
                distanceValue +=1;
                distanceArray.set(j,distanceValue);
            }
        }
    }


}
