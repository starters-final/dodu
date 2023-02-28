insert into admins values (1,'admin', '2021-12-30T11:11:49.000000', '운영자1', 'admin');
insert into admins values (2, 'admin2', '2021-12-30T11:11:49.000000', '운영자2', 'admin2');
insert into admins values (3,'admin3', '2021-12-30T11:11:49.000000' ,'운영자3', 'admin3' );
insert into admins values (4,'admin4', '2021-12-30T11:11:49.000000', '운영자4', 'admin4' );
insert into admins values (5,'admin5', '2021-12-30T11:11:49.000000', '운영자5','admin5' );

insert into categories values (1, '진학');
insert into categories values (2, '워홀');
insert into categories values (3, '장학금');
insert into categories values (4, '동아리');

insert into questions values (1, '연대 vs 고대 어디가 더 취업률이 높나요?', 1);
insert into questions values (2, '프로그래머가 되려면 컴공 진학은 필수인가요?', 1);
insert into questions values (3, '원하는 학과 vs 원하는 대학 무엇이 우선일까요?', 1);
insert into questions values (4, '지방거점국립대 vs 경기권 일반사립대 어떤게 더 좋은 선택일까요?', 1);
insert into questions values (5, '호주로 워홀가면 보통 어떤 일을 많이 하나요?', 2);
insert into questions values (6, '아시아권 워홀 가기 좋은 국가 추천해주세요!', 2);
insert into questions values (7, '캐나다 vs 호주 워홀 어디로 가야, 생활비가 덜 들까요?', 2);
insert into questions values (8, '미국 워킹홀리데이 준비 방법을 알려주세요', 2);
insert into questions values (9, '장학금 종류와 받기 위한 꿀팁이 궁금합니다', 3);
insert into questions values (10, '교내 장학금은 몇번까지 받을 수 있나요?', 3);
insert into questions values (11, '소득분위 제한이 없는 국가 장학금은 없나요?', 3);
insert into questions values (12, '장학금 받고 어떻게 사용해야 미래에 도움이 될까요?', 3);
insert into questions values (13, '요즘 핫한 연합동아리 추천해주세요', 4);
insert into questions values (14, '봉사동아리에선 정말 봉사만 하나요?', 4);
insert into questions values (15, '다양한 사람을 만나기 좋은 동아리 추천해주세요', 4);
insert into questions values (16, '멋쟁이사자처럼 들어가면 개발자로 취업하는 데 수월할까요?', 4);


insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (1, 21, 'hinodi5@naver.com', 'M', 'https://w.namu.la/s/1f8e131288820ba99a32dc4fc8ccd41237f296e0f10b4fe6754a59eb2047d98136c321cadf03a00880f663ebf15b0ade3f07f19284e4a15160284024e39d149696e63b1646120882cfda5e29a43a4b0fdf9b398bb9e7d4a73ab82065199ecfaa852cf9bf8a3859182e4c371c990b9fc2', '2022-12-13T23:11:59.000000', '이진형', '서울대학교', '컴퓨터공학과', 10, '010-1234-1234', 1, 1);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (2, 24, 'choi@starters.com', 'M', 'https://nimage.g-enews.com/phpwas/restmb_allidxmake.php?idx=5&simg=2017111622213104783298b22ff231101295153.jpg', '2022-12-14T23:11:59.000000', '최원준', '연세대학교', '체육교육학과', 12, '010-1235-1235', 1, 2);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (3, 20, 'kim@woongjintb.com', 'F', 'https://i.namu.wiki/s/70d0e8971c523f10bc79cb8316595382791c622977c115b99a0d09102cf70e95c45769dee363a4bf94f1382293d590e96d9e826a8452cbc8b6165582f6fa8f25e0b4bd3e736ea55282091ddc6b63ca65393e38f244c0939ac41e1b25e1b66edfcda2ea6b8c7e738c0bb15d5409046f7a', '2022-12-15T23:11:59.000000', '김수연', '고려대학교', '정치외교학과', 11, '010-1236-1237', 1, 3);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (4, 23, 'ko@woongjin.com', 'M', 'https://w.namu.la/s/d35484e0690d6a37e6000c5f6b148e7c46de994f838dff311c20e4085c409138c394e3b9ef4c21297b65ebf45fc457c02d173e9cb8e68b4e716fc4fcf01f2150b968dbadac84649f734e750f290708816cff26a117c43deb76a2b3be6be186e110c7dd6323e9806308dddbe0430b5f4d', '2022-12-16T23:11:59.000000', '고의석', '성균관대학교', '영어영문학과', 15, '010-1237-1237', 1, 4);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (5, 24, 'cho@sba.com', 'M', 'https://w.namu.la/s/62b35913643bf17e02ba500198edf9c964038bdcc76b8b2d420fee20575404babddc8ec64f81add5a964f5dfe56c2ab3f8a72df68f27f357c4bf263d3828d2c17bebf7c33b775f29d977a6763cc91e49a7ff20ab53d6988e4184c5b88e640f24b49fe2dc2bb9342f82e36448a672719b', '2022-12-17T23:11:59.000000', '조준형', '한양대학교', '패션디자인학과', 13, '010-1238-1238', 1, 1);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (6, 29, 'weeknd@billboard.com', 'M', 'https://w.namu.la/s/71251b363a78d5befaf3172f98a3452adef4440f7f7fa716c75c2ecf1de079cdc5b83c691fead4c1ab6be8cbf1e7bdb90cd9f897b78e1ab608dbcf7db7add0ad505916332027aec52e703f894a237988c03af65ee25da573cf967be9677b2387e2d8afdde7cf6775783532fe62da6c7c', '2022-12-18T23:11:59.000000', '주말', '상명대학교', '실용음악학과', 0, '010-1239-1239', 0, 2);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (7, 29, 'kimha@4minute.com', 'F', 'https://i.namu.wiki/s/3e6d4075ef8fc3054d7dfd59216e43ab90ecb7f1c3af11b4146d4f4cef0f0e6b68b41883bf538d312e1d2635483ae9b2324d1e1a42b7f34029a7f43c750a46eeed8d0df09fc0ba85391e3e68dd969c49c7e621c1151d45880bade76820e27d9056073df253e710714fb5cdaafc66d15b', '2022-12-18T23:11:59.000000', '정수정', '성균관대학교', '영화학과', 0, '010-1211-1211', 0, 3);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (8, 25, 'zico@ssaebbing.com', 'M', 'https://w.namu.la/s/afab652123e252dd87d29620eb792c64bb5ed1071154bfb13482e54f8c92c2185f9a216e726d8f200c7e76322e4681b79f550b26f3dea0dbdad4eb1b59b616a5d69af64c0bb73985b274dd707214c89891bc9b8910c0070f6b00f6b9564c26455be0edcfd5baa2e3898048ae2de0c9ad', '2022-12-19T23:11:59.000000', '우지호', '동아방송예술대학교', '연기예술학과', 3, '010-1212-1212', 1, 4);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (9, 27, 'leedh@taekwon.com', 'M', 'https://w.namu.la/s/d75f0ee78bfef073a49e307ebf319de7f4c8708bd78f4282617a63f4b49d77e1ceb222104c929e337bdec17ee2a5081c49b8fbe151de57a5257a8ac3418e556d36b018b2386ea53374bb083913eb81ad9dfad153c37abacc29e9d9019369a03e', '2022-12-19T23:11:59.000000', '이대훈', '용인대학교', '태권도학과', 0,'010-1213-1213', 0, 1);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (10, 29, 'jangyw@sba.com', 'F', 'https://i.namu.wiki/s/5306f52be9b9005491d9f28e795a70d653dde4d103cb78f4b96d4b7238d3f5c5a6a65f0177068b884075d05ba25aef175ab2a2fba6877a81e31882f8317e9eecbb8b0889746d0ad6ed9eaedf82b66173b2505664e1842a5e0e4115a266667499b6db681ab912d219c2cfd277f0f0ab1f', '2022-12-23T23:11:59.000000', '장예원', '숙명여자대학교', '미디어학과', 0, '010-1214-1214', 0, 2);
insert into mentors(mentor_id, age, email, gender, image, indate, nickname, university, major, match_count, phone, status, category_id) values (11, 25, 'yoonsh@kaistt.com', 'F', 'https://w.namu.la/s/56626a8aab434b76b54f4adce2592213b067d37bfd20399ce2e5fa28c2fed0b04169e9ec1d682c91206028e95588de57fc4207f748a80c4d234cd785f2ba36c8ff9fcd3c053c5f22e5fc6ae9a50d70e60bd7957a53d25ff30e1488a40dc5603912e6164d4793202eb71311da2cbfc18d', '2022-12-24T23:11:59.000000', '윤소희', '한국과학기술원', '생명화학공학과', 11, '010-1215-1215', 1, 3);

