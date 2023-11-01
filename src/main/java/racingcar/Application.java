package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //경주할 자동차 이름 입력받기
        String[] cars = setCars();
        //자동차 정보 기본 세팅 (움직임횟수)
        int[] carsMove = new int[cars.length];// 0으로 기본세팅


        //경주진행
        //이용자로부터 시도 회수를 입력받음
        int tryNum = setTryNum();

        System.out.println("실행 결과");
        //입력받은 값만큼 반복문 돌리며 자동차 이동 시키기
        for(int i =0 ; i<tryNum ; i++)
        {
            //조건을 따지고 자동차 이동시키는 함수 (carsMove 값이 올라감)
            carsMove = changeMove(carsMove);
            //경주 중간현황 출력
            printStatus(cars,carsMove);
            System.out.println(); //엔터키처리
        }





    }

    //경주 중간현황 출력 함수
    public static void printStatus(String[] cars, int[] carsMove){
        for(int i=0;i < cars.length ; i++)
        {
            System.out.printf("%s : ",cars[i]);
            //움직임 횟수 출력 함수
            printCntMove(carsMove[i]);
        }
    }
    //차 움직임 횟수 출력 함수
    public static void printCntMove(int moveCnt){
        for(int i = 0 ; i < moveCnt; i++ )
        {
            System.out.print("-");
        }
        System.out.println();//엔터키 처리
    }

    //조건 따져서 자동차 이동시키는 함수
    public static int [] changeMove(int[] carsMove){

        for(int i =0 ; i <carsMove.length ; i++ )
        {
            //랜덤값 돌리기
            int randNumb=Randoms.pickNumberInRange(0,9);

            //값 변경
            if (randNumb >= 4 )
                carsMove[i] ++;
        }

        return carsMove;
    }

    //사용자로부터 이동 시도 회수 받기
    public static int setTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        // 사용자로부터 숫자를 입력받기
        try {
            int number = Integer.parseInt(Console.readLine());
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }



    //자동차이름 입력 받아 , 로 구분해서 배열 반환하는 함수
    public static String[] setCars() {

        // 사용자로부터 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();


        // 입력받은 문자열을 콤마로 구분하여 배열로 변환
        try {
            String[] cars = userInput.split(",");
            //*//입력값 오류 확인하는 코드
            boolean isFine = true;

            //각 문자열의 길이가 5 미만인지 확인하는 함수
            isFine = check5Length(cars);



            if (isFine)
                return cars;
            else
                throw new IllegalArgumentException();


        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }




    }

    //길이 5개 확인하는 함수
    public static boolean check5Length(String[] cars){
        for (String elem : cars) {
            if (elem.length() <= 5)
                continue;
            else
                return false;
        }
        return true;
    }
}
