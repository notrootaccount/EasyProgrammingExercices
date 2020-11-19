
package easyexercices;

public class Recursive_Basic_Exercices {
   public static void Recursive_Basic_Exercices(){       
    }  
       static int Exponential(int base, int exponent){//basic exercice for math power calculation
           
        if ( exponent == 0){
            return 1;
        }else {
            return base*Exponential(base, exponent-1); //the recursive statment works as b^e=b*b^(e-1) and it can be calculated itteratively until e=0 that it can be calculated as b^0=1
            
             }

       }
       
       
       static int Factorial(int number){
           if ( number == 1){
               return 1;
           } else {
               return number*Factorial(number-1);
           }
       }
       
       static int Fibonacci(int number){
           int result;
           if (number == 1 || number == 2){ //serie Fibonacci starts with 1+1+...
               return 1;
            } else {                        //then is calculated with the two numbers before, so the number n is calculated with (n-1)+(n-2)
               result=Fibonacci(number-1)+Fibonacci(number-2);
               return result;
           }
           
       }
       static long dectobin(long number){ //the method is kinda strange. First of all we are doing the manual method of division by 2 and taking the residues
           long result;
           if ( number == 1 ){   //the last result Must be 2, always, this is how the Decimal to Binari manual method works. Then we take the last result (1) as first digit of the new binari number
               return number;
           } else { 
              return (number%2) + dectobin(number/2)*10;
              //the we start taking all the residues from the last one to the first one. To represent that we are going to multiply each step by 10, so we are going to represent binary number in a decimal datatype
           }    //when it multiply by 10 the new bin number, it will "add" new digit in the right part of the number
                //it will work as:     binary number that we already have: 10101 
                //                      binary digit we want to add:   1
                //                      procedure:              10101*10 = 101010
                                                    //             101010+1 = 101011
                 // with this procedure we will the value of the residue of the "manual division" in the right part of our number that is being made.
       }
}
