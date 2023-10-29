# 구현한 기능 목록

## 1. 자동차 정보 `Car` 클래스
- 목적: 자동차 이름, 위치 정보 저장
- Field: 이름(`String`), 위치(`Integer`), 숫자 판별(`Numbers`)
- Method: 차종별 시도(`void` &rarr; `void`), 차종별 출력(`void` &rarr; `void`)
### 차종별 출력
`${this.name}` : `${"-".repeat(this.position)}` 꼴로 출력
### 차종별 시도
1. 랜덤한 0~9 사이 숫자 생성
2. 숫자 판별(`Numbers.compareFour`) 함수로 체크
3. 판별 후 `this.position += 0 || 1`

## 1. 숫자 판별 `Numbers` 클래스
- 목적: if 문을 대신 하기 위해 `HashMap`를 이용하여 0~9 를 key 값으로 두고 value로 increasement
- Field: map(`Map<Integer, Integer>`)
- Method: 숫자 판별(`int` &rarr; `int`)
### 숫자 판별
map에서 해당 value를 리턴
