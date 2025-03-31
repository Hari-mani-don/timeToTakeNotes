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
		            	kiteSdk.setAccessToken("fXuQ7E5Wf0fjyNjDgW9dFh4FdyCwE2MT");
//						User user =  kiteSdk.generateSession("NynNLE4j5LI7tAGATRPCd55yTKqJ1HsO", "3s2t5q6i6i8bhllno7qwdoqybn438nme");
//						System.out.println("user.accessToken\t"+user.accessToken); //fXuQ7E5Wf0fjyNjDgW9dFh4FdyCwE2MT
//						Profile profile = kiteSdk.getProfile();
//						 kiteSdk.setPublicToken(user.publicToken);
						 
						 
					} catch (Exception e) {
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
						e.printStackTrace();
					}
					
		            // Print profile details
		            System.out.println("User ID: " + kiteSdk.getUserId());
		            System.out.println("User Name: " + userProfile.userName);
		            System.out.println("Email: " + userProfile.email);
		            System.out.println("Broker: " + userProfile.broker);
		            
		            for (String string : userProfile.exchanges) {
		            	System.out.println("Products: " + string);
					}
		            for (String string : userProfile.orderTypes) {
		            	System.out.println("orderTypes: " + string);
					}
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
}
