package helperFunctions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Helper {
	/*
	 * This function generates a random username by combining a random adjective and noun
	 * from predefined lists and appending a random number between 0 and 100.
	 */
	@Keyword
	def String generateRandomUsername() {
		def adjectives = [
			'android',
			'ios',
			'device',
			'mac',
			'window',
			'ipad',
			'iphone',
			'tab',
			'phone'
		]
		def nouns = [
			'test',
			'web',
			'mobile',
			'mweb',
			'testweb',
			'testmobile',
			'automation',
			'functional',
			'test1'
		]

		def random = new Random()
		def adjective = adjectives[random.nextInt(adjectives.size())]
		def noun = nouns[random.nextInt(nouns.size())]
		def number = random.nextInt(100)

		return "${adjective}${noun}${number}"
	}
	/*
	 * This function will generate password for user by default the length of password is set to 12
	 */
	@Keyword
	def String generatePassword(int length = 12) {
		def characters = ('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()').toCharArray()
		def password = new StringBuilder()

		for (int i = 0; i < length; i++) {
			def randomIndex = new Random().nextInt(characters.length)
			password.append(characters[randomIndex])
		}

		return password.toString()
	}
}
