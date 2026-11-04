package dataProvider;

import org.testng.annotations.DataProvider;

public class myDataProvider {
    @DataProvider(name="LoginData")
    public Object[][]getData(){
        return new Object[][]{
                {"FAILED USER1","F123",false},
                {"FAILED USER2","F456",false},
                {"Admin","admin123",true}
        };
    }
}
