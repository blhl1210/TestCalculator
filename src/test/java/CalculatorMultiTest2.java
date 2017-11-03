import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by linh on 03/11/2017.
 */
@RunWith(value = Parameterized.class)
public class CalculatorMultiTest2 {
  final static String pathExpression = "src/test/resources/fileTest/expression.inp";
  final static String pathExpected = "src/test/resources/fileTest/expected.inp";
  static{
    CalculatorMulti.setUp();
  }

  @Parameterized.Parameter(value = 0)
  public String expression;
  @Parameterized.Parameter(value = 1)
  public String expected;
  @Parameterized.Parameters(name = "{index}: testDisplay({0}) = {1}")
  public static Collection<Object[]> data() {
    Collection<Object[]> testCases = new ArrayList<>();
    try {
      Scanner scannerExpression = new Scanner(new FileInputStream(new File(pathExpression)));
      Scanner scannerExpected = new Scanner(new FileInputStream(new File(pathExpected)));
      while (scannerExpression.hasNext() && scannerExpected.hasNext()){
        String[] testCase = new String[2];
        testCase[0] = scannerExpression.nextLine();
        testCase[1] = scannerExpected.nextLine();
        testCases.add(testCase);
      }
    }catch (IOException e){

    }
    return testCases;
  }
  @Test
  public void display(){
    assertThat(CalculatorMulti.display(expression), is(expected));
  }

}