package testData;


import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "data")
    public Object[][] ProvideData(){
        return new Object[][]{
            {1,"incorrectUsername","SuperSecretPassword!","Your username is invalid!"},
            {2,"incorrectUsername2","SuperSecretPassword2!","Your username is invalid!"},
            {3,"tomsmith", "SuperSecretPassword!",""}
        };
    }
}
