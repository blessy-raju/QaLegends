package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	static Faker faker;
	public static String getPrefix() {
		faker = new Faker();
		String prefix = faker.name().prefix();
		return prefix;
	}
	public static String getFirstName() {
		faker = new Faker();
		String firstName = faker.name().firstName();
		return firstName;
	}
	
	public static String getLastname() {
		faker = new Faker();
		String lastName = faker.name().lastName();
		return lastName;
	}	
}
