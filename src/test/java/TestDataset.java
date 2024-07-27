import org.testng.annotations.DataProvider;

public class TestDataset {
    @DataProvider(name = "TestData")
    public Object[][] getData(){
        return new Object[][]{
                {5,4,9},
                {9,6,15},
                {8,5,13}
        };
    }

}
