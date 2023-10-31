# 기능
1. 입력<br/>
[x] 사용자 이름 입력할 때 ','로 파싱하기<br/>
[x] 사용자 이름 길이가 5보다 길면 IllegalArgumentException<br/>
[x] 사용자 이름이 중복되면 IllegalArgumentException?<br/>
[x] 게임 rotation 수 입력<br/>
[x] 게임의 수가 정수가 아니면 IllegalArgumentException<br/>
[?] 게임의 수의 범위는 어떻게 지정? Integer, Long?<br/>
</br>
2. 게임 진행</br>
[x] 0부터 9까지 랜덤 넘버 하나 생성</br>
[x] 생성한 랜덤 넘버를 기준으로 4보다 작으면 false 반환, 이상이면 true 반환</br>
[x] 전진하는 자동차만 List 담에서 반환</br>
</br>
3. 우승한 사람 찾기</br>
[x] 최대로 이동한 자동차 찾기</br>
[x] 우승자가 한 명 이상일 수 있으니 최대 길이와 동일하게 이동한 우승자를 전부 찾아 List로 반환</br>
</br>
4. 출력</br>
[x] 각 rotation 별로 상황 출력</br>
[x] 우승자 목록을 받아서 출력