insert into verifications values (1,null,'2023-02-12T11:11:49.000000',3,1);
insert into verifications values (2,null,'2023-02-13T11:58:49.000000',3,4);
insert into verifications values (3,null,'2023-02-14T15:38:49.000000',3,2);
insert into verifications values (4,null,'2023-02-15T13:58:49.000000',3,3);
insert into verifications values (5,null,'2023-02-16T16:18:49.000000',3,5);
insert into verifications values (6,null,'2023-02-17T09:52:49.000000',1,6);
insert into verifications values (7,null,'2023-02-18T12:12:49.000000',2,7);
insert into verifications values (8,null,'2023-02-19T15:8:49.000000',3,8);
insert into verifications values (9,null,'2023-02-20T9:58:49.000000',2,9);
insert into verifications values (10,null,'2023-02-21T17:38:49.000000',2,10);
insert into verifications values (11,null,'2023-02-22T11:33:49.000000',3,11);


insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (1, '서울특별시 용산구', 19, 'yeji@sba.com', 'F', '2022-11-13T23:11:59.000000','김예지', '010-1111-1111');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (2, '서울특별시 서대문구', 18, 'kim@sba.com','M', '2022-11-14T23:11:59.000000','김태현', '010-1111-1112');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (3, '서울특별시 마포구', 18, 'lee@sba.com', 'M','2022-11-15T23:11:59.000000', '이민호', '010-1111-1113');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (4, '서울특별시 용산구', 19, 'huh@sba.com', 'F', '2022-11-16T23:11:59.000000', '허윤진', '010-1111-1114');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (5, '서울특별시 용산구', 19, 'chaechae@sba.com', 'F', '2022-11-17T23:11:59.000000','김채원', '010-1111-1115');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (6, '서울특별시 강남구', 18, 'kazuha@sba.com', 'F', '2022-11-18T23:11:59.000000', '카즈하', '010-1111-1116');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (7, '서울특별시 강북구', 19, 'sakura@sba.com', 'F','2022-11-19T23:11:59.000000', '사쿠라', '010-1111-1117');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (8, '서울특별시 노원구', 18, 'hong@sba.com', 'F', '2022-12-01T23:11:59.000000', '홍은채', '010-1111-1118');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (9, '서울특별시 노원구', 18, 'choisc@sba.com', 'M', '2022-12-02T23:11:59.000000',  '최승철', '010-1111-1110');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (10, '서울특별시 도봉구', 18, 'yoonjh@sba.com', 'M', '2022-12-03T23:11:59.000000', '윤정한', '010-1111-1119');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (11, '서울특별시 강서구', 18, 'hongjs@sba.com', 'M', '2022-12-04T23:11:59.000000', '홍지수', '010-1111-1120');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (12, '서울특별시 용산구', 18, 'wonjh@sba.com', 'M', '2022-12-05T23:11:59.000000', '원쥔훼이', '010-1111-1121');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (13, '서울특별시 강동구', 19, 'kwonsy@sba.com', 'M', '2022-12-06T23:11:59.000000', '권순영', '010-1111-1122');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (14, '서울특별시 용산구', 18, 'jeonww@sba.com', 'M', '2022-12-06T23:11:59.000000', '전원우', '010-1111-1123');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (15, '서울특별시 강서구', 18, 'leejh@sba.com', 'M', '2022-12-13T23:11:59.000000', '이지훈', '010-1111-1124');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (16, '서울특별시 용산구', 18, 'shemh@sba.com', 'M', '2022-12-13T23:11:59.000000', '쉬밍하오', '010-1111-1125');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (17, '경기도 성남시 분당구', 19, 'kimmkng@sba.com', 'M', '2022-12-30T23:11:59.000000', '김민규', '010-1111-1126');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (18, '서울특별시 용산구', 18, 'leesm@sba.com', 'M', '2023-01-01T23:11:59.000000', '이석민', '010-1111-1127');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (19, '서울특별시 용산구', 18, 'boosg@sba.com', 'M', '2023-01-04T23:11:59.000000', '부승관', '010-1111-1128');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (20, '서울특별시 강서구', 18, 'choihs@sba.com', 'M', '2023-01-08T23:11:59.000000', '최한솔', '010-1111-1129');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (21, '서울특별시 용산구', 18, 'leec@sba.com', 'M', '2023-01-15T23:11:59.000000', '이찬', '010-1111-1130');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (22, '경기도 성남시 분당구', 19, 'kimmj@sba.com', 'F', '2023-02-01T23:11:59.000000', '김민지', '010-1111-1131');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (23, '서울특별시 용산구', 18, 'hanni@sba.com', 'F', '2023-02-02T23:11:59.000000', '하니팜', '010-1111-1132');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (24, '서울특별시 강서구', 18, 'mojh@sba.com', 'F', '2023-02-03T23:11:59.000000', '모지혜', '010-1111-1133');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (25, '서울특별시 용산구', 18, 'kanghr@sba.com', 'F', '2023-02-04T23:11:59.000000', '강해린', '010-1111-1134');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (26, '경기도 고양시 일산서구', 18, 'kang@sba.com', 'M', '2023-02-05T23:11:59.000000', '김석진', '010-1111-1135');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (27, '서울특별시 용산구', 18, 'minyk@sba.com', 'M', '2023-02-07T23:11:59.000000', '민윤기', '010-1111-1136');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (28, '서울특별시 성동구', 19, 'jeonghs@sba.com', 'M', '2023-02-10T23:11:59.000000', '정호석', '010-1111-1137');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (29, '경기도 성남시 분당구', 19, 'kimnj@sba.com', 'M', '2023-02-13T23:11:59.000000', '김남준', '010-1111-1138');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (30, '서울특별시 강서구', 18, 'parkjm@sba.com', 'M', '2023-02-13T23:11:59.000000', '박지민', '010-1111-1139');
insert into mentees (mentee_id, address, age, email, gender, indate, nickname, phone) values (31, '서울특별시 강남구', 18, 'kimth@sba.com', 'M', '2023-02-15T23:11:59.000000', '김태형', '010-1111-1140');


