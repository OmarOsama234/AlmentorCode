import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SavedCoursesLocators {
    ChromeDriver driver;
    WebDriverWait wait;

    private By loginButton = By.className("login");
    private By emailField = By.name("email");
    private By continueButton = By.className("btn-danger");
    private By passwordField = By.name("password");
    private By savecourseHomeButton = By.className("course-card_add-to-wishlist-btn");
    private By savecourseButton = By.className("icon-wishlist");
    private By removeSavecourseButton = By.className("wishlist-icon");
    private By savedcoursesPage = By.className("saved-list-page");
    private By userProfileIcon = By.className("user-menu__profile-image");
    private By savedCoursesLink = By.cssSelector("a.user-profile-card__user-option-item[href='/saved-list']");
    private By logoutButton = By.className("user-profile-card__btn-logout");
    private By firstCourse = By.xpath("//*[@id=\"courses-carousel-authorized-home-marketing-list-1122\"]/div/div/div[1]/alm-root-course-card-new/a/img");
    private By secondCourse = By.xpath("//*[@id=\"courses-carousel-authorized-home-marketing-list-1122\"]/div/div/div[2]/alm-root-course-card-new/a/img");
    private By secondCourseImage = By.className("horizontal-course-card-new__img-container");
    private By secondCourseTitle = By.className("horizontal-course-card-new_body__header-title");
    private By secondCourseInstructorname = By.className("horizontal-course-card-new_body__mentors");
    private By thirdCourse = By.xpath("//*[@id=\"courses-carousel-authorized-home-marketing-list-1122\"]/div/div/div[3]/alm-root-course-card-new/a/img");
    private By thirdCourseTitle = By.xpath("/html/body/alm-authorized-root/alm-root-app-container/div/div[2]/mat-drawer-container/mat-drawer-content/div/div[1]/alm-root-saved-list-page/div/div/alm-root-numeric-paginated-section-wrapper/div/div[4]/div[1]/alm-root-horizontal-course-card/a/div[2]/div[1]/div[1]/p");


    public SavedCoursesLocators(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driver.findElement(continueButton).click();
    }

    public void openFirstCourseByXPath() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstCourse)).click();
    }

    public void openSecondCourseByXPath() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondCourse)).click();
    }

    public void openThirdCourseByXPath() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdCourse)).click();
    }

    public void goToSavedCourses() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileIcon)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(savedCoursesLink)).click();
    }

    public void logout() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileIcon)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickSavecourseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(savecourseButton)).click();
    }

    public boolean userProfileIconVisable() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileIcon)).click();
        return false;
    }


    public void RemoveSavecourse() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(removeSavecourseButton)).click();
    }

    public boolean isSavecourseIconHomeVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(savecourseHomeButton)).isDisplayed();
    }

    public boolean isSaveCourseIconVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(savecourseButton)).isDisplayed();
    }

    public boolean SavedCoursesPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(savedcoursesPage)).isDisplayed();
    }

    public boolean isSavedCoursesDisplayedInList() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(thirdCourseTitle)).isDisplayed();
    }

    public boolean isCourseDetailsDisplayed() {
        boolean imageVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(secondCourseImage)).isDisplayed();
        boolean titleVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(secondCourseTitle)).isDisplayed();
        boolean instructorNameVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(secondCourseInstructorname)).isDisplayed();
        return imageVisible && titleVisible && instructorNameVisible;
    }
}
