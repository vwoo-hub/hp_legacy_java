package utils;

import java.util.Random;
import java.util.UUID;

public class EmailGenerator {
	public static String generateEmail() {
		Random random = new Random();
		
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, 9) + uuid.substring(uuid.length() - 8);
		
		String[] domains = {"example.com", "testmail.com", "mailservice.com"};
		String domain = domains[random.nextInt(domains.length)];
			
		return uuid + "@" + domain;	
	}
}
