# SEMTER.jar Instructions for Use

Used to fix old version test cases that fail on new version applications

## Requirement

-  Java 8, Python 3 as well as necessary packages are installed. 

-  Install [Jep](https://github.com/ninia/jep/).

##  Usage steps

### Args:

- **Mode**: Run mode, must be either "trace" or "repair"

- **TestcasePath**: Path of test cases to be repaired Test cases need to specify the type and path of the driver, and remove excess **package**

   e.g:` package testcase.phpfusion.oldversion;  ` should be removed

- **NewURL**: the URL of the updated version of the application

### Run trace

Run in SEMTER.jar and all related dependency save directories:
` java -javaagent:aspectjweaver-1.9.7.jar -Dmode=trace -DtestcasePath=path-to-your-testcase.java  -jar SEMTER.jar`
e. g: `java -javaagent:aspectjweaver-1.9.7.jar -Dmode=trace -DtestcasePath="PHPFusion_SearchUser.java" -jar SEMTER.jar`

### Run repair

Run in SEMTER.jar and all related dependency save directories:
` java -javaagent:aspectjweaver-1.9.7.jar -Dmode=repair -DtestcasePath=path-to-your-testcase.java -DnewURL=the-URL-of-the-updated version -jar SEMTER.jar`
e.g: ` java -javaagent:aspectjweaver-1.9.7.jar -Dmode=repair -DtestcasePath="PHPFusion_SearchUser.java" -DnewURL="http://localhost/phpFusion/phpFusion-9.03.10/home.php" -jar SEMTER.jar`

## Result:

Trace and repair results can be obtained in the terminal and corresponding ./repairedStatements/testcaseName.txt

An example of repair on "PHPFusion_SearchUser.java" is included