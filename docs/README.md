### 구현목록

1. inputView 생성하여 자동차 이름 받기<br>
    2. Car 객체 생성, 일급컬렉션 CarList 생성
    3. 자동차 이름을 받을 때 다섯자 이하, 쉼표 구분 valid
    4. 자동차 리스트가 1 미만일 경우 exception
2. inputView 에서 몇번의 이동을 할 것인지 입력받기
3. Service 생성하여 pickNumberInRange()를 통해 무작위 값을 받고 4 이상일 경우 전진
4. 횟수만큼 진행 후 우승자 outPutView 에서 출력, 우승자는 한 명 이상일 수 있음<br>
   4-1. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
5. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료