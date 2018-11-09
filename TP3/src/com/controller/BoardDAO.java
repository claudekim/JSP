package com.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.dto.ItemPageTO;
import com.dto.VPDDTO;
import com.dto.itemDTO;
import com.dto.qnaDTO;
import com.dto.qnaPageTO;
import com.dto.statisiticDTO;
import com.dto.thmemberDTO;

public class BoardDAO {

	private DataSource dataFactory;

	// �����������������������������
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// ������������ݾ��ֱ� �޼ҿ��������������
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ������������α��ΰ����ִ��� üũ�L�ڡ�����������
	public thmemberDTO login(thmemberDTO login) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select id, pw, who from thmember where id=? and pw=?";
		ResultSet rs = null;
		thmemberDTO result = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPw());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String who = rs.getString("who");
				result = new thmemberDTO(id, pw, who);
				System.out.println(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return result;

	}

	// ��������������̵� �����˻�������������
	public boolean exist(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from thmember where id = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (!rs.next())
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return true;
	}

	// ������������ȸ�����ԡ�����������
	public void insert(thmemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into thmember(id, pw, name, address, sex, birthday, who) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getSex());
			pstmt.setString(6, dto.getBirthday());
			pstmt.setString(7, dto.getWho());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	// �������������Ϲ����� ���� ��ȸ������������
	public thmemberDTO userselect(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select pw,name,address,to_char(birthday,'yyyy-mm-dd')birthday,sex,who from thmember where id=?";
		ResultSet rs = null;
		thmemberDTO dto = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String birthday = rs.getString("birthday");
				String sex = rs.getString("sex");
				String who = rs.getString("who");

				System.out.println(pw);
				System.out.println(name);
				System.out.println(address);
				System.out.println(birthday);
				dto = new thmemberDTO(id, pw, name, address, sex, birthday, who);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	// �������������Ϲ����� ���� ����������������
	public void userUpdate(thmemberDTO dto) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update  thmember set name=?, address=?,birthday=?,sex=?,pw=? where id=?";

		try {
			conn = dataFactory.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getBirthday());
			pstmt.setString(4, dto.getSex());
			pstmt.setString(5, dto.getPw());

			pstmt.setString(6, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ����������������Ż��ФС�����������
	public void userDelete(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from thmember where id=?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("dao���� ������");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ ��ǰ �Է�/ ����Ʈ/ ����/ �˻�/ ���� ������������
	// ��ǰ�Է� // --------------�����
	// ��ǰ�Է�
	public void insertItem(itemDTO dto, String fileName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into item (gnum, gtitle, gcontent, greadcnt) values (?,?,?,0)";

		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);

			int gnum = createGnum(conn);
			insertImg(conn, gnum, fileName);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			pstmt.setString(2, dto.getGtitle());
			pstmt.setString(3, dto.getGcontent());

			pstmt.executeUpdate();

			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			closeAll(null, pstmt, conn);
		}
	}

	private void insertImg(Connection conn, int gnum, String fileName) {
		PreparedStatement pstmt = null;
		String sql = "insert into image_file values (?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			pstmt.setString(2, fileName);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	private int createGnum(Connection conn) {
		int gnum = 0;
		PreparedStatement pstmt = null;
		String sql = "select max(gnum) from item";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				gnum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return gnum + 1;
	}

	// ������������ ��ǰ ����Ʈ +���Ǳۼ� �߰� ������������
	public ItemPageTO page(int itemCurPage) {
		ArrayList<itemDTO> itemList = new ArrayList<itemDTO>();
		ItemPageTO Ito = new ItemPageTO();
		Ito.setItemCurPage(itemCurPage);

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from (select rownum rnum, gnum, "
				+ "gtitle, gcontent, to_char(gwriteday, 'yyyy-mm-dd')gwriteday, "
				+ "greadcnt, qnaNum from((select * from item order by gwriteday desc)))" + "where rnum between ? and ?";
		ResultSet rs = null;
		int startNum = (itemCurPage - 1) * Ito.getPerPage() + 1;
		int endNum = itemCurPage * Ito.getPerPage();

		try {
			conn = dataFactory.getConnection();
			int itemAmount = getItemAmount(conn);
			Ito.setItemAmount(itemAmount);
			endNum = endNum > itemAmount ? itemAmount : endNum;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int gnum = rs.getInt("gnum");
				String gtitle = rs.getString("gtitle");
				String gcontent = rs.getString("gcontent");
				String gwriteday = rs.getString("gwriteday");
				int greadcnt = rs.getInt("greadcnt");

				int qnaNum = rs.getInt("qnaNum");
				System.out.println(gnum + "��° �� ���Ǳ� �� >> " + qnaNum);
				itemList.add(new itemDTO(gnum, gtitle, gcontent, gwriteday, greadcnt, qnaNum));
			}

			Ito.setItemList(itemList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return Ito;
	}

	private int getItemAmount(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select count(gnum) from item";
		ResultSet rs = null;
		int itemAmount = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				itemAmount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return itemAmount;
	}

	// ��������������̵� �������˻�������������
	public boolean read(String id, int gnum) {
		System.out.println(id + " �� ���� " + gnum + "��°���� �������� �ִ�?");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from readid where id = ? and gnum=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, gnum);
			rs = pstmt.executeQuery();
			boolean itOk = rs.next();
			System.out.println(" itOk > " + itOk);
			if (itOk) {
				System.out.println(">>>" + id + " �� �̱��� �������� �ִ�");
				return false;
			} else {
				insertReadId(id, gnum, conn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return true;
	}

	// ������������������¥ ������̵���� ������������
	// �������������Ѱ��� �Ϸ��ѹ� ��ȸ�� �ø��Ⱑ�ɡ�����������
	private void datereset(Connection conn) {
		System.out.println(">>������ ������ ������̵� ����");
		PreparedStatement pstmt = null;
		String sql = "delete from readid where day not like ?";
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yy/MM/dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);
		String today = "%" + mTime + "%";
		System.out.println(" [ ���� ��¥�� " + mTime + "�Դϴ�.]");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today);
			pstmt.executeUpdate();
			System.out.println("     >>������");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
	}

	// ������������������������ ������̵𸮽�Ʈ�����������������
	public void insertReadId(String id, int gnum, Connection conn) {
		System.out.println(">>>" + id + " �� ��ǰ��  " + gnum + "��° ���� �������� ����! >>��������");
		PreparedStatement pstmt = null;
		String sql2 = "insert into readid(id,gnum) values(?,?) ";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setInt(2, gnum);
			pstmt.executeUpdate();
			System.out.println("     >>���峡");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
	}

	// ��������������ȸ���������������������
	private void readcntincrease(int gnum, Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "update item set greadcnt=greadcnt+1 where gnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
	}

	// �������������ǰ����ȸ������������
	public HashMap<String, Object> itemRead(int gnum, String id) {
		System.out.println("-------------------------");
		System.out.println("��ǰ��ȸ����");
		HashMap<String, Object> map = new HashMap<String, Object>();
		itemDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select gnum, gtitle, gcontent, to_char(gwriteday, 'yyyy-mm-dd')gwriteday, greadcnt from item where gnum = ?";

		ResultSet rs = null;
		String fileName = "";
		try {
			conn = dataFactory.getConnection();
			datereset(conn);
			boolean readok = read(id, gnum);
			System.out.println("read(id) = " + readok);
			if (readok) {
				System.out.println("�������� ������ ��ȸ���÷��ٰ�^^ (��Ӥ���)");
				readcntincrease(gnum, conn);
			} else {
				System.out.println("������ �����ϱ� ��ȸ���� �ȴø���^^");
			}
			fileName = imgRead(conn, gnum);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String gtitle = rs.getString("gtitle");
				String gcontent = rs.getString("gcontent");
				String gwriteday = rs.getString("gwriteday");
				int greadcnt = rs.getInt("greadcnt");

				dto = new itemDTO(gnum, gtitle, gcontent, gwriteday, greadcnt);
			}

			map.put("dto", dto);
			map.put("fileName", fileName);

			System.out.println("-------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return map;
	}

	// �������������̹��� �������������������
	private String imgRead(Connection conn, int gnum) {

		String fileName = "";
		PreparedStatement pstmt = null;
		String sql = "select fileName1 from image_file where gnum = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fileName = rs.getString("fileName1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return fileName;
	}

	// ��ǰ ����

	public HashMap<String, Object> itemModifyui(int gnum, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		itemDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from item where gnum = ?";
		ResultSet rs = null;
		String fileName = "";

		try {
			conn = dataFactory.getConnection();
			datereset(conn);
			boolean readok = read(id, gnum);
			System.out.println("read(id) = " + readok);
			if (readok)
				readcntincrease(gnum, conn);
			fileName = imgRead(conn, gnum);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String gtitle = rs.getString("gtitle");
				String gcontent = rs.getString("gcontent");
				int greadcnt = rs.getInt("greadcnt");

				dto = new itemDTO(gnum, gtitle, gcontent, null, greadcnt);
			}
			map.put("dto", dto);
			map.put("fileName", fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return map;
	}

	public void modify(itemDTO ito, String fileName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update item set gtitle = ?, gcontent = ?, gwriteday = sysdate where gnum = ?";
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			int gnum = ito.getGnum();
			if (fileName != null) {
				updateImg(conn, gnum, fileName);
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ito.getGtitle());
			pstmt.setString(2, ito.getGcontent());
			pstmt.setInt(3, gnum);

			pstmt.executeUpdate();
			isOk = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}

	}

	private void updateImg(Connection conn, int gnum, String fileName) {
		itemDTO ito = new itemDTO();
		PreparedStatement pstmt = null;
		String sql = "update image_file set filename1 = ? where gnum = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setInt(2, gnum);
			pstmt.executeUpdate();
			System.out.println(gnum);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	// ��ǰ�˻�

	public ArrayList<itemDTO> itemSearch(String searchName, String searchValue) {
		ArrayList<itemDTO> searchList = new ArrayList<itemDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select gnum, gtitle, gcontent, to_char(gwriteday, 'yyyy/mm/dd')gwriteday, greadcnt from item where ";
		String sql1 = "lower(gtitle) like lower(?)";
		String sql2 = "upper(gcontent) like upper(?)";
		if (searchName.equals("gtitle")) {
			sql = sql + sql1;
		} else if (searchName.equals("gcontent")) {
			sql = sql + sql2;
		}
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchValue + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int gnum = rs.getInt("gnum");
				String gtitle = rs.getString("gtitle");
				String gcontent = rs.getString("gcontent");
				String gwriteday = rs.getString("gwriteday");
				int greadcnt = rs.getInt("greadcnt");

				searchList.add(new itemDTO(gnum, gtitle, gcontent, gwriteday, greadcnt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return searchList;
	}

	// ��ǰ ����
	public void itemDelete(int gnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from item where gnum = ?";
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			deleteImg(conn, gnum);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			pstmt.executeUpdate();
			isOk = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk)
					conn.commit();
				else
					conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}

	private void deleteImg(Connection conn, int gnum) {
		itemDTO ito = new itemDTO();
		PreparedStatement pstmt = null;
		String sql = "delete from image_file where gnum = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			pstmt.executeUpdate();
			System.out.println(gnum);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}
	//////// QnA============================================================
	// ������������ ���� �Է�/ ����Ʈ/ ����/ �˻�/ ���� ������������

	public void insert1(thmemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into thmember(id, pw, name, address, sex, birthday, who) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getSex());
			pstmt.setString(6, dto.getBirthday());
			pstmt.setString(7, dto.getWho());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ ���� ���� ������������
	public void qnadelete(int qnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from qna where qnum = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ ���� ���� ������������
	public void qnamodify(qnaDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update qna set qtitle = ?, qcontent = ?, qwriteday=sysdate where qnum = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getQtitle());
			pstmt.setString(2, dto.getQcontent());
			pstmt.setInt(3, dto.getQnum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ ���� ������������������
	public qnaDTO qnamodifyui(int qnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna where qnum = ?";
		qnaDTO dto = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qwriteday = rs.getString("qwriteday");
				String qid = rs.getString("qid");

				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

				int qgnum = rs.getInt("qgnum");
				dto = new qnaDTO(qnum, qtitle, qcontent, qwriteday, qid, readcnt, repRoot, repStep, repIndent, qgnum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	// ������������ �����б� ������������
	public qnaDTO qnaread(int qnum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna where qnum=?";
		qnaDTO dto = null;

		try {
			conn = dataFactory.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qwriteday = rs.getString("qwriteday");
				String qid = rs.getString("qid");
				int qgnum = rs.getInt("qgnum");
				dto = new qnaDTO(qnum, qtitle, qcontent, qwriteday, qid, readcnt, repRoot, repStep, repIndent, qgnum);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	// �������������ǰ��ȣ ���ǹ�ȣ������������
	public int getgnum(int qnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select qgnum from qna where qnum=?";
		int gnum = 0;

		try {
			conn = dataFactory.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				gnum = rs.getInt("qgnum");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return gnum;
	}

	// ������������ ���� �亯 ������������
	public int qnareply(qnaDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into qna " + "(qnum, qtitle, qcontent, qid, readcnt, repRoot, repStep, repIndent, qgnum) "
				+ "values " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		int qnum = -1;
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);

			qnum = qnacreateNum(conn);
			qnaincreaseRepStep(dto, conn);

			System.out.println(dto.getRepStep());
			System.out.println(dto.getRepIndent());

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnum);
			System.out.println("dao���� ť�� >" + qnum);
			pstmt.setString(2, dto.getQtitle());
			System.out.println("dao���� Ÿ��Ʋ >" + dto.getQtitle());
			pstmt.setString(3, dto.getQcontent());
			System.out.println("dao���� ���� >" + dto.getQcontent());
			pstmt.setString(4, dto.getQid());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, dto.getRepRoot());
			pstmt.setInt(7, dto.getRepStep() + 1);
			pstmt.setInt(8, dto.getRepIndent() + 1);
			pstmt.setInt(9, dto.getQgnum());

			pstmt.executeUpdate();

			isOk = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (isOk)
					conn.commit();
				else
					conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			closeAll(null, pstmt, conn);
		}

		return qnum;
	}

	// ������������ ���� ���ĸ޼ҵ� ������������
	private void qnaincreaseRepStep(qnaDTO dto, Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "update qna set repStep = repStep + 1 where repRoot = ? and repStep > ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getRepRoot());
			pstmt.setInt(2, dto.getRepStep());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeAll(null, pstmt, null);
		}

	}

	// ������������ ���� ��ȣ�����?������������
	private int qnacreateNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(qnum) from qna";
		ResultSet rs = null;
		int num = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return num + 1;

	}

	// �����������幮�� �亯 ������ ������������
	public qnaDTO qnareplyui(int qnum) {

		return qnamodifyui(qnum);
	}

	// ������������ ���� �˻�����Ʈ������������
	public ArrayList<qnaDTO> qnasearch(String searchName, String searchValue, int gnum) {
		ArrayList<qnaDTO> qnasearchlist = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna where qgnum = ? and ";
		String sql1 = "qid like ?";
		String sql2 = "qtitle like ?";

		if (searchName.equals("qid")) {
			sql = sql + sql1;
		} else {
			sql = sql + sql2;
		}

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);
			pstmt.setString(2, "%" + searchValue + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				int qnum = rs.getInt("qnum");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qwriteday = rs.getString("qwriteday");
				String qid = rs.getString("qid");
				int qgnum = rs.getInt("qgnum");
				qnasearchlist.add(new qnaDTO(qnum, qtitle, qcontent, qwriteday, qid, readcnt, repRoot, repStep,
						repIndent, qgnum));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return qnasearchlist;
	}

	// ������������ ���� �Է¡�����������
	public void qnainsert(qnaDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into qna" + "(qnum, qtitle, qcontent, qid, readcnt, repRoot, repStep, repIndent, qgnum) "
				+ "values " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean isOk = false;

		try {

			conn = dataFactory.getConnection();

			conn.setAutoCommit(false);
			int qnum = qnacreateNum(conn);
			increaseqnaNum(conn, dto.getQgnum());

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			pstmt.setString(2, dto.getQtitle());
			pstmt.setString(3, dto.getQcontent());
			pstmt.setString(4, dto.getQid());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, qnum);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, dto.getQgnum());

			System.out.println("���ǹ�ȣ = " + qnum);
			System.out.println();

			pstmt.executeUpdate();
			isOk = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (isOk)
					conn.commit();
				else
					conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			closeAll(null, pstmt, conn);
		}

	}

	private void increaseqnaNum(Connection conn, int qgnum) {
		PreparedStatement pstmt = null;
		String sql = "update item set qnaNum = qnaNum + 1 where gnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qgnum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	// ������������ ���� ����Ʈ ������������
	public qnaPageTO qnapage(int curPage, int gnum) {
		ArrayList<qnaDTO> list = new ArrayList<>();
		qnaPageTO to = new qnaPageTO();
		to.setCurPage(curPage);

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from (select rownum rnum, qnum, qtitle, qcontent, to_char(qwriteday, 'yyyy/mm/dd') qwriteday, qid, readcnt, reproot, repstep, repindent, qgnum from (select * from qna order by reproot desc, repstep asc)) where rnum between ? and ?";
		ResultSet rs = null;
		int startNum = (curPage - 1) * to.getPerPage() + 1;
		int endNum = curPage * to.getPerPage();

		try {
			conn = dataFactory.getConnection();

			int amount = qnagetAmount(conn, gnum);// ���Խñ� ���� �����ϴ� �Լ�
			to.setAmount(amount);

			/*
			 * if(endNum > amount) { // if�� ��� endNum = amount; }
			 */

			endNum = endNum > amount ? amount : endNum; // 3�� ������ ���

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int qnum = rs.getInt("qnum");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qwriteday = rs.getString("qwriteday");
				String qid = rs.getString("qid");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				int qgnum = rs.getInt("qgnum");
				list.add(new qnaDTO(qnum, qtitle, qcontent, qwriteday, qid, readcnt, repRoot, repStep, repIndent,
						qgnum));
			}

			to.setList(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return to;
	}

	// ������������ �� ���ڼ����ΰ� ������������
	private int qnagetAmount(Connection conn, int gnum) {
		PreparedStatement pstmt = null;
		String sql = "select count(qnum) from qna where qgnum = ?";
		ResultSet rs = null;
		int amount = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gnum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				amount = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return amount;
	}

	// ������������ ���� �����ΰ�? ������������
	public boolean qnaisroot(int qnum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select qnum, repRoot from qna where qnum = ?";
		ResultSet rs = null;

		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);

			rs = pstmt.executeQuery();

			if (rs.next() && (rs.getInt("qnum") == rs.getInt("repRoot"))) {
				isOk = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return isOk;
	}

	// ������������ ���� ���� ������������
	public void qnadeleteroot(int qnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from qna where repRoot = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ �湮���� id�� ���� �湮 �������� guest�� insert ������������
	public void visit(thmemberDTO login) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into guest(guestNum ,gid) values (?, ?)";

		int guestNum = 0;
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (!visitedToday(login.getId(), conn)) {
				guestNum = guestcreateNum(conn);
				pstmt.setInt(1, guestNum);
				pstmt.setString(2, login.getId());
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ id�� ���� �湮������ true �ƴ� false ������������
	private boolean visitedToday(String id, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from guest where gid = ? and to_char(day, 'yyyy/mm/dd')=to_char(sysdate, 'yyyy/mm/dd')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return false;
	}

	// ������������ guest���̺��� primarykey ���� ������������
	private int guestcreateNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(guestNum) from guest";
		ResultSet rs = null;
		int num = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return num + 1;

	}

	// ������������ ����ڷ���� ���� dto ���� ������������
	public statisiticDTO getStat() {
		Connection conn = null;
		statisiticDTO dto = new statisiticDTO();

		int men = 0;
		int women = 0;
		int sum = 0;
		ArrayList<VPDDTO> visitorPerDaylist = new ArrayList<>();

		try {
			conn = dataFactory.getConnection();
			men = getMen(conn);
			women = getWomen(conn);
			sum = men + women;
			visitorPerDaylist = getVPDlist(conn);

			dto = new statisiticDTO(men, women, sum, visitorPerDaylist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, null, conn);
		}

		return dto;
	}

	// ������������ �������� �湮�ڼ��� ����Ʈ�� �����ȡ�����������
	private ArrayList<VPDDTO> getVPDlist(Connection conn) {
		ArrayList<VPDDTO> VPDlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(perday) cnt, perday from (select to_char(day, 'yyyy/mm/dd') perday from guest) group by perday order by perday asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cnt = rs.getInt("cnt");
				String day = rs.getString("perday");
				VPDlist.add(new VPDDTO(cnt, day));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return VPDlist;
	}

	// ������������ ȸ���� ������ ���� ���� ������������
	private int getWomen(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(id) from thmember where sex='F' and who = 'U'";
		int women = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				women = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return women;
	}

	// ������������ ȸ���� ������ �� ���� ������������
	private int getMen(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(id) from thmember where sex='M' and who = 'U'";
		int men = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				men = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return men;

	}

	// ������������ �α��� id�� ���Ǳ۰� �׿����� �亯�� ���� ������������
	public ArrayList<qnaDTO> getuserSelectList(String id) {

		ArrayList<qnaDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select b.qnum qnum, qtitle, qcontent, to_char(qwriteday, 'yyyy/mm/dd') qwriteday, qid, readcnt, repRoot, repStep, repIndent, qgnum from (select qnum from qna where qid = ?) a, qna b where a.qnum = b.reproot order by reproot desc, repstep asc";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int qnum = rs.getInt("qnum");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qwriteday = rs.getString("qwriteday");
				String qid = rs.getString("qid");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				int qgnum = rs.getInt("qgnum");
				list.add(new qnaDTO(qnum, qtitle, qcontent, qwriteday, qid, readcnt, repRoot, repStep, repIndent,
						qgnum));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	// ������������ ���Ǳ� ��ȸ��������������
	public boolean qnareadToday(String id, int qnum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from readid where id = ? and qnum = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, qnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return false;
	}

	// ������������ ���Ǳ� ��ȸ��������������
	public void qnareadcntincrease(int qnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update qna set readcnt = readcnt + 1 where qnum = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// ������������ ���Ǳ� ��ȸ���� ���̵����������������
	public void qnainsertread(String id, int qnum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql2 = "insert into readid(id,qnum) values(?,?) ";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setInt(2, qnum);
			pstmt.executeUpdate();
			System.out.println("     >>���峡");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}
}
