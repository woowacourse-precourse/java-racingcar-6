<h1>구현해야 할 기능 목록</h1>

<ol>
    <li>
        <h2>사용자에게 입력을 받는 기능</h2>
        <ul>
            <li><h4>JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용한다.</h4></li>
            <li><h4>사용자에게 입력을 받는다.</h4></li>
            <li><h4>사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.</h4></li>
            <li><h4>자동차들의 이름을 입력받는 기능.</h4></li>
            <li><h4>입력받은 자동차들의 이름을 쉼표를 기준으로  List로 바꿔주는 기능.</h4>
            <li><h4>입력받은 자동차들의 이름이 올바른 입력인지 검사하는 기능.</h4></li>
            <li><h4>정수를 입력받아 반환하는 기능.</h4></li>
            <li><h4>올바른 정수를 입력했는지 검사하는 기능.</h4></li>
        </ul>
    </li>
    <br>
    <li>
        <h2>RacingCar 플레이어 기능</h2>
        <ul>
            <li><h4>결승 지점과 자동차명을 입력받는 생성자.</h4></li>
            <li><h4>전진하는 기능.</h4></li>
            <li><h4>상태(전진 상태)를 출력하는 기능.</h4></li>
            <li><h4>현재 위치를 반환하는 기능.</h4></li>
            <li><h4>자동차명을 반환하는 기능.</h4></li>
        </ul>
    </li>
    <br>
    <li>
        <h2>게임 기능</h2>  
        <ul>
            <li><h4>1에서 입력받은 정수를 이동 횟수에 세팅하는 기능.</h4></li>
            <li><h4>1에서 입력받은 자동차의 이름들을 플레이어의 생성자에 넣어 자동차들을 생성하는 기능.</h4></li>
            <li><h4>실행 결과를 출력하는 기능.</h4></li>
            <li><h4>자동차를 이동하는 기능.</h4></li>
            <li><h4>게임을 시작하는 기능.</h4></li>
            <li><h4>현재 상태를 출력하는 기능.</h4></li>
            <li><h4>우승자를 결정하는 기능.</h4></li>
            <li><h4>게임을 종료하는 기능.</h4></li>
        </ul>
    </li>
    <br>
    <li>
        <h2>랜덤 값을 반환하는 기능</h2>
        <ul>
            <li><h4>0에서 9 사이에서 무작위 값을 반환하는 기능.</h4></li>
        </ul>
    </li>
    <br>
    <li>
        <h2>RacingCarPlayer과 String, List 간의 포맷을 변경하는 기능</h2>
        <ul>
            <li><h4>RacingCarPlayer를 String으로</h4></li>
            <li><h4>String를 RacingCarPlayer로</h4></li>
            <li><h4>List<RacingCarPlayer>를 List<String>으로</h4></li>
            <li><h4>List<RacingCarPlayer>를 String으로</h4></li>
            <li><h4>List<String>를 List<RacingCarPlayer>로</h4></li>
        </ul>
    </li>
    <br>
    <li>
        <h2>모든 경우의 수를 테스트하는 기능</h2>
        <ol>
            <li>
                <h3>사용자의 입력을 테스트하는 기능</h3>
                <ol>
                    <li><p>이름 중 하나라도 5글자를 넘는 경우 IllegalArgumentException을 발생시키는가? - [ ]</p></li>
                    <li><p>이름들의 ',' 사이에 공백을 포함한 경우 IllegalArgumentException을 발생시키는가? - [ ]</p></li>
                    <li><p>이름에 공백을 입력한 경우 IllegalArgumentException을 발생시키는가? - [ ]</p></li>
                    <li><p>시도할 횟수가 0 이하인 경우 IllegalArgumentException을 발생시키는가? - [ ]</p></li>
                    <li><p>시도 횟수를 입력하지 않은 경우 IllegalArgumentException을 발생시키는가? - [ ]</p></li>
                </ol>
            </li>
            <li>
                <h3>RacingCarPlayer를 테스트하는 기능</h3>
                <ol>
                    <li><p>move 시 currentPosition이 1만큼 증가하는가? - [v]</p></li>
                    <li><p>currentPosition에 따라 정상적으로 현재 위치가 출력되는가? - [v]</p></li>
                </ol>
            </li>
            <li>
                <h3>RacingCarGame을 테스트하는 기능</h3>
                <ol>
                    <li><p>가장 멀리 간 자동차가 우승했는가? - [v]</p></li>
                    <li>자동차가 랜덤 결과에 따라 정상적으로 움직이는가? - [v]</li>
                </ol>
            </li>
            <li>
                <h3>RacingCarPlayer과 List, String 간의 포맷팅을 태스트하는 기능</h3>
                <ol>
                    <li><p>RacingCarPlayer가 String으로 정상적으로 변환되는가? - [v]</p></li>
                    <li><p>String이 RacingCarPlayer로 정상적으로 변환되는가? - [v]</p></li>
                    <li><p>List<RacingCarPlayer>가 List<String>으로 정상적으로 변환되는가? - [v]</p></li>
                    <li><p>List<RacingCarPlayer>가 String으로 정상적으로 변환되는가? - [v]</p></li>
                    <li><p>List<String>이 List<RacingCarPlayer>로 정상적으로 변환되는가? - [v]</p></li>
                </ol>
            </li>
            <li>
                <h3>랜덤 함수를 테스트하는 기능</h3>
                <ol>
                    <li><p>랜덤 함수가 0에서 9까지의 정수 중 한 개의 정수를 반환하는가? - [v]</p></li>
                </ol>
            </li>
        </ol>
    </li>
</ol>