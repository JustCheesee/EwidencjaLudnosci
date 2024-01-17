package suits;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import tests.CitizenViewTest;
import tests.LoginTest;

@Suite
@SelectClasses({LoginTest.class, CitizenViewTest.class})
@IncludeTags("Login")
@ExcludeTags("Dane")
public class LoginTestSuite {}
