package com.capital.one.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capital.one.datamodelbeans.Award;
import com.capital.one.datamodelbeans.Credit;
import com.capital.one.datamodelbeans.Redemption;


public class RedemptionDaoImpl implements RedemptionDao {

	private JdbcTemplate jdbcTemplate;
	
	private Logger log = Logger.getLogger("RedemptionDaoImpl");
	
	

//	public RedemptionDaoImpl() {
//		super();
//		// Default Constructor
//	}

	public RedemptionDaoImpl(DataSource datasource) {
		System.out.println("Test");
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void insertRedemptionRequest(int redeemerId, int teamRedemptionId, int creditsUsed, int creditTypeId,
			int awardId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Redemption> getRedemptionHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credit> getCreditType() {
		String sql = "SELECT * FROM credit";
		System.out.println("in DAO implementation");
		List<Credit> listCredit = jdbcTemplate.query(sql, new RowMapper<Credit>() {
			public Credit mapRow(ResultSet rs, int nRows) throws SQLException {
				Credit creditType = new Credit();
				creditType.setCreditId(rs.getInt("credit_id"));
				creditType.setCreditName(rs.getString("credit_name"));
				return creditType;
			}
		});

		return listCredit;
	}

	@Override
	public List<Award> getAwardsList() {
		String sql = "SELECT * FROM award";
		System.out.println("in DAO implementation");
		List<Award> awardsList = jdbcTemplate.query(sql, new RowMapper<Award>() {
			@Override
			public Award mapRow(ResultSet rs, int nRows) throws SQLException {
				Award awards = new Award();
				awards.setAwardId(rs.getInt("award_id"));
				awards.setAwardType(rs.getString("award_type"));
				awards.setAwardName(rs.getString("award_Name"));
				awards.setCreditCost(rs.getInt("credit_cost"));
				awards.setCreditId(rs.getInt("credit_id"));
				return awards;
			}
		});

		return awardsList;
	}

//	@Override
//	public List<Credit> getCreditType() {
//
//		System.out.println("in DAO implementation");
//		Statement stmt = null;
//		Connection conn = null;
//		ResultSet rs;
//		List<Credit> creditList = new ArrayList<Credit>();
//		try {
//			
//			conn = DAOUtilities.getConnection();
//			stmt = conn.createStatement();
//			
//			String sql = "SELECT * FROM credit";
//			
//			rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//	
//					Credit creditType = new Credit();
//					creditType.setCreditId(rs.getInt("credit_id"));
//					creditType.setCreditName(rs.getString("credit_name"));
//					creditList.add(creditType);
//			}
//			
//			return creditList;
//		
//		}
//		catch (SQLException sqle) {
//			log.error("SQL Exception thrown");
//			sqle.printStackTrace();
//			return null;
//		}
//
//	}

}
