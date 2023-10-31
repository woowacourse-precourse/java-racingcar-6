- 생성할 클래스
    1. GameManager 클래스 : 게임 전체를 관리하고 실행한다
    2. Player 클래스 : 게임에 참여하는 유저의 정보를 담는다.
    <br><br>
- GameManager 클래스 구성 변수 및 함수
    1. List<Player> players : 플레이어 정보를 저장한다.
        <br>1-1. addPlayers(Player player) : players에 player를 추가하는 함수
        <br>1-2. setPlayers() : Console로 입력값을 받아 StringTokenizer로 분리, addPlayers 수행 
    2. int maxCount : 최대 반복횟수
        <br>2-1. setMaxCount, getMaxCount : maxCount를 반환 또는 변경하는 함수
    3. String winner : 우승자, 중복일시 ,를 붙인다.
        <br>3-1. setWinner, getWinner : winner를 반환 또는 변경하는 함수
    4. void play() : maxCount만큼 Player의 move() 함수를 실행한다.
    5. void findWinner() : 플레이어별 반환값을 받아서 우승자를 정한다.
        <br> players을 count순으로 정렬한 뒤, 같은 값 까지만 winner에 담는다.
    6. String print() : 최종 우승자를 출력한다. 출력형식은 "최종 우승자 : "+winner
    7. gameInit(int maxCount) : 초기화함수, players 재선언, maxCount 지정, winner = ""로 초기화
    8. GameManager(int maxCount) : 생성자, 변수가 없을시 GameInit(0), 변수 존재시 gameInit(maxCount) 실행   
    <br>
- Player 클래스 구성 변수 및 함수
    1. String name : 플레이어 이름
        <br>1-1. setName, getName : name을 반환 또는 변경하는 함수
    2. String result : 진행정도를 String으로 표현
        <br>2-1. getResult, setResult : result를 반환 또는 변경하는 함수
    3. int count : 진행정도를 int로 표현
        <br>3-1. getCount, setCount : count를 반환 또는 변경하는 함수
    4. void move() : Random 실행후 4 이상인 경우 setResult()와 setCount()를 사용하여 값을 바꾼다.
    5. void print() : 현재 진행상황을 출력한다. 출력 형식은 name+" : "+result
    6. Player(String name) : 생성자, result = "", count = 0, name = name 으로 변경
    <br><br>
- 함수 세분화
    1. Game 클래스 추가
        1. 출력형식에 맞게 입력을 받고 GameManager의 메서드를 호출하는 역할을 하는 클래스를 생성하였다
        2. 출력문구는 마지막 결과를 제외하고 상수로 만들어 분리하였다.
    2. GameManager 클래스
        1. addPlayer() : 기존의 Console.readLine()을 받아 StringTokenizer() 로 문자를 분리하여 
            <br>while문을 사용하여 List.add를 수행하던 방식에서 뎁스를 줄이기 위해
            <br>함수 setPlayer()를 추가하고, 내부에 addPlayer()를 넣어 StringTokenizer와 List.add 를 분리하였다.
            - addPlayer()는 players에 해당 플레이어를 추가하는 작업만을 수행하며,
            - setPlayer()가 StringTokenizer로 문자열을 분류하여 addPlayer를 실행한다.
    3. Player 클래스
       1. 역순 정렬을 위해 Comparable<Player>인터페이스를 선언 하였다.