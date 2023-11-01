package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String initInput;
        ArrayList<String> carName = new ArrayList<>();
        //자동차이름을 배열로 받기위해 선언.
        int carCount=0;
        int tryNum=0;
        boolean flag = false;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        initInput = readLine();
        StringTokenizer st = new StringTokenizer(initInput,",");
        //문자열로 받은 자동차들을 ','로 나누기 위해 선언.

        while(st.hasMoreTokens()) {
            carName.add(st.nextToken()); //자동차 클래스 배열에 생성된 나누어진 이름을 추가.
            if(carName.get(carCount).length() > 5)//글자수가 5글자가 넘어가면 예외처리
            {
                throw new IllegalArgumentException();
            }
            carCount++;
        }

        MakeCar[] car = new MakeCar[carCount];
        //나누어진 자동차이름 수 만큼 자동차클래스배열 생성.
        for(int i = 0;i<carCount;i++){
            car[i] = new MakeCar();
            car[i].carName = carName.get(i);
            //해당 인덱스 클 스의 이름부분에 자동차이름 넣어줌
        }
        System.out.println("시도할 회수는 몇회인가요?");
        try {//시도할 수가 int형이 아니면 예외처리
            tryNum = Integer.parseInt(readLine());

        } catch (IllegalArgumentException e){}

        if (tryNum < 1)
        //시도횟수가 1보다 작으면 예외처리
        {
            throw new IllegalArgumentException();
        }
        System.out.println("\n실행결과");
        for(int i = 0;i<tryNum;i++){
            for(int j=0;j<carCount;j++) {
                car[j].oneRound();
                car[j].carLocationPrint();
            }
            System.out.println();
        }
        Arrays.sort(car);
        //우승자를 출력하기위해 자동차객체의 carscore기준으로 정렬.

        System.out.print("최종 우승자 : ");
        for(int i = 0;i<carCount;i++)
        {
            if(i>0 && car[i].carScore != car[i-1].carScore)
                //스코어순서대로 정렬되어있기때문에 0번째 인덱스부터 스코어가 달라지면 종료.
                break;
            if(i>0)
                System.out.print(", ");
            //두번째 반복문부터 ','출력.
            System.out.print(car[i].carName);
        }

    }
}
