import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.internal.PathUtil

import internal.GlobalVariable
import com.kms.katalon.core.appium.driver.AppiumDriverManager
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.mobile.driver.MobileDriverType

'Get full directory\'s path of android application'
//def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())
//Mobile.startApplication(appPath, false)


String browserStackServerURL = "https://tanyamahajan_2rO9iZ:SzbokzKNQVHb4PN52R2U@hub-cloud.browserstack.com/wd/hub";

DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability("device", "Google Pixel 5");

//Set the app_url (returned on uploading app on Browserstack) in the 'app' capability
capabilities.setCapability('app', 'bs://eb9201b9d84e9f661065b49e1e282307dcc804b2');

AppiumDriverManager.createMobileDriver(MobileDriverType.ANDROID_DRIVER, capabilities, new URL(browserStackServerURL));

TestObject signIn = findTestObject('signInPage/signInBtn')
TestObject username = findTestObject('signInPage/usernameField')
TestObject nextBtn = findTestObject('signInPage/usernameNextBtn')
TestObject password = findTestObject('signInPage/passwordField')
TestObject nextBtn1 = findTestObject('signInPage/passwordNextBtn')
TestObject nextButton = findTestObject('signInPage/customizeNext')
TestObject skip = findTestObject('signInPage/skipLink')
TestObject inboxImg = findTestObject('signInPage/inbox')

Mobile.tap(signIn, GlobalVariable.G_Timeout)
Mobile.setText(username, GlobalVariable.G_validUsername, GlobalVariable.G_Timeout)
Mobile.tap(nextBtn, GlobalVariable.G_Timeout)
Mobile.setText(password,GlobalVariable.G_validPassword, GlobalVariable.G_Timeout)
Mobile.tap(nextBtn1, GlobalVariable.G_Timeout)
Mobile.tap(nextButton, GlobalVariable.G_Timeout)
Mobile.tap(skip, GlobalVariable.G_Timeout)
if(Mobile.verifyElementVisible(inboxImg, GlobalVariable.G_Timeout, FailureHandling.OPTIONAL)) {
	Mobile.takeScreenshot()
	KeywordUtil.markPassed('Successfully user logged in')
} else {
	Mobile.takeScreenshot()
	KeywordUtil.markFailed('Error while logging in')
}
Mobile.closeApplication()
