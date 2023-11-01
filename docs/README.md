자동차 경주 게임

**기능요구항**
n대의 자동차가항주어진다
    >n개의 자동차 주어짐
    > 자동차에 이름 부여((,)기준으로 구분하며 5자이하만 가능)
    경주를 시도하는 횟수
    > x 는 경주를 시도하는 횟수
    > x번 동안 n개의 자동차가 각각 이동한다.
    자동차의 이동
    >전진 조건 :(1~9)무작위 로 값을 받아 4이상일 경우 한칸 전진
    우승자를 알려주어야 한다(한명 이상 가능)
    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료


Model:domain(객체 기본 정보,기본 메서드)   _Car라는 객체 생성 [name, position]#moveForward 
                                    _Game라는 객체 생성[trial,List<car>cars,trialNum]#Game(List<Car>cars, int trial),increaseTrialNum,checkTrial
      repository(객체 데이터 저장)_CarRepository 객채 생성[id,cars]#save,findById,findAll
                              _GameRepository 객체 생성[id,games]#save,isEnd,findById, findAll
service(서비스로직)
View:InputView #requestCarName #requestTrailNumber
     OutView   
Controller:



**프로그래밍 요구사항**
기본: 자바 17,gradle,Application main(),ApplicationTest 통과,멋대로 파일 이름 수정X

추가
    >indent(인덴트, 들여쓰기)depth를 3이 넘지 않도록 구현
    힌트:depth를 줄이기 위해서는 함수(또는 메서드 )분리
    >3항 연산자 쓰지 않는다.
    >메서드 단일책임의 원칙
    >Junit5와 AssertJ를 이용하여 테스트

라이브러리
    >camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    1.Random 값 추출은 camp.nextstep.edu.missionutils.
    Randoms의 pickNumberInRange()를 활용한다.
    2.사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의
    readLine()을 활용한다.

**과제 진행 요구사항**
    >fork & clone
    >readme 작성
    > git의 커밋 단위는 readme에 정리한 단위로 추가


