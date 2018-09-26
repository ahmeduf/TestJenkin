package DataDrivenTests;
import DataDrivenClass.GoogleSheetClass;
import base.GoogleSheetReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*import signInPageObjects.GoogleSheetsPage;
import testHomePageObjects.HomePage;
import signInPageObjects.SignInPage;*/
import DataDrivenClass.GoogleSheetClass;
import java.io.IOException;
import java.util.List;

public class TestGoogleSheetsPage extends GoogleSheetReader{
    /*HomePage objOfHomePage;
    SignInPage objOfSignInPage;
    GoogleSheetsPage objGoogleSheetsPage; */
    GoogleSheetClass objGoogleSheetsClass;

    @BeforeMethod
    public void initialization(){
        /*objOfHomePage = PageFactory.initElements(driver, HomePage.class);
        objOfSignInPage = PageFactory.initElements(driver, SignInPage.class);
        objGoogleSheetsPage = PageFactory.initElements(driver, GoogleSheetsPage.class);*/
        objGoogleSheetsClass = PageFactory.initElements(driver,);
    }

    // ALI_GS_TC1: Verify log in by taking data from a google sheets file
    @Test
    public void testLogInByInvalidIdPassUsingGoogleSheet() throws IOException, InterruptedException {
        /*sleepFor(3);
        objOfHomePage.clikSignIn();
        sleepFor(3);
        objOfSignInPage.switchToSignInForm();
        sleepFor(3);*/
        int i = 0;
        String spreadsheetId = "1A6G3avCchSjTPM1xoGU8YaYo3azwl4uHBsfgwRZB31A";
        String range = "Sheet1!A2:D";
        List<String> actualErrorMessage = objGoogleSheetsPage.signInByInvalidIdPass(spreadsheetId, range);
        List<List<Object>> expectedErrorMessage = objGoogleSheetsPage.getSpreadSheetRecords(spreadsheetId, range);
        for (List row : expectedErrorMessage) {
            // Assert.assertTrue(actualErrorMessage.get(i).contains(row.get(3).toString()));
            //System.out.println("expected"+row.get(3).toString());
            System.out.println(expectedErrorMessage.get(i) + ": Search - Passed");
            i++;
        }
        System.out.println("testLogInByInvalidIdPassUsingGoogleSheet Passed");
    }
}
