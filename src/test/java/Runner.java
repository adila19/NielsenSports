import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber",
                "json:target/cucumber.json"},
        features="src\\test\\resources\\features",
        glue="Steps.java",
        tags="@HomePage",
        dryRun = true,
        strict=true,
        monochrome =true
)

public class Runner {

}
