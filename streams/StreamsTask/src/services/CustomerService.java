package services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import entities.Customer;
import entities.Product;

public class CustomerService implements CustomerServiceInterface {

	private List<Customer> customers;

	public CustomerService(List<Customer> customers) {
		this.customers = customers;
	}
	
	@Override
	public List<Customer> findByName(String name) {
		return customers.stream().filter(n->n.getName().equals(name)).collect(Collectors.toList());
	}

	@Override
	public List<Customer> findByField(String fieldName, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return null;
	}

	@Override
	public List<Customer> customersWhoBoughtMoreThan(int number) {
		return customers.stream().filter(n->n.getBoughtProducts().size()>number).collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWhoSpentMoreThan(double price) {
		return customers.stream().filter(n->n.getBoughtProducts().stream().count()>price).collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWithNoOrders() {
		return customers.stream().filter(n->n.getBoughtProducts().size()==0).collect(Collectors.toList());
	}

	@Override
	public void addProductToAllCustomers(Product p) {
		customers.stream().forEach(c->c.addProduct(p));
	}

	@Override
	public double avgOrders(boolean includeEmpty) {
		double sumOrders = customers.stream().mapToDouble(c->c.getBoughtProducts().stream().collect(Collectors.summingDouble(Product::getPrice))).sum();
		int Counter = 0;
		if(!includeEmpty) {
			Counter = customers.stream().filter(c->c.getBoughtProducts().size()>0).collect(Collectors.toList()).size();
		}
		return sumOrders/Counter;
	}

	@Override
	public boolean wasProductBought(Product p) {
		return customers.stream().anyMatch(c->c.getBoughtProducts().contains(p));
	}

	@Override
	public List<Product> mostPopularProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBuys(Product p) {
		List<Product> products = new ArrayList<Product>();
		for (Customer customer : customers) {
			products.addAll(customer.getBoughtProducts().stream().filter(pr->pr.getId()==p.getId()).collect(Collectors.toList()));
		}
		return products.size();
	}

	@Override
	public int countCustomersWhoBought(Product p) {
		return customers.stream().filter(c->c.getBoughtProducts().contains(p)).toArray().length;
	}
}
