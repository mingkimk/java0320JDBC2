package Member;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemoDAO myDao = new MemoDAO();

		// 1.데이터 삽입
		MemoDTO a = new MemoDTO();
//		a.setId("aaa");
//		a.setName("aname");
//		myDao.insertOne(a);
//		int k= myDao.insertOne(a);
//		if(k==1) {
//			System.out.println("성공");
//		}else if(k==0){
//			System.out.println("실패");
//		}
//		// 2. 데이터 삽입
//		a = new MemberDTO();
//		a.setId("bbb");
//		a.setName("bname");
//		myDao.insertOne(a);

		// 2-1.갱신
		// 시나리오 : aaa라는 사람의 이름을 kim 변경
		// / /
		// update mmember set name='kim' where id='aaa'; 로 변경
//		a.setId("aaa");
//		a.setName("kim");
//		myDao.updateOne(a);

		// aaa라는 사람이 탈퇴함 . 관련 튜플 삭제 id가 aaa 라는 사람 삭제
		// myDao.delOne("aaa");

		// 2-2 aaa 라는 사람의 정보만 가져 오기
//		MemberDTO nowUser =myDao.selOne("bbb");
//		if(nowUser!=null){
//			System.out.println("id: "+ nowUser.getId());
//			System.out.println("name: "+ nowUser.getName());
//			System.out.println("point: "+ nowUser.getPoint());
//		}else {
//			System.out.println("등록 X");
//		}
		// 3. 데이터 모두 가져오기
//	ArrayList<MemoDTO> userList=myDao.selAll();
//	for(MemoDTO m:userList) {
//			System.out.println("id: "+ m.getEnglish());
		
////////////////////////////////////////////////////////////////////////////	
	

	// 2. 데이터 삽입
//	a = new MemoDTO();
//	a.setEnglish("banana");
//	a.setMeaning("바나나");
//	myDao.insertOne(a);
//	int k= myDao.insertOne(a);
//	if(k==1) {
//		System.out.println("성공");
//	}else if(k==0){
//		System.out.println("실패");
//	}
//		a = new MemoDTO();
//		a.setEnglish("banana");
//		a.setMeaning("바나나");
//		myDao.insertOne(a);
////	
//		
//		a.setNo(12);
//		a.setEnglish("grape");
//		myDao.updateOne(a);
//		myDao.delOne("apple");
		
		ArrayList<MemoDTO> userList=myDao.selAll();
		for(MemoDTO m:userList) {
				System.out.println("단어: "+ m.getEnglish());
		}
		
	}

}
