package Member;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemoDAO myDao = new MemoDAO();

		// 1.������ ����
		MemoDTO a = new MemoDTO();
//		a.setId("aaa");
//		a.setName("aname");
//		myDao.insertOne(a);
//		int k= myDao.insertOne(a);
//		if(k==1) {
//			System.out.println("����");
//		}else if(k==0){
//			System.out.println("����");
//		}
//		// 2. ������ ����
//		a = new MemberDTO();
//		a.setId("bbb");
//		a.setName("bname");
//		myDao.insertOne(a);

		// 2-1.����
		// �ó����� : aaa��� ����� �̸��� kim ����
		// / /
		// update mmember set name='kim' where id='aaa'; �� ����
//		a.setId("aaa");
//		a.setName("kim");
//		myDao.updateOne(a);

		// aaa��� ����� Ż���� . ���� Ʃ�� ���� id�� aaa ��� ��� ����
		// myDao.delOne("aaa");

		// 2-2 aaa ��� ����� ������ ���� ����
//		MemberDTO nowUser =myDao.selOne("bbb");
//		if(nowUser!=null){
//			System.out.println("id: "+ nowUser.getId());
//			System.out.println("name: "+ nowUser.getName());
//			System.out.println("point: "+ nowUser.getPoint());
//		}else {
//			System.out.println("��� X");
//		}
		// 3. ������ ��� ��������
//	ArrayList<MemoDTO> userList=myDao.selAll();
//	for(MemoDTO m:userList) {
//			System.out.println("id: "+ m.getEnglish());
		
////////////////////////////////////////////////////////////////////////////	
	

	// 2. ������ ����
//	a = new MemoDTO();
//	a.setEnglish("banana");
//	a.setMeaning("�ٳ���");
//	myDao.insertOne(a);
//	int k= myDao.insertOne(a);
//	if(k==1) {
//		System.out.println("����");
//	}else if(k==0){
//		System.out.println("����");
//	}
//		a = new MemoDTO();
//		a.setEnglish("banana");
//		a.setMeaning("�ٳ���");
//		myDao.insertOne(a);
////	
//		
//		a.setNo(12);
//		a.setEnglish("grape");
//		myDao.updateOne(a);
//		myDao.delOne("apple");
		
		ArrayList<MemoDTO> userList=myDao.selAll();
		for(MemoDTO m:userList) {
				System.out.println("�ܾ�: "+ m.getEnglish());
		}
		
	}

}
