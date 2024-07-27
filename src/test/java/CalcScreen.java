import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement txtResult;
    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement btnClear;
    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String doSum(int num1, int num2) {
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + num1)).click();
        btnPlus.click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + num2)).click();
        btnEqual.click();
        return txtResult.getText();
    }

    public String doSub(int num1, int num2) {
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + num1)).click();
        btnMinus.click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + num2)).click();
        btnEqual.click();
        return txtResult.getText();
    }

    public void doEquation(String equation) {
        char[] chars = equation.toCharArray();
        WebElement plusElem = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        WebElement minusElem = driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
        WebElement mulElem = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        WebElement divElem = driver.findElement(By.id("com.google.android.calculator:id/op_div"));

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                plusElem.click();
            } else if (chars[i] == '-') {
                minusElem.click();
            } else if (chars[i] == '*') {
                mulElem.click();
            } else if (chars[i] == '/') {
                divElem.click();
            } else {
                driver.findElement(By.id("com.google.android.calculator:id/digit_" + chars[i])).click();
            }

        }
        btnEqual.click();
    }
}
