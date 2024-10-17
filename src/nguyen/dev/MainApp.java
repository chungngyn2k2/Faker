package nguyen.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.javafaker.Faker;

import nguyen.dev.data.dao.CategoryDao;
import nguyen.dev.data.dao.DatabaseDao;
import nguyen.dev.data.dao.OrderDao;
import nguyen.dev.data.dao.OrderItemDao;
import nguyen.dev.data.dao.ProductDao;
import nguyen.dev.data.dao.UserDao;
import nguyen.dev.data.impl.CategoryImpl;
import nguyen.dev.data.impl.Database;
import nguyen.dev.data.model.Category;
import nguyen.dev.data.model.User;

public class MainApp {

	public static void main(String[] args) {
		DatabaseDao.init(new Database());
		Faker faker = new Faker();
		
		UserDao userDao = DatabaseDao.getInstance().getUserDao();
		
		//Chen nguoi dung
		for (int i=0;i<10;i++) {
			String email = faker.internet().emailAddress();
			String password = faker.internet().password();
			String role = faker.job().position();
			
			User user = new User(email, password, role);
			userDao.insert(user);
			
			System.out.println("Insert User: "+ email + "|" + password + "|" + role);
		}
		
		
	}
}
