package Application_Pages_R;

public class Sign_In_Page_R {
	public static String txt_Login_Name = "//input[@data-val-required=\"Please Enter Username\"]";
	public static String txt_Password = "//input[@data-val-required=\"Please Enter Password\"]";
	public static String btn_Sign_In = "//button[text()=\"Login\"]";
	public static String btn_Hide_View_Password = "//span[@class=\"input-group-text password input-group-icon input-group-addon-inverse\"]/i";
	public static String txt_loginUserName_error = "//span[text()=\"Please Enter Username\"]";
	public static String txt_password_error = "//span[text()=\"Please Enter Password\"]";
	public static String txt_error = "//span1[text()=\"Invalid Username or Password.\"]";
	public static String txt_error_1= "//span1[text()=\"You are left with 4 attempts after which you will be blocked for 1 Hours\"]";
	public static String txt_error_2= "//span1[text()=\"You are left with 3 attempts after which you will be blocked for 1 Hours\"]";
	public static String btn_Close = "//button[@class=\"close\"]";
	public static String link_Forgot_Username = "//a[@data-target=\"#forgot-password\"]";
	public static String btn_Register = "//button[text()=\" Create an Account\"]";
}
