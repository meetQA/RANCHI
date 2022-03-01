package Admin_R;

public class LayerManagement_repository {
	
	public static final String btn_Login="//a[@class='btn btn-primary']";
	public static final String txtbox_Username="//input[@id='LoginInput_UserNameOrEmailAddress']";
	public 	static final String txtbox_Password="//input[@id='LoginInput_Password']";
	public static final String btn_Login1="//button[text()='Login']";
	public static final String profile_admin="//a[@id='dropdownMenuUser']";
	public	static final String lnk_logout="//a[@id='MenuItem_Account.Logout']";
	
	
	
	
	public static final String  ddm_Layer_Management  = "//*[contains(text(),'Layer Management')]";
	public static final String  lnk_Layers  = "//*[contains(text(),'Layers')]";
	public static final String  btn_Add_OGC_Services  = "//button[@id=\"NewOgcService\"]";
	public static final String  btn_Scan_Layers  = "//button[text()=\"Scan Layer\"]";
	public static final String  btn_Edit_OGC_services  = "//button[@id=\"EditOgcService\"]";
	public static final String  btn_Delete_OGC_services  = "//button[@id=\"DeleteOgcService\"]";
	public static final String  ddm_OGC_services  = "//select[@id=\"sl_OgcService\"]";
	public static final String  btn_Action  = "//button[text()=\"Actions\"]";
	public static final String  ddm_Show_Entries = "//select[@name=\"LayerTable_length\"]";
	public static final String  txt_OgcServices_Name= "//input[@name=\"OgcService.Name\"]";
	public static final String  txt_OgcServices_DbName= "//input[@name=\"OgcService.DbName\"]";
	public static final String  txt_OgcServices_URl= "//input[@name=\"OgcService.Url\"]";
	public static final String  txt_OgcServices_DbConnectionString= "//input[@name=\"OgcService.DbConnectionString\"]";
	public static final String  btn_Save = "//span[text()=\"Save\"]";
	public static final String  chk_Active = "//input[@name=\"OgcService.IsActive\"]";
	public static final String  btn_Ok = "//button[text()=\"OK\"]";
	public static final String  btn_Yes = "//button[text()=\"Yes\"]";
	public static final String  btn_Back = "//span[text()=\"Back\"]";
	public static final String  btn_Rescan = "//span[text()=\"Rescan\"]";
	public static final String  lnk_Layer_Error  = "//*[contains(text(),'Layer Error Count')]";
	public static final String  lnk_Layer_Publish  = "//*[contains(text(),'Layer Publish Pending')]";
	public static final String  lnk_Layer_Columns_Issue  = "//*[contains(text(),'Layer With Columns Issue')]";
	public static final String  lnk_Layer_Record_Pending  = "//*[contains(text(),'Layer Recorded Pending')]";
	public static final String  lnk_Layer_Table_NotFound  = "//*[contains(text(),'Layer Table Not Found')]";
	public static final String  lnk_Layer_Sync_Pending  = "//*[contains(text(),'Layer Sync Pending')]";
	public static final String  lnk_Clear  = "//*[contains(text(),'Clear')]";
	public static final String  btn_Add_Layer_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Add Layer\"]";
	public static final String  btn_Activate_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Activate\"]";
	public static final String  btn_Discard_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Discard\"]";
	public static final String  btn_Deactivate_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Deactivate\"]";
	public static final String  btn_Add_Mask_Layer_boundary_ward  = "//div[@id=\"_boundary_ward\"]//a[text()=\"Add Mask-Layer\"]";
	public static final String  btn_Add_Mask_Layer_bank  = "//div[@id=\"_bank\"]//a[text()=\"Add Mask-Layer\"]";
	public static final String  txt_Title_Name= "//input[@id=\"AddLayerScanResultViewModel_Title\"]";
	public static final String  chk_Is_Mask= "//input[@id=\"AddLayerScanResultViewModel_IsMask\"]";
	

	public static final String searchbox="//input[@class='form-control page-search-filter-text']";
	public	static final String title_header="//li[@class='breadcrumb-item active']";
	public	static final String btn_next="(//a[text()='Next'])[1]";
	public	static final String btn_previous="(//a[text()='Previous'])[1]";
	public	static final String title_window="//h5[@class='modal-title']";
	public	static final String btn_close="//button[@class='close']";
	public	static final String btn_cancel="//button[text()='Cancel']";
	public	static final String btn_save="//button/span[text()='Save']";
	public	static final String validation_1stline="//div[@class='swal-modal']/div[2]";
	public	static final String validation_2ndline="//div[@class='swal-modal']/div[3]";
	public	static final String validation_btn_cancel="//button[@class='swal-button swal-button--cancel']";
	public	static final String validation_btn_yes="//button[@class='swal-button swal-button--confirm']";
	public	static final String text_showing_entries="//div[contains(text(),'Showing')]";
	public	static final String lnk_pageno_2="//a[text()='2']";
	public	static final String lnk_pageno_1="//a[text()='1']";
	public	static final String lnk_pageno_3="//a[text()='3']";
	public	static final String entries_25="//option[text()='25']";
	public	static final String entries_10="//option[text()='10']";
    public	static final String entries_100="//option[text()='100']";
    public	static final String lnk_Home="//a/i[@class='fa fa-home']";
    public	static final String dd_entries="(//div[@class='dataTables_length']/label/select)[1]";

}
