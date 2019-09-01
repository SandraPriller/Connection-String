package connection.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sandra Priller
 *
 */

public class ConnectionStringSplitting {
	private String password;
	private String persistSecurityInfo;
	private String userId;
	private String initialCatalog;
	private String dataSource;
	
	
	public void splitConnectionString(String connectionString) {
		System.out.println("Ihr Connection String lautet: " + connectionString);
		String regex = "Persist";
		String persist = null, pw = null;
		int ind = 0;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(connectionString);
		
		while(matcher.find()) {
			persist = connectionString.substring(matcher.start(), connectionString.length());
			pw = connectionString.substring(0, matcher.start());
			ind = pw.lastIndexOf(';');
			pw = pw.substring(0, ind);
		}
				
		List<String> semicolon = new ArrayList<String>(Arrays.asList(persist.split(";"))); 
		semicolon.add(0, pw);
		
	    for(String a : semicolon) {
	    	String[] temp = null;
	    	int index = a.lastIndexOf('=');
	    	int length = a.length();
	    	
	    	if(a.contains("Password=") || a.contains("Password =")) {
	    		password = a.substring(index + 1, length);
	    		
	    		if(password.contains(" ")) {
	    			temp = password.trim().split("\\s+");
	    			password = convertArrayToStringMethod(temp);
	    		}	    		
	    		setPassword(password);
	    		System.out.println(getPassword());
	    		
	    	} else if(a.contains("Persist Security Info=") || a.contains("Persist Security Info =")) {
	    		persistSecurityInfo = a.substring(index + 1, length);
	    		
	    		if(persistSecurityInfo.contains(" ")) {
	    			temp = persistSecurityInfo.trim().split("\\s+");
	    			persistSecurityInfo = convertArrayToStringMethod(temp);
	    		}
	    		setPersistSecurityInfo(persistSecurityInfo);
	    		System.out.println(getPersistSecurityInfo());
	    		
	    	} else if(a.contains("User ID=") || a.contains("User ID =")) {
	    		userId = a.substring(index + 1, length);
	    		
	    		if(userId.contains(" ")) {
	    			temp = userId.trim().split("\\s+");
	    			userId = convertArrayToStringMethod(temp);
	    		}
	    		setPersistSecurityInfo(userId);
	    		System.out.println(getUserId());
	    		
	    	} else if(a.contains("Initial Catalog=") || a.contains("Initial Catalog =")) {
	    		initialCatalog = a.substring(index + 1, length);
	    		
	    		if(initialCatalog.contains(" ")) {
	    			temp = initialCatalog.trim().split("\\s+");
	    			initialCatalog = convertArrayToStringMethod(temp);
	    		}
	    		setPersistSecurityInfo(initialCatalog);
	    		System.out.println(getInitialCatalog());
	    		
	    	} else if(a.contains("Data Source=") || a.contains("Data Source =")) {
	    		dataSource = a.substring(index + 1, length);
	    		
	    		if(dataSource.contains(" ")) {
	    			temp = dataSource.trim().split("\\s+");
	    			dataSource = convertArrayToStringMethod(temp);
	    		}
	    		setPersistSecurityInfo(dataSource);
	    		System.out.println(getDataSource());
	    	}
	    	
	    	else {
	    		System.out.println("Failure...Connection String in wrong format!");
	    	}	    	
	    } 
	}
	
	private String convertArrayToStringMethod(String[] strArray) {
		StringBuilder stringBuilder = new StringBuilder();
	        for (int i = 0; i < strArray.length; i++) {
	            stringBuilder.append(strArray[i]);
	        }

	    return stringBuilder.toString();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPersistSecurityInfo() {
		return persistSecurityInfo;
	}
	
	public void setPersistSecurityInfo(String persistSecurityInfo) {
		this.persistSecurityInfo = persistSecurityInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInitialCatalog() {
		return initialCatalog;
	}

	public void setInitialCatalog(String initialCatalog) {
		this.initialCatalog = initialCatalog;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
