# 자동차 경주 게임

# 정리
1. 자동차 이름을 입력 받는다. (이름의 길이는 5 이하)
2. 게임을 반복할 횟수를 입력 받는다.
3. 게임의 한 턴마다 자동차 각각 랜덤 숫자를 생성한다.
4. 해당 랜덤 숫자가 4 이상인 경우 전진한다. (랜덤 값은 0~9)
5. 게임이 완료된 후 가장 많이 전진한 자동차가 우승한다.
6. 우승자는 한 명 이상일 수 있으며 여려명인 경우 쉼표로 구분한다.

# 기능 목록
- [v] 자동차 클래스 설계 : 이름, 전진 횟수 - RCar : name, forwardCount
- [v] 입력 처리
    - [v] 자동차 이름 입력받아 쉼표를 기준으로 자동차 분리해 자동차 객체 생성 - separateCar()
    - [v] 이동할 횟수 저장 - racingCount()
- [v] 전진 기능 구현
    - [v] 랜덤 숫자 생성 : 범위 0 ~ 9 - createRandomNumber()
    - [v] 랜덤 숫자 4 이상이면 전진 - forwardCar()
    - [v] 전진하면 자동차의 전진 횟수 업데이트 - updateforwardCount()
- [v] 전진 결과 출력 : 자동차 별로 전진 결과 화면 출력 - forwardResult()
- [v] 우승자 출력 : 전진 횟수가 가장 높은 자동차 우승, 여러 명인 경우 쉼표로 구분해 출력 - findWinner()
- [v] 테스트 코드 작성



# 주의 사항
System.exit() 호출 불가
잘못된 값 입력시 `IllegalArgumentException` 예외 발생 후 애플리케이션 종료
depth은 2까지 허용
3항 연산자 사용 불가
랜덤 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용
사용자 입력 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
테스트 코드 활용해 기능 목록 정상 동작 확인


# 결과 예시
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun