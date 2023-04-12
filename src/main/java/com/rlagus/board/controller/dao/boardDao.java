package com.rlagus.board.controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rlagus.board.controller.dto.boardDto;

public class boardDao {
	
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jspdb";
	private String username = "root";
	private String password = "1234";
	
	public void write(String writer, String sunject, String content) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO board(writer, sunject, content) VALUES(?,?,?)";
		
		try {
			Class.forName(driverName);			
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, writer);
			pstmt.setString(2, sunject);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) { 
				e.printStackTrace();
			}			
		}
	}
	
	public ArrayList<boardDto> list() {
		
		ArrayList<boardDto> dtos = new ArrayList<boardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM board ORDER BY bnum DESC";
		
		try {
			Class.forName(driverName);			
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bnum = rs.getInt("bnum");
				String writer = rs.getString("writer");
				String sunject = rs.getString("sunject");
				String content = rs.getString("content");
				String wdate = rs.getString("wdate");
				
				boardDto dto = new boardDto(bnum, writer, sunject, content, wdate);
				
				dtos.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) { 
				e.printStackTrace();
			}			
		}
		return dtos;
	}
	
	public boardDto content_view(String bnum) {
		
		boardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM board WHERE bnum=?";
		
		try {
			Class.forName(driverName);			
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cnum = rs.getInt("bnum");
				String writer = rs.getString("writer");
				String sunject = rs.getString("sunject");
				String content = rs.getString("content");
				String wdate = rs.getString("wdate");
				
				dto = new boardDto(cnum, writer, sunject, content, wdate);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) { 
				e.printStackTrace();
			}			
		}
		return dto;
	}
	
	public int deletelist(String bnum) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM board WHERE bnum=?";
		
		int dbFlag = 0;
		
		try {
			Class.forName(driverName);			
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			
			dbFlag = pstmt.executeUpdate();			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) { 
				e.printStackTrace();
			}			
		}
		return dbFlag;
	}
}