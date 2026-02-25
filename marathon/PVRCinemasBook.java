package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVRCinemasBook {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.pvrcinemas.com/");

		driver.findElement(
				By.xpath("//input[@class='p-inputtext p-component p-autocomplete-input p-autocomplete-input']"))
				.sendKeys("Chennai");
		driver.findElement(By.xpath("//span[@class='sc-lgpSej kdusLc pointer']")).click();
		driver.findElement(By.xpath("//div[@class='date-show']/span[2]")).click();

		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='INOX National,Virugambakkam Chennai']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		
		
		//Selecting the date using ExecuteScript
		
		WebElement cine = driver.findElement(By.xpath("//ul[@class='p-dropdown-items']//li[2]"));
		driver.executeScript("arguments[0].click();", cine);
		
		//Selecting movie
		//driver.findElement(By.xpath("//span[text()='Select Movie']")).click();
		driver.findElement(By.xpath("//ul[@class='p-dropdown-items']//li[4]")).click();
		
		//Select movie timing
		driver.findElement(By.xpath("//span[text()='06:30 PM']")).click();
		
		//Clicking Book button to book the ticket
		driver.findElement(By.xpath("//button[@class='p-button p-component sc-hjsuWn kDwaXw bgColor filter-btn']//span")).click();
		
		//Accepting the term & conditions
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='sc-kCuUfV iBvycX reject-terms']")).click();
		
		//Selecting the seat
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@id='SL.SILVER|L:2']")).click();
		
		//proceed button
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='sc-bbbBoY kbsOBB btn-proceeded']")).click();
		
		Thread.sleep(4000);
		//printing seat info	
		String seatInfoType = driver.findElement(By.xpath("//div[@class='ticket-value']")).getText();
		String seatInfoNumb = driver.findElement(By.xpath("//div[@class='seat-number']/p")).getText();
		System.out.println("Seat Info: " +seatInfoType +" "+seatInfoNumb);
		
		//Clicking continue after proceed button
		Thread.sleep(4000);
		WebElement cont = driver.findElement(By.xpath("//button[text()='Continue']"));
		driver.executeScript("arguments[0].click();", cont);
		
		Thread.sleep(3000);
		String tit = driver.getTitle();
		System.out.println(tit);
		
		//closing
		
		driver.close();
		
		
		
		
		
	}

}
