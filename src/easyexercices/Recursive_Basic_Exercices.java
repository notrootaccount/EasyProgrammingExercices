
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
}
