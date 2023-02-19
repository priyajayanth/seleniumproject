package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void WindowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageurl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void passTest(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowser() {
		driver.quit();
	}

	public static void Clickbutton(WebElement ele) {
		ele.click();
	}

	public static void ScreenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgNmae.png");
		FileUtils.copyFile(image, f);
	}

	public static Actions a;

	public static void movethecursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}

	public static void dragDrop(WebElement dragWebElemnt, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElemnt, dropElement).perform();
	}

	public static JavascriptExecutor js;

	public static void scrollThepage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);
	}

	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(flase)", element);
	}

	public static void excelRead(String SheetNmae, int rowNum, int CellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("datas");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(CellNum);
		int cellType = c.getCellType();
		String value = " ";
		if (cellType == 1) {
			String value2 = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueof = String.valueOf(l);
		}
	}

	public static void creatNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("Excel location.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newsheet = w.createSheet("Datas");
		Row newRow = newsheet.createRow(rowNum);
		Cell newcell = newRow.createCell(cellNum);
		newcell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public static void creatcell(int getrow, int crecell, String newdata) throws IOException {
		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("datas");
		Row r = s.getRow(getrow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newdata);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void creatRow(int creRow, int crecell, String newData) throws IOException {
		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updatetoparticularcell(int gettherow, int getthecell, String existingdata, String writenewdata)
			throws IOException {
		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(gettherow);
		Cell c = r.getCell(getthecell);
		String str = c.getStringCellValue();
		if (str.equals(existingdata)) {
			c.setCellValue(writenewdata);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

}
