# 🖥 Zerobase 미니 기술과제
제로베이스 백엔드 Pro 4기 미니 기술과제입니다.

## 개발 기간
2024.01.13 ~ 2024.01.22
## 개발 환경
- Java 21
- IDE: Intellij
- Framework: SpringBoot
- Database: mysql  8.0.36
##### 서버 포트 : 8888
<br>

## 주요 기능
#### 회원 초대
- 이름, 전화번호, 이메일을 입력 받으면 DB에 임시 회원으로 생성하고 초대 링크를 생성합니다.
#### 초대 수락
- 초대를 수락 할 경우 DB의 회원 상태가 임시에서 활성화 상태로 변경됩니다.
#### 초대 거절
- 초대를 거절 할 경우 DB에 저장된 정보가 삭제됩니다.

<br>

## API 명세서
| API 명| URI | Method | Request | Response
| --- | --- | --- | --- | --- |
| 회원 초대 | /api/invite | POST | InviteRequestDto | ResponseDto |
| 초대 수락 | /api/invite | PUT | String id | ResponseDto |
| 초대 거절 | /api/invite | DELETE | String id | ResponseDto |

###### InviteRequestDto
```js
private String name;
private String phone;
private String email;
```

###### ResponseDto
```js
private boolean success;
private String message;
private URL url;
private MemberEntity memberEntity;
```
<br>

---

#### ☁ 구글 드라이브
용량 문제로 인해 개인 구글 드라이브에 업로드 하였습니다.
https://drive.google.com/drive/folders/1B1R0GzQjVhQiOyUgMtDHdtJr91usPleU?usp=sharing

