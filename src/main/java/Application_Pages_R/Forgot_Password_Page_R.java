package Application_Pages_R;

public class Forgot_Password_Page_R {
	public static String Label_Forgot_Password = "//h2[text()=\"Forgot Username / Password\"]";
	public static String txt_Email = "//form[@action=\"/Admin/Account/UserForgetPassword\"]/div/div/input";
	public static String btn_Submit = "//button[text()=\"Submit\"]";
	public static String btn_Close = "//div[@id=\"forgot-password\"]//button[@class=\"close\"]";
	public static String success_message = "//span1[text()=\"if you entered correct email Id then you received mail shortly\"]";
	public static String validation_message = "//span[text()=\"Please Enter Email Address\"]";
	public static String validation_message_1 = "//span[text()=\"Please Enter valid email address\"]";

}
