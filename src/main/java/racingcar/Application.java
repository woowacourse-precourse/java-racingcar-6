package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //경주할 자동차 이름 입력받기
        String[] cars= setCars();
        //자동차 정보 기본 세팅 (움직임횟수)
        int [] carsMove = new int[cars.length];// 0으로 기본세팅






    }



    //자동차이름 입력 받아 , 로 구분해서 배열 반환하는 함수
    public static String[] setCars(){

        // 사용자로부터 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();


        // 입력받은 문자열을 공백으로 구분하여 배열로 변환
        String[] cars = userInput.split(",");



        //*//입력값 오류 확인하는 코드
        boolean isFine = true;

        //각 문자열의 길이가 5 미만인지 확인
        for(String elem :cars)
        {
            if (elem.length() <=5)
                continue;
            else
                isFine = false;
        }



        if(isFine)
            return cars;
        else
            throw new IllegalArgumentException();


    }

}
