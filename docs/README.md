1. 아래 문구와 함께 경주 할 자동차 이름 받기
   ```
   경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
   ```
    1. 받은 값을 , 기준으로 split 하는 기능
    2. split 시킨 값들을 for문으로 돌며
       1. (exception) 값이 5자를 초과할 경우, `IllegalArgumentException` 발생시키기
2. 아래 문구와 함께 시도할 횟수 값 받기
   ```
   시도할 회수는 몇회인가요?
   ```
    1. (exception) 받은 값이 int 타입이 아닐 경우, `IllegalArgumentException` 발생시키기
3. 시도할 횟수만큼 for문 돌기
    1. 사람 이름을 key, 0을 value로 hashmap 생성
    2. 입력받은 사람 수 만큼 for문 돌기
        1. 0~9 사이에서 무작위수 돌리기
        2. 돌려서 나온 값이 4 이상인 경우, 해당하는 key에 대한 value에 +1
    3. 만약, for문이 0번째라면, `실행 결과`문구 출력
    4. hashmap의 결과를 `각 차수별 실행 결과`로 출력
4. `champion_member`, `top_score = 0` 변수를 만들고, hashmap for문 돌기
    1. if, 해당 key의 value가 max_num 보다 크다면, `champion_member` 변수를 해당 key로 대체
    2. else if, 해당 key의 value가 max_num과 동일하다면, `champion_member` 변수에 해당 key를 더하기
5. `최종 우승자 : `를 출력하고, 그 뒤에 우승자를 저장한 `champion_member` 변수를 출력해준다.