package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemoDAO { // �ڹ� sql���� �����ϴ� �����ͺ��̽� / connection �� ���� �ܺζ� �����ϴ� �ڿ�

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
				while (rs.next()) { // �����°� �ִٸ� , ù��° �ٿ� Ʃ�ÿ� �ִ� �Ÿ� ���� ���°�
					searDTO = new MemoDTO();
					searDTO.setEnglish(rs.getString("English"));
					searDTO.setEnglish(rs.getString("Meaning"));
					// �̸� �� rs �������°� // �����ͼ� ���� ���� ��ü�� �ִ°�
					
					
					uList.add (searDTO);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ���� ����!!");
		}

		return uList;
	}

	MemoDAO() {
		try {
			// Ŭ������ �ҷ� ���°� ���̺귯�� �о� ��� �Ͷ�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Ŭ���� �ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� �ε� ����");
		}

	}

	private boolean connect() { // ����Ŭ db �� ���� �ϱ� ���� �ڿ�
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
				// int �� return
				// Ŀ���� ���� �� ���� ����

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ���� ����!!");
		}

	}

	public int insertOne(MemoDTO m) {
		// ����Ŭ�� �� ������ ����Ű�� ��ü�� ����
		// ����: db�� ���� sql query �� ������ �Ѵ� > query ����
		if (connect()) {
			try {
				String sql = "insert into Memo values(?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, m.getEnglish());
				psmt.setString(2, m.getMeaning());
				// (1, m.getId() ù��° �ٿ� �ִ� id
			

				int k = psmt.executeUpdate();
				// int �� return
				// Ŀ���� ���� �� ���� ����
				return k;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ���� ����!!");
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
				if (rs.next()) { // �����°� �ִٸ� , ù��° �ٿ� Ʃ�ÿ� �ִ� �Ÿ� ���� ���°�
					searDTO = new MemoDTO();
					searDTO.setEnglish(rs.getString("English"));
					// �̸� �� rs �������°� // �����ͼ� ���� ���� ��ü�� �ִ°�
				
					return searDTO;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ���� ����!!");
		}

		return searDTO;
	}

}
