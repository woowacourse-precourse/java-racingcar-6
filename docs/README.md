## 자동차 경주 요구사항

### 기능
* [x] 사용자는 쉼표를 기준으로 자동차 이름을 입력한다.
  - 이름은 5자 이하만 가능하다
- 사용자는 몇 번의 이동을 할 것인지 입력한다


- 주어진 횟수동안 n대의 자동차는 전진하거나 멈춘다
  - 전진 조건은 0에서 9 사이 무작위값이 4 이상일 경우


- 회수마다 자동차 이름과 함께 현 상태를 출력한다
- 게임이 완료되면 가장 앞서있는 사람이 우승자임을 출력한다
  - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다


- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시킨 후 애플리케이션은 종료된다
  - 잘못된 값이란
    - 이름이 5자를 초과하는 경우
    - 이름이 공백인 경우
    - 이름이 중복되는 경우
    - 회수가 0 이하인 경우

### 커밋 컨벤션

git commit type : git commit message

```
feat (feature) 
fix (bug fix) 
docs (documentation) 
style (formatting, missing semi colons, …) 
refactor 
test (when adding missing tests) 
chore (maintain)
```

[Angular Js Commit Convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 차용
