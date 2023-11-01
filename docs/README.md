# 프로그램 flow 및 요구사항
1. 자동차 이름 입력 안내 문구 출력
2. 다음 줄에 자동차 이름 입력
   1. camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 사용자 입력
   2. 최대 5자 이하로 입력
   3. 쉼표로 자동차를 구분하여 한 줄에 모두 입력
   4. 잘못된 입력을 한 경우, IllegalArgumentException을 발생시킨 후 프로그램 종료
   5. 프로그램을 종료한다면, exit()를 호출하면 안됨.

3. 시도할 횟수 입력 안내 문구 출력
4. 다음 줄에 시도할 횟수 입력
   1. camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 사용자 입력
   2. 잘못된 입력(자연수가 아닌 입력)을 한 경우, IllegalArgumentException을 발생시킨 후 프로그램 종료

5. 자동차 전진 과정
   1. 0~9의 무작위 값을 구함
   2. 값이 4 이상일 경우에만, 자동차 전진
   3. camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용하여 무작위 값 추출
   4. 각 차수마다, 각 자동차에 대하여 실행
6. 각 차수별 실행 결과 출력
   1. 각 자동차에 대하여 전진된 결과 출력
   2. 전진했다면, '-' 추가
   3. 출력 형식은 "{자동차 이름} : {전진된 횟수만큼의 '-'}"

7. 최종 우승자 안내 문구 출력
   1. 우승자는 여러명일 수 있음.
   2. 여러명일 경우 쉼표로 구분하여 출력

# 주의할 기타 요구사항
1. indent는 2까지만 허용
2. 3항 연산자 사용 X
3. 함수는 최대한 작게 만들기