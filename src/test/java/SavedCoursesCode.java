import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SavedCoursesCode {
    ChromeDriver driver;
    SavedCoursesLocators sp;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.almentor.net/en/");
        sp = new SavedCoursesLocators(driver);
        sp.login("603olive6512@e-record.com", "1234567890");
    }

    @Test (priority = 1)
    public void TC_1_saveCourseIconVisibleOnHomePage() {
        Assert.assertTrue(sp.isSavecourseIconHomeVisible());
    }

    @Test (priority = 2)
    public void TC_2_addToSavedCourses() {
        sp.openFirstCourseByXPath();
        Assert.assertTrue(sp.isSaveCourseIconVisible());
        sp.clickSavecourseButton();
    }

    @Test (priority = 3)
    public void TC_3_navigateToSavedCourses() throws InterruptedException {
        sp.goToSavedCourses();
        Assert.assertTrue(sp.SavedCoursesPageDisplayed());
    }

    @Test (priority = 4)
    public void TC_6_openSavedCourseswhileloggedout() throws InterruptedException {
        sp.logout();
        Assert.assertFalse(sp.userProfileIconVisable());
    }

    @Test (priority = 5)
    public void TC_7_addAndVerifySavedCourseDetails() throws InterruptedException {
        sp.openSecondCourseByXPath();
        sp.clickSavecourseButton();
        sp.goToSavedCourses();
        Assert.assertTrue(sp.isCourseDetailsDisplayed());
    }

    @Test (priority = 6)
    public void TC_8_saveListPersistsAfterLogout() throws InterruptedException {
        sp.openThirdCourseByXPath();
        sp.clickSavecourseButton();
        sp.logout();
        sp.login("603olive6512@e-record.com", "1234567890");
        sp.goToSavedCourses();
        Assert.assertTrue(sp.isSavedCoursesDisplayedInList());
    }

    @Test (priority = 7)
    public void TC_4_removeCoursesFromSavedList() throws InterruptedException {
        sp.goToSavedCourses();
        sp.RemoveSavecourse();
        sp.RemoveSavecourse();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
