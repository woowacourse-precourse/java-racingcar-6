### 기능 구현 목록

-[x] 게임 오프닝 멘트 기능
    - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 멘트 출력
-[x] 경주할 자동차 이름 입력 기능
    - 경주할 자동차 이름들은 입력 받는다. ( camp.nextstep.edu.missionutils.Console의 readLine() )
        - 최초 입력 시 입력 값 valid
            - 빈 값 체크
            - null 체크
        - 입력 받은 이름은 쉼표로 구분 하여 관리
            - 입력 받은 이름 중 5자 이하 인지 확인
                - 빈 값인 경우 예외 발생
                - 5자 이하인 경우 정상 진행
                - 5자 초과인 경우 IllegalArgumentException 예외 발생
            - 입력 받은 이름은 공백을 제거 한다.
            - 중복된 이름이 있는 경우 예외를 발생한다.
-[x] 사용자 시도 횟수 입력 기능
    - 시도할 횟수를 입력 받는다. ( camp.nextstep.edu.missionutils.Console의 readLine() )
    - 입력된 횟수가 정상 적인 값인지 확인
        - 정상 적인 입력 값인 경우 정상 진행
        - 숫자가 아닌 경우 IllegalArgumentException 예외 발생
        - Integer MAX 가 넘어 가는 경우 IllegalArgumentException 예외 발생 : 요구사항에 별도의 횟수 제한은 없는 것으로 확인되어 Integer Max로 제한
        - 시도 횟수가 0 또는 0 이하 인 경우 IllegalArgumentException 예외 발생
-[x] 자동차 경주 게임 실행 기능
    - 각각의 경주할 자동차는 랜덤의 값을 리턴 받는다. ( camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() )
        - 랜덤의 값은 범위는 ( 0 ~ 9 ) 이다.
        - 랜덤의 값이 4 이상인 경우 한칸 전진("-") 할 수 있다.
        - 한번의 시도 마다 자동차별 전진한 결과를 출력 한다.
-[x] 우승자 출력 기능
    - 시도한 횟수가 다 돌아간 경우 제일 멀리 전진한 자동차의 이름을 출력한다.
        - 단독 우승의 경우 단독으로 출력 한다.
        - 동시 우승의 경우 입력 순서대로 이름을 출력 한다.

---

### 요구사항 준수 체크리스트

-[x] Java version 을 Java 17 로 진행 되었는가?
-[x] 프로그램의 시작점은 Application 의 Main() 인가?
-[x] build.gradle 을 수정하지 않고, 외부 라이브러리를 사용하지 않았는가?

4. Java 코드 컨벤션을 지켰는가?

-[x] 프로그램 종료 시 Sysytem.exit() 를 사용하지 않았는가?
-[x] Application 의 모든 테스트가 통과 되는가?
-[x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않았는가?
-[x] 3항 연산자를 쓰지 않았는가?

9. 함수가(또는 메소드가) 하나의 일만 하는가?

-[x] JUnit 5와 AssertJ를 이용 하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인 했는가?
-[x] 주어진 라이브러리(pickNumberInRange(), readLine())를 사용 했는가?
