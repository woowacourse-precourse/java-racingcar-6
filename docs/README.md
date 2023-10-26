1. 자동차 이름 부여
   1) 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 문구 출 
   2) 쉼표 기준으로 구분해서 carList 에 담음
   3) 자동차 이름 6자 이상 일 시 IllegalArgumentException
   4) 자동차 이름 중복 일시 IllegalArgumentException
2. 이동 횟수 입력
   1) 시도할 회수는 몇회인가요? 출력
   2) 양의 정수 아닐 시 IllegalArgumentException
3. 자동차 이동
   1) Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
   2) carList크기 만큼 Move 배열 생성
   3) 전진 조건은 Random 값이 4 이상일 경우 Move 배열에 1씩 더함
4. 결과 출력
   1) Move 요소의 크기 만큼 '-' 출력
5. 우승자 출력
   1) HashMap에 자동차 이름,Move 요소 담음
   2) Move의 맥스값과 HashMapd의 value를 비교하여 맥스값이랑 일치 시 해당 Key값 WinnerList에 담음
   3) winnerList 출력