package config;
 
public class Constants {
 
 //List of System Variables
 public static final String URL = "http://rently.rentlyblack.com/";
 public static final String Path_TestData = "/home/mohan/gitFramework/RentlyTestAutomation/src/main/resources/testData/DataEngine.xlsx";
 public static final String Path_OR = "home/mohan/eclipse-workspace/RentlyAutomation/src/main/resources/testData/OR.txt";
 public static final String File_TestData = "DataEngine.xlsx";
 
 public static final String KEYWORD_FAIL = "FAIL";
 public static final String KEYWORD_PASS = "PASS";
 
 //Data Sheet Column Numbers
 public static final int Col_TestCaseID = 0; 
 public static final int Col_Summary = 1;
 public static final int Col_Precondition =2;
 public static final int col_Postcondition = 3;
 public static final int Col_TeststepDescription =2;
 public static final int Col_TestScenarioID =1 ;
 public static final int Col_ActionKeyword =3 ;
 public static final int Col_RunMode =4 ;
// public static final int Browser =3 ;
 public static final int Col_Result =5 ;
 public static final int Col_TestStepResult =4 ;
 
 // Data Engine Excel sheets
 public static final String Sheet_TestSteps = "Test Steps";
 public static final String Sheet_TestCases = "Test Cases";
 
}