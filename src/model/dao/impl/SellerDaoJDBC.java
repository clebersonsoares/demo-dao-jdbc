package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		try {
			PreparedStatement sql = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName\r\n" 
					+ "FROM seller INNER JOIN department\r\n"
					+ "ON seller.DepartmentId = department.Id\r\n" 
					+ "WHERE seller.Id = ?");
			sql.setInt(1, id);
			ResultSet rs = sql.executeQuery();
			if(rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("DepartmentId"));
				department.setName(rs.getString("DepName"));
				
				Seller seller = new Seller();
				seller.setId(rs.getInt("Id"));
				seller.setName(rs.getString("Name"));
				seller.setEmail(rs.getString("Email"));
				seller.setBirthdate(rs.getDate("BirthDate"));
				seller.setSalary(rs.getDouble("BaseSalary"));
				seller.setDepartment(department);
				
				return seller;
			}else {
				return null;
			}

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
