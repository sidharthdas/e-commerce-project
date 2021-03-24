package com.ecommerce.service;

import java.util.concurrent.Future;

public interface EmailService {
	
	
	Boolean send(String s);
	void sendAsync(String s);
	Future<Boolean> sendAsyncWithResult(String s);

}
