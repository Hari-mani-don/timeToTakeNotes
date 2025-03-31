package com.checking.demo.check;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.Profile;
import com.zerodhatech.models.User;

public class KitConnect {
	 public static void main(String[] args) {
		//https://kite.trade/connect/login?api_key=your_api_key	
	        try {
	            // Initialize KiteConnect with API Key
	            KiteConnect kiteSdk = new KiteConnect("gvuv9viv1fu0oosq");

	            kiteSdk.setUserId("BJL778");
	            String url = kiteSdk.getLoginURL();
	            System.out.println("url\t"+url);//https://kite.trade/connect/login?api_key=gvuv9viv1fu0oosq&v=3
	            try {
					User user =  kiteSdk.generateSession("M2BNpus8ZW9en5LeOEHDKIlcvyKDkYGJ", "3s2t5q6i6i8bhllno7qwdoqybn438nme");
					 kiteSdk.setAccessToken(user.accessToken);
					 kiteSdk.setPublicToken(user.publicToken);
				} catch (KiteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//http://localhost:8080/?action=login&type=login&status=success&request_token=M2BNpus8ZW9en5LeOEHDKIlcvyKDkYGJ
	            // Set access token (Ensure you get this via login flow)//BJL778
	           //3s2t5q6i6i8bhllno7qwdoqybn438nme secret

	            // Fetch user profile
	            Profile userProfile=new Profile();
				try {
					userProfile = kiteSdk.getProfile();
				} catch (KiteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	            // Print profile details
	            System.out.println("User ID: " + kiteSdk.getUserId());
	            System.out.println("User Name: " + userProfile.userName);
	            System.out.println("Email: " + userProfile.email);
	            System.out.println("Broker: " + userProfile.broker);
	            System.out.println("Products: " + userProfile.products);
	            System.out.println("Order Types: " + userProfile.orderTypes);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
