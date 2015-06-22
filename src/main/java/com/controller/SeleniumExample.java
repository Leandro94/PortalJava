package com.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumExample
{
	public static void main(String... args)
	{
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://portaljava.herokuapp.com/");
		
		WebElement  elementNome = driver.findElement(By.name("nome"));
		WebElement  elementNota = driver.findElement(By.name("nota"));
		WebElement  elementFalta = driver.findElement(By.name("falta"));
		WebElement  elementPeriodo = driver.findElement(By.name("periodo"));
		WebElement  elementMatricula = driver.findElement(By.name("matricula"));
		
		elementNome.sendKeys("Leandro Reis");
		elementNota.sendKeys("70");
		elementFalta.sendKeys("17");
		elementPeriodo.sendKeys("2015");
		elementMatricula.sendKeys("120");
		
		elementNome.submit();
		driver.quit();
	}
}