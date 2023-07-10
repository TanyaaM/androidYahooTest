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
TestObject createAccount = findTestObject('createAccountPage/createAccountBtn')
TestObject firstName = findTestObject('createAccountPage/firstNameField')
TestObject lastName = findTestObject('createAccountPage/lastNameField')
TestObject email = findTestObject('createAccountPage/emailId')
TestObject password = findTestObject('createAccountPage/passwordField')
TestObject month = findTestObject('createAccountPage/monthField')
TestObject selectMonth = findTestObject('createAccountPage/selectMonth')
TestObject day = findTestObject('createAccountPage/dayField')
TestObject year = findTestObject('createAccountPage/yearField')
TestObject continueButton = findTestObject('createAccountPage/continueBtn')
TestObject phone = findTestObject('createAccountPage/phoneField')
TestObject sendCodeButton = findTestObject('createAccountPage/sendCodeBtn')

String userEmail =h.generateRandomUsername()
KeywordUtil.logInfo('New userid is '+userEmail)

Mobile.tap(signIn, GlobalVariable.G_Timeout)
Mobile.tap(createAccount, GlobalVariable.G_Timeout)
Mobile.setText(firstName, GlobalVariable.G_firstname, GlobalVariable.G_Timeout)
Mobile.setText(lastName,GlobalVariable.G_lastname, GlobalVariable.G_Timeout)
Mobile.setText(email, userEmail, GlobalVariable.G_Timeout)
Mobile.setText(password,GlobalVariable.G_validPassword, GlobalVariable.G_Timeout)
Mobile.tap(month, GlobalVariable.G_Timeout)
Mobile.tap(selectMonth, GlobalVariable.G_Timeout)
Mobile.setText(day, GlobalVariable.G_day, GlobalVariable.G_Timeout)
Mobile.setText(year,GlobalVariable.G_year, GlobalVariable.G_Timeout)
Mobile.tap(continueButton,GlobalVariable.G_Timeout)
Mobile.setText(phone, GlobalVariable.G_phone , GlobalVariable.G_Timeout)
Mobile.tap(sendCodeButton,GlobalVariable.G_Timeout)


