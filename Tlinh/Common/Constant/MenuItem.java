package Constant;

import Railway.HomePage;

public enum MenuItem {
	
	 	HOME("Home"),
	    FAQ("Faq"),
	    REGISTER("Register"),
	    LOGIN("Login"),
	    LOGOUT("Logout");
	
	private String itemName;
	
	 MenuItem(String menuName) {
	        this.itemName = menuName;
	    }
	
}