insert into applys values (1, '2022-12-13T23:11:59.000000', '2022-12-14T10:00:59.000000', '2022-12-23T23:00:59.000000', '2022-12-31T11:00:00.000000', 1, 1, 1, 1);
insert into applys values (2, '2023-02-12T17:53:49.000000', '2023-02-14T13:00:49.000000', '2023-03-11T13:00:49.000000', '2023-03-21T10:00:49.000000', 1, 2, 1, 3);
insert into applys values (3, '2023-02-13T13:32:49.000000', '2023-03-15T13:00:49.000000', '2023-03-16T13:00:49.000000', '2023-03-17T10:00:49.000000', 0, 3, 2, 8);
insert into applys values (4, '2023-02-14T12:18:49.000000', '2023-03-16T13:00:49.000000', '2023-03-17T13:00:49.000000', '2023-03-18T10:00:49.000000', 0, 4, 3, 12);
insert into applys values (5, '2023-02-15T9:52:49.000000', '2023-02-24T11:00:00.000000', '2023-03-18T13:30:49.000000', '2023-03-21T10:00:49.000000', 1, 5, 4, 13);
insert into applys values (6, '2023-02-16T13:58:49.000000', '2023-03-18T13:00:49.000000', '2023-03-19T13:00:49.000000', '2023-03-19T13:00:49.000000', 0, 6, 5, 2);
insert into applys values (7, '2023-02-17T13:38:49.000000', '2023-02-28T13:00:49.000000', '2023-03-20T13:30:49.000000', '2023-03-21T10:00:49.000000', 1, 7, 8, 14);
insert into applys values (8, '2023-02-18T12:58:49.000000', '2023-03-20T13:00:49.000000', '2023-03-21T13:00:49.000000', '2023-03-21T10:00:49.000000', 0, 8, 11, 15);
insert into applys values (9, '2023-02-19T15:48:49.000000', '2023-03-21T13:30:49.000000', '2023-03-22T13:00:49.000000', '2023-03-23T10:00:49.000000', 1, 9, 2, 6);
insert into applys values (10, '2023-02-20T13:30:49.000000', '2023-03-21T13:00:49.000000', '2023-03-24T13:00:49.000000', '2023-03-28T10:00:49.000000', 0, 10, 3, 16);

insert into matchings values (1, '2023-02-15T13:00:49.000000', '2023-02-24T11:00:00.000000', 2, 5);
insert into matchings values (2, '2023-02-17T13:50:49.000000', '2023-02-28T13:00:49.000000', 2, 7);
insert into matchings values (3, '2023-02-19T16:48:49.000000', '2023-03-21T13:30:49.000000', 2, 9);

insert into chats values(1, '2023-02-24T12:00:00.000000', '2023-02-24T11:00:00.000000', 2, 5, 4);
insert into chats values(2, '2023-02-28T14:00:49.000000', '2023-02-28T13:00:49.000000', 2, 7, 8);
insert into chats values(3, '2023-03-21T14:30:49.000000', '2023-03-21T13:30:49.000000', 0, 9, 2);
