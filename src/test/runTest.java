package CucumberReport; 

import org.junit.runner.RunWith; 
import cucumber.api.junit.Cucumber; 
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions( 
   format = {"pretty", "html:target/Destination"} ) 
	
//Specifying pretty as a format option ensure that HTML report will be generated. 
//When we specify html:target/Destination - It will generate the HTML report 

//inside the Destination folder, in the target folder of the maven project. 

public class runTest { }
