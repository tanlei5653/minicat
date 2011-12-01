package com.fanfou.app.http;

/**
 * @author mcxiaoke
 * @version 1.0 2011.12.01
 * 
 *
 */
public class BasicNetClient extends NetManger {
	private String username;
	private String password;
	private String authorization;

	private BasicNetClient(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		createBasicAuthHeader();
	}

	public static final BasicNetClient newInstance(String username,
			String password) {
		return new BasicNetClient(username, password);
	}

	public void setUsernameAndPassword(String username, String password) {
		this.username = username;
		this.password = password;
		createBasicAuthHeader();
	}

	@Override
	protected void signRequest(final NetRequest cr) {
		super.signRequest(cr);
		cr.request.addHeader("Authorization", authorization);
		
	}
	
	private void createBasicAuthHeader(){
		authorization = "Basic "+ com.fanfou.app.util.Base64.encodeBytes((username + ":" + password).getBytes());
	}
}
