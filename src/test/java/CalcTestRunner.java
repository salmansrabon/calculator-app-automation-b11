import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CalcTestRunner extends Setup {
    @Test(priority = 1, dataProvider = "TestData", dataProviderClass = TestDataset.class, description = "Sum of 2 numbers")
    public void doSum(int num1, int num2, int expectedRes){
        CalcScreen calcScreen=new CalcScreen(driver);
        int resActual= Integer.parseInt(calcScreen.doSum(num1,num2));
        Assert.assertEquals(resActual,expectedRes);
    }
    @Test(priority = 2, description = "Subtraction of 2 numbers")
    public void doSub(){
        CalcScreen calcScreen=new CalcScreen(driver);
        int resActual= Integer.parseInt(calcScreen.doSub(9,4));
        int expectedRes=5;
        Assert.assertEquals(resActual,expectedRes);
    }
    @Test(priority = 3, description = "Solve a linear equation")
    public void doEquation(){
        CalcScreen calcScreen=new CalcScreen(driver);
        calcScreen.doEquation("5+7*2/2");
    }

    @AfterMethod
    public void clear(){
        CalcScreen calcScreen=new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
