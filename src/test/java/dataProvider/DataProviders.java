package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="invalidUserData")
	public Object[][] setInvalidUserCrendentials() {
		Object[][] data=new Object[3][2];
		data[0][0]="admin";
		data[0][1]="1234";
		
		data[1][0]="admins";
		data[1][1]="123456";
		
		data[2][0]="admins";
		data[2][1]="123";
		
		return data;
	}

}
