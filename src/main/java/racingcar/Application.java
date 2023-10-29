package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    //1. 자동차 이름 적기(쉼표(,)를 기준으로 구분하며 이름은 5자 이하만)
    //2. 시도할 횟수 적기
    //3. 만약 잘못 입력하면 에러 발생 후 종료(예외처리1,2,3)
    //4. 처음 시작 위치는 0부터 시작이고 시도 횟수까지만 실행
    //5. 전진하는 조건이 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우에만 전진, 4 미만이면 정지
    //6. 시도 횟수 만큼 실행하고 마지막에 가장 많이 전진한 자동차를 선정(최대 값으로 뽑으면 되겠지?) 그런데 만약 최대 값이 여러 명이면 같이 우승자로 선정
    //7. 우승자가 한명이면 한명 만 출력 여러 명이면 쉼표(,)를 사용하여 출력
    public static void main(String[] args) {

        System.out.println("자동차 이름을 쉼표(,)로 구분하여 입력하세요:");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");

        //(예외처리1)입력 차 이름이 문자가 아닐 경우
        ExeptionProcess exception = new ExeptionProcess();
        // 이름이 비어있지 않고, 공백 문자만으로 구성되지 않는지, 숫자인지 확인
        for (String name : carNames) {
            if (!exception.isValidCarName(name)) {
                throw new IllegalArgumentException("유효하지 않은 자동차 이름: " + name);
            }
        }

        //(예외처리2)입력된 자동차 이름의 길이가 5 이하 인지 검사
        for (String carName : carNames) {
            if (carName.replaceAll("\\s", "").length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다: " + carName);
            }
        }

        //Car클래스에 입력값으로 초기화
        Car[] car = new Car[3];
        for(int i =0; i< car.length; i++)
        {
            car[i] = new Car(carNames[i]);
        }

        System.out.println("시도할 회수를 입력하세요:");
        String tryCountInput = Console.readLine();


        //(예외처리3)실행 횟수 정수가 아닐때 검사
        int tryCount;
        try {
            tryCount = Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }

        //결과값 출력
        System.out.println("실행 결과");
        for(int j=0; j<tryCount; j++)//5회반복
        {
            //차1,차2,차3의 거리
            for (Car value : car) {
                int distance = Randoms.pickNumberInRange(0, 9);
                value.move(distance);
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        //우승자 발표

        //1, 단독우승인지, 2명이상 공동우승인지 구분을 해야함다
        //2. 어떻게 구분을 지을지  최대값?으로 구분을지을까
        //3. 단독이면 그이름 한명만 출력 공동이면 공동우승한사람만 출력

        Winner win =new Winner();
        win.findWinner(car[0].position,car[1].position,car[2].position,car[0].name,car[1].name,car[2].name);

    }
}