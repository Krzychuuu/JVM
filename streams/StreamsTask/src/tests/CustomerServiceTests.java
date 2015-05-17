package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import services.CustomerService;
import services.CustomerServiceInterface;
import entities.Customer;
import entities.Product;

public class CustomerServiceTests {
	
	Product product1 = new Product(9, "Product: 9", 0.9);
	Product product2 = new Product(8, "Product: 8", 0.8);

	@Test
	public void testFindByName() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));		
		List<Customer> res = cs.findByName("Customer: 1");		
		assertNotNull("Result can't be null", res);
		assertEquals(1, res.size());		
	}
	
	@Test
	public void testFindByField() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		List<Customer> res = cs.findByField("name", "Customer: 1");
		assertNotNull("Result can't be null", res);
		assertEquals(1, res.size());		
	}
	
	@Test
	public void testCustomersWhoBoughtMoreThan() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));		
		List<Customer> res = cs.customersWhoBoughtMoreThan(2);		
		assertNotNull("Result can't be null", res);
		assertEquals(5, res.size());		
	}
	
	@Test
	public void testAvgOrders() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		assertEquals(1.33, cs.avgOrders(true), 0.1);
		assertEquals(3.6, cs.avgOrders(false), 0.1);		
	}
	
	@Test
	public void testCountBuys() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));	
		assertEquals(1, cs.countBuys(product1));
		assertEquals(1, cs.countBuys(product2));
	}
	
	@Test
	public void testAddProductToAllCustomers() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		Product product33 = new Product(33, "testujemy", 1.1);
		cs.addProductToAllCustomers(product33);		
		List<Customer> res = cs.findByField("Product", "33, Product: 33, 1.1");
		assertNotNull("Result can't be null", res);
		assertEquals(1, res.size());			
	}
			
}