package connection.string;

import java.util.Scanner;

/**
 * @author Sandra Priller
 *
 */

public class ConnectionStringTest {
	
	public static void main(String[] args) {
		ConnectionStringSplitting csp = new ConnectionStringSplitting();
		System.out.println("Bitte geben Sie Ihren Connection String ein:");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String connectionString = sc.nextLine();
		csp.splitConnectionString(connectionString);

	}

}
