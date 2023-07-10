import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.internal.PathUtil

import internal.GlobalVariable
import helperFunctions.Helper

Helper h =new Helper()

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())
Mobile.startApplication(appPath, false)

TestObject signIn = findTestObject('signInPage/signInBtn')
TestObject username = findTestObject('signInPage/usernameField')
TestObject nextBtn = findTestObject('signInPage/usernameNextBtn')
TestObject forgotPassword = findTestObject('forgotPasswordPage/forgotPasswordLink')
TestObject emailCodeText = findTestObject('forgotPasswordPage/emailCode')
TestObject recoveryEmail = findTestObject('forgotPasswordPage/recoveryEmailField')
TestObject sendBtn = findTestObject('forgotPasswordPage/sendBtn')
TestObject verifyBtn = findTestObject('forgotPasswordPage/verifyBtn')
TestObject newPasswordField = findTestObject('forgotPasswordPage/newPasswordField')
TestObject continueBtn = findTestObject('forgotPasswordPage/continueBtn')
TestObject looksGood = findTestObject('forgotPasswordPage/looksGoodBtn')
TestObject inboxImg = findTestObject('signInPage/inbox')
TestObject nextButton = findTestObject('signInPage/customizeNext')
TestObject skip = findTestObject('signInPage/skipLink')

Mobile.tap(signIn, GlobalVariable.G_Timeout)
Mobile.setText(username, GlobalVariable.G_resetAccountUsername, GlobalVariable.G_Timeout)
Mobile.tap(nextBtn, GlobalVariable.G_Timeout)
Mobile.tap(forgotPassword, GlobalVariable.G_Timeout)
Mobile.tap(emailCodeText, GlobalVariable.G_Timeout)
Mobile.setText(recoveryEmail,GlobalVariable.G_recoveryEmailId, GlobalVariable.G_Timeout)
Mobile.hideKeyboard()
Mobile.tap(sendBtn, GlobalVariable.G_Timeout)
//Hard delay to set code
Thread.sleep(40000)
Mobile.tap(verifyBtn, GlobalVariable.G_Timeout)
String newPassword=h.generatePassword(12)
Mobile.setText(newPasswordField,newPassword, GlobalVariable.G_Timeout)
Mobile.tap(continueBtn, GlobalVariable.G_Timeout)
Mobile.tap(looksGood, GlobalVariable.G_Timeout)
Mobile.tap(nextButton, GlobalVariable.G_Timeout)
Mobile.tap(skip, GlobalVariable.G_Timeout)

if(Mobile.verifyElementVisible(inboxImg, GlobalVariable.G_Timeout, FailureHandling.OPTIONAL)) {
	KeywordUtil.markPassed('Successfully user logged in')
} else {
	Mobile.takeScreenshot()
	KeywordUtil.markFailed('Error while logging in')
}
