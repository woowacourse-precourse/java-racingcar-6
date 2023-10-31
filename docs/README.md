# 미션 - 자동차 경주

## Input : InputView 사용자로부터 입력 받기
- CarName
  - print : 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
  - read (carNameSplit) List<String>: ex) pobi,woni,jun
    - 쉼표 기준 슬라이싱
    - 이름 조건 : 5자 이하만 가능하다
      - 클래스 : 자동차
        - 멤버변수 : 자동차이름, 전진횟수 (초기값 : 0)
- Round
  - print : 시도할 회수는 몇회인가요?
  - read (round) int: ex) 5
    - 변수 (int) n차수 = read
- wrong Input : IllegalArgumentException 발생 -> 애플리케이션 종료
## InGame : Controller 자동차 경주 게임
- 전
- create carList by CarName, Round
  - class Car[ApplicationTest.java](..%2Fsrc%2Ftest%2Fjava%2Fracingcar%2FApplicationTest.java)
    - 멤버 변수
      - (name) final String
      - (randomNumList) ArrayList<Integer>
      - (forward) int
    - 생성자 (name)
      - new randomNumList
  - class CarList
    - List<Car> carList
    - (round) int
    - 생성자 (carNameSplit)
      - car 객체 리스트 생성
- 중
  - (round)회 반복
    - (carList.length)회 반복
      - 0~9 무작위 값 추출 -> add : randomNumList
        - if 값 >= 4 
          - 전진 : forward ++
- 후
  - (Car.forward) 값을 비교
    - 보다 크거나 같은 값이 나올 경우 업데이트
      - (max) int
      - (winnerList) List<String>
## Output : OutputView 우승자 결과 출력
- (carList) List<Car> : RoundResult : 각 차수별 실행 결과
  - ex)
    - pobi : --
      woni : ----
      jun : ---
    
- (winnerList) List<String> : Winner : 우승자 안내 문구
  - if size = 1
    - case 1) 단독 우승자 안내 문구
      - ex) 최종 우승자 : pobi
  - else
    - case 2) 공동 우승자 안내 문구
      - 우승자가 여러 명일 경우 쉼표(,)로구분
      - ex) 최종 우승자 : pobi, jun
