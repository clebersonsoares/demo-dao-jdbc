package application;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("========== Test Find By ID ==========");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("========== Test 2 Find By Department ==========");
		Department dep = new Department(2,null);
		List<Seller>list = sellerDao.findByDepartment(dep);

		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("========== Test 3 Find ALL =============");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("============Test  4 Insert Seller ==============");
		Seller newSeller = new Seller(null,"Lucelia","lucelia@gmail.com",new Date(),5000.00,dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());

	}

}
