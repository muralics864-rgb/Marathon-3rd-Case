package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

		driver.manage().window().maximize();

		driver.get("https://www.redbus.in");

		driver.findElement(By.xpath("//input[@id='srcinput']")).sendKeys("Koyambedu");
		driver.findElement(By.xpath("//div[text()='Koyambedu']")).click();
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();

//Selecting the date tab

		driver.findElement(By.xpath("//div[contains(@aria-label,'Select Date')]")).click();

		// Selecting the tomorrow date

		driver.findElement(By.xpath("//div[@data-datetype='AVAILABLE']")).click();

		// Search Buses
		driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();

		// A/C Bus
		WebElement acBuses = driver.findElement(By.xpath("//div[contains(text(), 'AC (')]"));

		driver.executeScript("arguments[0].click();", acBuses);

		// print the total buses before

		String BforeTotalBus = driver.findElement(By.xpath("//div[contains(@class,'busesFoundText')]")).getText();
		System.out.println("Total Buses before " + BforeTotalBus);

// Applying High rated buses
		driver.findElement(By.xpath("//div[contains(text(), 'High Rated Buses ')]")).click();
		// print the total buses later

		// print the total buses after selecting A/C bus

		String AftrTotalBus = driver.findElement(By.xpath("//div[contains(@class,'busesFoundText')]")).getText();
		System.out.println("Total Buses after selecting AC BUS " + AftrTotalBus);

		// Capturing all buses prices into a List

		List<WebElement> busPrices = driver.findElements(By.xpath("//p[@class='finalFare___0b90fc']"));

		//Adding all busprices into List Integer
		List<Integer> bPrices = new ArrayList<>();

		for (WebElement e : busPrices) {
			int buspr = Integer.parseInt(e.getText().replaceAll("[^0-9.]", "")); //replacing NOT a digit 
			bPrices.add(buspr);
		}
		Collections.sort(bPrices); // Sorting the order
		
		System.out.println("Lowest Bus Price is " + bPrices.get(0));
		System.out.println("Title Page is " + driver.getTitle());

	}
}
