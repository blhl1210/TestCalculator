import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
public class CalculatorMultiTest {
  final static String path = "src/test/resources/test.inp";
  final static int MAX = 4;
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
      Scanner scanner = new Scanner(new FileInputStream(new File(path)));
      int count = 0;
      while (scanner.hasNext()){
        String[] temp = scanner.nextLine().split(" ");
        String[] testCase = new String[2];
        testCase[1] = temp[temp.length-1];
        testCase[0] = String.join(" ",Arrays.copyOf(temp,temp.length-1));
        System.out.println(testCase[0]+" "+testCase[1]);
        testCases.add(testCase);
        count++;
      }
      System.out.println(0);
    }catch (IOException e){

    }
    return testCases;
/*
   return Arrays.asList(new Object[][]{
        {"1+2","3"},
        {"3+4","7"},
        {"6+8", "15"},
        {"3*2", "6"},
        {"5*5", "25"}
    });*/
  }
  @Test
  public void display(){
    assertThat(CalculatorMulti.display(expression), is(expected));
  }

}