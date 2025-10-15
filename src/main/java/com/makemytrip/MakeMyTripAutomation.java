package com.makemytrip;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeMyTripAutomation {

	public static void main(String[] args) {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeoptions);
		wd.get("https://www.makemytrip.com/");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));

		By closeModalLocator = By.xpath("//span[@class='commonModal__close']");
		WebElement closeModal = wait.until(ExpectedConditions.visibilityOfElementLocated(closeModalLocator));
		closeModal.click();

		By fromCityLocator = By.xpath("//label[@for='fromCity']");
		WebElement fromCityLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(fromCityLocator));
		fromCityLabel.click();

		By fromCityTextLocator = By.xpath("//input[@placeholder='From']");
		WebElement fromCityText = wait.until(ExpectedConditions.elementToBeClickable(fromCityTextLocator));
		fromCityText.sendKeys("Pune");

		// Wait for suggestion list and select first item
		By fromSuggestionListLocator = By.xpath(
				"//p[contains(text(),\"SUGGESTIONS\")]/ancestor::div[contains(@class,\"react-autosuggest\")]/ul/li");

		boolean state = wait.until(
				ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromSuggestionListLocator),
						ExpectedConditions.numberOfElementsToBeMoreThan(fromSuggestionListLocator, 10)));

		List<WebElement> forCitySuggestionList = null;

		if (state) {
			forCitySuggestionList = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromSuggestionListLocator));
			forCitySuggestionList.get(0).click();
		}

		By toCityLocator = By.xpath("//label[@for='toCity']");
		WebElement toCityLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(toCityLocator));
		toCityLabel.click();

		By toCityTextLocator = By.xpath("//input[@placeholder='To']");
		WebElement toCityText = wait.until(ExpectedConditions.elementToBeClickable(toCityTextLocator));
		toCityText.sendKeys("Mumbai");

		// Wait for suggestion list and select first item
		By toSuggestionListLocator = By.xpath(
				"//p[contains(text(),\"SUGGESTIONS\")]/ancestor::div[contains(@class,\"react-autosuggest\")]/ul/li");

		state = wait.until(
				ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(toSuggestionListLocator),
						ExpectedConditions.numberOfElementsToBeMoreThan(toSuggestionListLocator, 10)));

		List<WebElement> toCitySuggestionList = null;

		if (state) {
			toCitySuggestionList = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromSuggestionListLocator));
			toCitySuggestionList.get(0).click();
		}

		// Calendar Date Selection

		LocalDate targetdate = LocalDate.now();
		targetdate = targetdate.plusDays(5);
		String targetMonth = targetdate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int targetYear = targetdate.getYear();
		int targetDay = targetdate.getDayOfMonth();

		By CalendarMonthLocator = By.xpath("//div[contains(text(),'" + targetMonth + " " + targetYear
				+ "')]/ancestor::div[@class= \"DayPicker-Month\"]");
		WebElement calendarMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarMonthLocator));

		By dateLocator = By.xpath("//p[text()='" + targetDay + "']/ancestor::div[contains(@class, \"DayPicker-Day\")]");
		WebElement date = calendarMonth.findElement(dateLocator);
		date.click();
	}

}
