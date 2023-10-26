- 생성할 클래스
    1. GameManager 클래스 : 게임 전체를 관리하고 실행한다
    2. Player 클래스 : 게임에 참여하는 유저의 정보를 담는다.

- GameManager 클래스 구성 변수 및 함수
    1. List<Player> players : 플레이어 정보를 저장한다.
    3. int maxCount : 최대 반복횟수
    4. String winner : 우승자, 중복일시 ,를 붙인다.
    5. void play() : maxCount만큼 Player의 move() 함수를 실행한다.
    6. void setResult() : 플레이어별 반환값을 받아서 우승자를 정한다.
       <br> players을 count순으로 정렬한 뒤, 같은 값 까지만 winner에 담는다.
    7. String print() : 최종 우승자를 출력한다. 출력형식은 "최종 우승자 : "+winner

- Player 클래스 구성 변수 및 함수
    1. String name : 플레이어 이름
    2. String result : 진행정도를 String으로 표현
      <br>2-1. getResult, setResult : result를 반환하거나 변화시키는 함수
    3. int count : 진행정도를 int로 표현
      <br>3-1. getCount, setCount : count를 반환하거나 변화시키는 함수
    4. void move() : Random 실행후 4 이상인 경우 setResult()와 setCount()를 사용하여 값을 바꾼다.
    5. void print() : 현재 진행상황을 출력한다. 출력 형식은 name+" : "+result
