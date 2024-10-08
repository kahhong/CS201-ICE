package com.skahhong.playground.ice2.dsaj.stacks;

import com.skahhong.playground.ice2.net.datastructures.LinkedStack;
import com.skahhong.playground.ice2.net.datastructures.Stack;

import java.util.Scanner;

public class InsertLeft {
  public static void main(String[] args) {

    String example = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
    Stack<String> ops = new LinkedStack<String>();
    Stack<String> vals = new LinkedStack<String>();

    Scanner scanner = new Scanner(example);
    while(scanner.hasNext()) {
      String s = scanner.next();
      if (s.equals("("));
      else if (s.equals("+") || s.equals ("-") || s.equals ("*") || s.equals ("/"))
        ops.push(s);
      else if (s.equals(")")) {
        String op = ops.pop();
        String val1 = vals.pop();
        String val2 = vals.pop();
        vals.push("( " + val2 + " " + op + " " + val1 + " )");
      }
      else
        vals.push(s);
      
    }
    System.out.println(vals.pop());
    
    scanner.close();
  }
}
