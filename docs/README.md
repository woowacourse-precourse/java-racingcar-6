### 초간단 자동차 경주 게임
1. 사용자로부터 경주 할 자동차 이름 입력받기 ```input_car_name()```
   - 5자 이하의 이름
     - ex) kiki(o) / kihyun(x)
   - 입력 받을 때 쉼표를 기준으로 이름 구분
     - ex) kiki, min, ...(o) / kiki min shown ...(x)
   - 잘못된 값을 입력했을 때 예외처리 ```check_name_validation()```
     - IllegalArgumentException 발생시키고 앱 종료
       - 이름을 공백으로 입력한 경우
         - ex) kiki, , min
       - 이름이 6자 이상인 경우
2. 시도할 횟수 입력받기 ```input_repeat_count()```
   - 음수를 입력하는 경우 예외처리 ```check_count()```
   - 숫자가 아닌 다른 값을 입력하는 경우 예외처리
3. 0~9 사이의 무작위 값을 구해 4이상일 경우만 전진 ```go_or_stop()```
    - 각 자동차별로 횟수마다 0~9 사이의 무작위 값을 구하기 ```racing()```
      - 0~3의 값이 나올 경우 정지 / 4~9의 값이 나올 경우 전진 
    - 각 회차별로 실행 결과 보여주기 ```print_result()```
4. 우승자 출력하기
   - 직진했을 때 추가된 '-'의 길이를 구해서 가장 긴 사람이 우승 ```racing_winner()```
   - 최종 우승자 출력하기 ```print_winner()```
     - 1명인 경우 
       - 최종 우승자 : kiki
     - 2명 이상인 경우 (쉼표로 이름 구분) ```if_multiple_winners()```
       - 최종 우승자 : kiki, min
