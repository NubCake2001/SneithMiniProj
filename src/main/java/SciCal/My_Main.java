package SciCal;
import java.lang.Math;
import java.util.*;
public class My_Main 
{
 public My_Main() {}
 public static void main(String[] args) 
 {
   try
   {
   My_Main calculator=new My_Main();
   Scanner scanner=new Scanner(System.in);
   System.out.println("Hii, Welcome to Scientific Calculator!!");
   System.out.println("Choose which operation to do, by selecting the corrosponding number");
   System.out.println("Press 1 to get square root \nPress 2 to get factorial\nPress 3 to get natural logarithm\nPress 4 to get power function");
   int input=scanner.nextInt();;
   if(input==1)
   {
   System.out.println("Enter the number");
   System.out.println("Square root result is : " + calculator.root(scanner.nextDouble()));
   }
   else if(input==3)
   {
   System.out.println("Enter the number");
   System.out.println("Natural logarithm result is : " + calculator.log(scanner.nextDouble()));
   }
   else if(input==2)
   {
   System.out.println("Enter the number");
   System.out.println("Factorial result is : " + calculator.factorial(scanner.nextInt()));
   }
   else if(input==4)
   {
   System.out.println("Enter the numbers");
   System.out.println("Power function result is : " + calculator.power(scanner.nextDouble(),scanner.nextDouble()));
   }
   else
   System.out.println("Invalid input");
   System.out.println("Done, Bye!!");
   }
   catch(InputMismatchException error)
   {
   System.out.println("Invalid input, Entered input is not of the expected type");
   return;
   }           
 }
//These functions are not defined over the entire real range. So, for inputs out of the domains, nan is returned.
 public double root(double number1) 
 {
  return Math.sqrt(number1);
 }
 public double factorial(int number1) 
 {
  if(number1<0)
   return Double.NaN;
  double fact=1;  
  for(int i=1;i<=number1;i++)    
   fact=fact*i;    
  return fact;
 }
 public double log(double number1) 
 {
  return Math.log(number1);
 }
 public double power(double number1, double number2) 
 {
  return Math.pow(number1 , number2);
 }
}
