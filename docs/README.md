# 미션 - 자동차 경주

## Input : InputView 사용자로부터 입력 받기
- print : 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
- read : ex) pobi,woni,jun
  - 쉼표 기준 슬라이싱
  - 이름 조건 : 5자 이하만 가능하다
    - 클래스 : 자동차
      - 멤버변수 : 자동차이름, 전진횟수 (초기값 : 0)
- print : 시도할 회수는 몇회인가요?
- read : ex) 5
  - 변수 (int) n차수 = read
- wrong Input : IllegalArgumentException 발생 -> 애플리케이션 종료
## InGame : Controller 자동차 경주 게임
- 전진
  - 조건 : 0~ 9 무작위 값 추출 -> 값이 4 이상
## Output : OutputView 우승자 결과 출력
- 각 차수별 실행 결과
- 우승자 안내 문구
  - 우승자가 여러 명일 경우 쉼표(,)로구분