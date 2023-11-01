package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String initInput;
        ArrayList<String> carName = new ArrayList<>();
        //MakeCar carCopy = new MakeCar();
        int carCount=0;
        int tryNum=0;
        boolean flag = false;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        initInput = readLine();
        //System.out.println(initInput);
        StringTokenizer st = new StringTokenizer(initInput,",");

        while(st.hasMoreTokens()) {
            carName.add(st.nextToken());
            if(carName.get(carCount).length() > 5)
            {
                throw new IllegalArgumentException();
            }
            carCount++;
        }

        MakeCar[] car = new MakeCar[carCount];
        for(int i = 0;i<carCount;i++){
            car[i] = new MakeCar();
            car[i].carName = carName.get(i);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryNum = Integer.parseInt(readLine());

        } catch (IllegalArgumentException e) {
           // System.out.println("noname....error");
        }
        if (tryNum < 1)
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

        System.out.print("최종 우승자 : ");
        for(int i = 0;i<carCount;i++)
        {
            if(i>0 && car[i].carScore != car[i-1].carScore)
                break;
            if(i>0)
                System.out.print(", ");
            System.out.print(car[i].carName);
        }

    }
}
