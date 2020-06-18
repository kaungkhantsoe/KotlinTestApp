package com.yammobots.holidaytestapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SharePreferenceHelper {

	private SharedPreferences sharedPreference;

	private static String SHARE_PREFRENCE = "showtimePref";

	private static String MEMBER_ID_KEY = "member_id";
	private static String MEMBER_FIREBASE_TOKEN_KEY = "member_firebase_token";
	private static String MEMBER_ACCOUNT_KIT_APP_ID_KEY = "member_account_kit_app_id";
	private static String MEMBER_PHONE_KEY = "member_phone";
	private static String MEMBER_BIRTHDAY = "member_birthday";
	private static String MEMBER_GENDER = "member_gender";
	private static String MEMBER_NAME = "member_name";
	private static String MEMBER_EMAIL = "member_email";
	private static String MEMBER_ADDRESS = "member_address";
	private static String MEMBER_PHOTO = "member_photo";

	private static String MEMBER_FB_ID = "fbid";
	private static String MEMBER_GMAIL_ID = "gmailid";

	@Inject
	public SharePreferenceHelper(Context context)
	{
		sharedPreference = context.getSharedPreferences(SHARE_PREFRENCE, Context.MODE_PRIVATE);
	}

	//***** Member Login *****//
	public void setLogin(int memberId, String firebaseToken, String userAppId, String fbId, String gmailId)
	{
		SharedPreferences.Editor editor = sharedPreference.edit();
		editor.putInt(MEMBER_ID_KEY, memberId);
		editor.putString(MEMBER_FIREBASE_TOKEN_KEY, firebaseToken);
		editor.putString(MEMBER_ACCOUNT_KIT_APP_ID_KEY, userAppId);
		editor.putString(MEMBER_FB_ID, fbId);
		editor.putString(MEMBER_GMAIL_ID, gmailId);
		editor.commit();
	}

	public void setExtraData(String name, String address, String gender, String email, String date, String photo){
		SharedPreferences.Editor editor = sharedPreference.edit();
		editor.putString(MEMBER_NAME,name);
		editor.putString(MEMBER_EMAIL,email);
		editor.putString(MEMBER_GENDER,gender);
		editor.putString(MEMBER_ADDRESS,address);
		editor.putString(MEMBER_BIRTHDAY,date);
		editor.putString(MEMBER_PHOTO,photo);
		editor.commit();
	}

	public void logoutSharePreference()
	{
		SharedPreferences.Editor editor = sharedPreference.edit();
		editor.clear();
		editor.commit();
	}

	public String getFacebookID() {
		return sharedPreference.getString(MEMBER_FB_ID,"");
	}

	public String getGmailID() {
		return sharedPreference.getString(MEMBER_GMAIL_ID,"");
	}

	public String getMemberPhoto() {
		return sharedPreference.getString(MEMBER_PHOTO,"");
	}

	public String getLoginMemberPhone()
	{
		return sharedPreference.getString(MEMBER_PHONE_KEY, "");
	}

	public int getLoginMemberId()
	{
		return sharedPreference.getInt(MEMBER_ID_KEY, 0);
	}

	public String getMemberAccountKitTokenKey()
	{
		return sharedPreference.getString(MEMBER_FIREBASE_TOKEN_KEY, "");
	}

	public String getMemberAccountKitAppIdKey()
	{
		return sharedPreference.getString(MEMBER_ACCOUNT_KIT_APP_ID_KEY, "");
	}

	public String getMemberAddress() {
		return sharedPreference.getString(MEMBER_ADDRESS,"");
	}

	public String getMemberBirthday() {
		return sharedPreference.getString(MEMBER_BIRTHDAY,"");
	}

	public String getMemberEmail() {
		return sharedPreference.getString(MEMBER_EMAIL,"");
	}

	public String getMemberGender() {
		return sharedPreference.getString(MEMBER_GENDER,"");
	}

	public String getMemberName() {
		return sharedPreference.getString(MEMBER_NAME,"");
	}


	public boolean isLogin()
	{
		return sharedPreference.contains(MEMBER_ID_KEY) && (sharedPreference.contains(MEMBER_FB_ID) || sharedPreference.contains(MEMBER_GMAIL_ID));
	}
	//***** Member Login *****//


}
