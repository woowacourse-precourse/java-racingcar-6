구현할 기능 목록 정리

controller - model과 view 사이에서 데이터 흐름을 제어
- 경주 할 자동차 이름 입력하는 기능 -> 자동차 개수(List의 size)를 model에게 전달
*이름은 5자 이하만 가능
- 시도할 횟수를 입력하는 기능
- model에서 누가 우승했는지 계산되면 이거를 controller한테 전달하고, 
controller는 view를 호출해서 사용자에게 시각적으로 보여줌

model(referee) - 소프트웨어나 애플리케이션에서 정보 및 데이터 부분, 
controller에게 받은 데이터를 조작(가공)하는 역할을 수행
즉, 데이터와 관련된 부분을 담당하며 값과 기능을 가지는 객체

- Random 값 추출 기능
-> Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 전진하는 기능, 

view - controller에게 받은 model의 데이터를 사용자에게 시각적으로 보여주기 위한
역할을 수행, 사용자에게 보여지는 화면
- 출력: 각 차수별 실행 결과, 단독 우승자 안내 문구, 공동 우승자 안내 문구
-> 자동차 경주를 완료한 후 누가 우승했는지를 알려줌


// 헷갈렸던 부분