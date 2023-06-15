package utilities;

import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ApplicationFlow {

    public static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Interruption happened");
        }
    }

    public static void scroll(int y){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,y).perform();
    }

    public static void switchToSecondWindow(){
        String currentID = Driver.getDriver().getWindowHandle();
        Set<String> handles = Driver.getDriver().getWindowHandles();
        for(String id : handles){
            if(!id.equals(currentID)){
                Driver.getDriver().switchTo().window(id);
                break;
            }
        }

    }

    public static void switchToWindowByTitle(String title){
        Set<String> handles = Driver.getDriver().getWindowHandles();
        for(String id : handles){
            Driver.getDriver().switchTo().window(id);
            if(Driver.getDriver().getTitle().equals(title)){
                break;
            }
        }

    }

}
