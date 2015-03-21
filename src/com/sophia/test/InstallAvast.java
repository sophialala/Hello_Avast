package com.sophia.test;
import android.util.Log;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class InstallAvast extends UiAutomatorTestCase {
	public void test() throws UiObjectNotFoundException {
		FindGooglePlayToOpen();
		SearchAndInsatllAvast();
	}
	
	private void FindGooglePlayToOpen() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		//go to apps page
		UiObject Applications = new UiObject(new UiSelector().description("Apps"));
		Applications.clickAndWaitForNewWindow();
		//click apps tab
		UiObject appstab = new UiObject(new UiSelector().text("Apps"));
		appstab.click();
		//Scroll to find the app
		UiScrollable Listapp = new UiScrollable(new UiSelector().scrollable(true));
		//My emulator is HorizonList
		Listapp.setAsHorizontalList();
		UiObject GooglePlayAPP = Listapp.getChildByText(new UiSelector().className("android.widget.TextView"), "Play Store");
		GooglePlayAPP.clickAndWaitForNewWindow();
	}
	
	private void SearchAndInsatllAvast() throws UiObjectNotFoundException{
		//Search by Name
		UiObject SearchBox = new UiObject(new UiSelector().className("android.widget.ImageView").description("Search"));
		SearchBox.setText("Mobile Security & Antivirus");
		//Click Enter
		getUiDevice().pressEnter();
		//Found the app and click
		UiObject appclick = new UiObject(new UiSelector().className("android.widget.TextView").text("Mobile Security & Antivirus"));
		appclick.clickAndWaitForNewWindow();
		//Install
		UiObject InstallButton = new UiObject(new UiSelector().className("android.widget.Button").text("INSTALL"));
		InstallButton.clickAndWaitForNewWindow();
		//Accept
		UiObject AcceptButton = new UiObject(new UiSelector().className("android.widget.TextView").text("ACCEPT"));
		AcceptButton.clickAndWaitForNewWindow();
		//Wait for installation and Open it
		UiObject OpenButton =new UiObject(new UiSelector().className("android.widget.Button").text("OPEN"));
		if (OpenButton.waitForExists(20000))
		{
			OpenButton.clickAndWaitForNewWindow();
			UiObject button =new UiObject(new UiSelector().className("android.widget.Button").text("Continue"));
			if(button.waitForExists(15000))
			{
				button.clickAndWaitForNewWindow();
				Log.v("success", "Good job");
				UiObject settingsValidation = new UiObject(new UiSelector().className("android.widget.Button").text("Continue"));
			    assertTrue("The test is failure.",settingsValidation.waitForExists(1000));
			}
		
		}
	
	}
	
}
