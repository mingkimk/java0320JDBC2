package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemoDAO { // 자바 sql에서 제공하는 데이터베이스 / connection 은 연결 외부랑 연결하는 자원

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	ArrayList<MemoDTO> uList = new ArrayList<>();

	public ArrayList<MemoDTO> selAll() {
		ArrayList<MemoDTO> uList = new ArrayList<>();
		MemoDTO searDTO = null;
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from Memo";
				rs = stmt.executeQuery(sql);
				while (rs.next()) { // 가져온게 있다면 , 첫번째 줄에 튜플에 있는 거를 가쟈 오는것
					searDTO = new MemoDTO();
					searDTO.setEnglish(rs.getString("English"));
					searDTO.setEnglish(rs.getString("Meaning"));
					// 이름 을 rs 가져오는것 // 가져와서 내가 만든 객체에 넣는것
					
					
					uList.add (searDTO);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}

		return uList;
	}

	MemoDAO() {
		try {
			// 클래스를 불러 오는거 라이브러리 읽어 들어 와라
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
		}

	}

	private boolean connect() { // 오라클 db 에 접속 하기 위한 자원
		boolean cFlag = false;
		try {
			conn = DriverManager.getConnection("" + "jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			cFlag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return cFlag;
	}

	public void delOne(String English) {
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "delete from Memo where english='" + English +"'";
				stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateOne(MemoDTO m) {
		if (connect()) {
			try {
				String sql = "update Memo set english=? where id=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, m.getEnglish());
				psmt.setString(2, m.getMeaning());
		
				int k = psmt.executeUpdate();
				// int 로 return
				// 커리문 실행 된 값을 리턴

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}

	}

	public int insertOne(MemoDTO m) {
		// 오라클에 엠 변수가 가르키는 객체를 저장
		// 절차: db에 접속 sql query 를 만들어야 한다 > query 실행
		if (connect()) {
			try {
				String sql = "insert into Memo values(?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, m.getEnglish());
				psmt.setString(2, m.getMeaning());
				// (1, m.getId() 첫번째 줄에 있는 id
			

				int k = psmt.executeUpdate();
				// int 로 return
				// 커리문 실행 된 값을 리턴
				return k;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}
		return 0;
	}

	public MemoDTO selOne(String English) {
		MemoDTO searDTO = null;
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from mmember where english='" + English + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) { // 가져온게 있다면 , 첫번째 줄에 튜플에 있는 거를 가쟈 오는것
					searDTO = new MemoDTO();
					searDTO.setEnglish(rs.getString("English"));
					// 이름 을 rs 가져오는것 // 가져와서 내가 만든 객체에 넣는것
				
					return searDTO;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}

		return searDTO;
	}

}
