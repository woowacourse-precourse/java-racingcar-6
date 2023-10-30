기능구현목록

프로그램 절차
1. 자동차이름 입력 요구메세지 출력

2. 자동차 n대의 이름 입력 (쉼표로 구분됨)

3. 횟수 입력  요구메세지 출력

4. 시도횟수 입력 (String -> int)

5. 경주 진행사항 출력
    - "실행결과" 출력
    - 입력된 시도회수만큼, 경주실행 후 현황판 출력을 반복

6. 최종우승자 출력 
    - 제일 많이 진행한 자동차 이름 출력 (중복시 입력순)

----- --- ----- ----- --- -- -- ---  --- -- --
## CONTROLLER ##

AppController : 전체 프로세서 처리
CarListController : 입력값을 사용가능한 데이터로 변환
InputCount : 시도횟수 저장
InitGame : 출력을 위한 입력값을 받음
Result : InitGame에서 추출한 값으로 결과 출력.

## MODEL ##

Car(name) : 자동차 클래스
  - name : 멤버 메소드로 입력받음
  - position : 전진한 횟수
  - moveOrStop() : 난수를 생성해 4이상일시 position++;

FindWinner : 어레이에 접근해, 가장 많이 전진한 사람을 탐색
  - StringBuilder를 사용 (값의 수정이 String보다 용이)
  - for-each 문을 사용해 car 리스트를 순회함.
  - if (position > threshold) 일시 문자열 초기화 후에
스트링에 car.name 추가
  - else if (position == threshold) 일시 ", " + car.name 추가

InputToName : 입력된 스트링을 쉼표로 구분해 arrayList에 저장
  - 임시배열에 input.split(",") 으로 이름 저장
  - 어레이리스트에 Arrays.asList(임시배열) 로 변환
  - 이름길이검사 : 원소의 길이가 5를 초과할시 예외종료

NameToClass : 자동차이름을 각각 Car 객체에 저장, 객체리스트로 변환.
  - for-each 문으로 car(name) 객체생성 후 list에 추가, 반복
## VIEW ##

GuessNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
GuessCountMessage = "시도할 횟수는 몇회인가요?";
ResultMessage = "실행결과";
WinnerMessage = "최종 우승자 : ";
MoveMessage = "-";

printStatus(String name, int position) 현재 round 상황
  - name + " : " MoveMessage.repeat(position)

printWinner(StringBuilder name)
  - WinnerMessage + name
  - name = StringBuilder.getWinner();
