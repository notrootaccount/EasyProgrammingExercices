package easyexercices;
import java.util.*;


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
       
       static String dectobin(long number){ //the method is kinda strange. First of all we are doing the manual method of division by 2 and taking the residues
           long result;
           if ( number == 1 || number == 0){   //the last result Must be 2, always, this is how the Decimal to Binari manual method works. Then we take the last result (1) as first digit of the new binari number
               return String.valueOf(number);
           } else { 
              return dectobin(number/2) + String.valueOf(number%2);
              //the we start taking all the residues from the last one to the first one. To represent that we are going to multiply each step by 10, so we are going to represent binary number in a decimal datatype
           }    //when it multiply by 10 the new bin number, it will "add" new digit in the right part of the number
                //it will work as:     binary number that we already have: 10101 
                //                      binary digit we want to add:   1
                //                      procedure:              10101*10 = 101010
                                                    //             101010+1 = 101011
                 // with this procedure we will the value of the residue of the "manual division" in the right part of our number that is being made.
       }
       
       static void HanoiTowers(){
           
            class HanoiTower {
               Stack contents;
               
               public HanoiTower(){
                   contents = new Stack<Integer>();

               }
               
               void FillTower(){
                   
                   for (int i = 1; i<=8;i++){
                       contents.push(i);
                   }
                   
               }
               
               void printTower(){
                   Stack aux = new Stack();
                   Integer aux_i = 0;
                   System.out.println("---------");
                   while ( contents.size()!=0 ){
                       aux_i=(int)contents.pop();
                       aux.push(aux_i);
                   }
                   while ( aux.size()!= 0){
                       aux_i=(int)aux.pop();
                       contents.push(aux_i);
                       System.out.print(aux_i);
                       
                   }
                    System.out.println("");
                   System.out.println("---------");
               }
               
               Integer getTop(){
                   if (contents.empty()){
                       return 0;
                   } else {
                       return (Integer)contents.peek();
                   }
               }
               Integer getSize(){
                   return contents.size();
               }
               
               Stack getTower(){
                   return contents;
               }
               
               
           }
           
            class HanoiProblem {
                HanoiTower Tower1;
                HanoiTower Tower2;
                HanoiTower Tower3;
                
                HanoiProblem(HanoiTower T1,HanoiTower T2,HanoiTower T3){
                    Tower1=T1;
                    Tower2=T2;
                    Tower3=T3;
                }
                void PrintState(){
                    Tower1.printTower();
                    Tower2.printTower();
                    Tower3.printTower();
               
                }      
                void Solve(HanoiTower src, HanoiTower aux, HanoiTower dst,int ammount){
                    
                    if( ammount==1 ){
                            Solve(src,dst);
                    } else {
                           Solve(src, dst,aux,ammount-1);
                           Solve(src,dst);
                           Solve(aux,src,dst,ammount-1);
                    }
                        
               }
                
               void Solve(HanoiTower src, HanoiTower aux, HanoiTower dst){
                   int ammount = src.contents.size();
                   Solve(src,aux,dst,ammount);
               }
               void Solve(HanoiTower src, HanoiTower dst){
                   dst.contents.push(src.contents.pop());
               }
                
            }
            
           
            HanoiTower left = new HanoiTower();
            HanoiTower center = new HanoiTower();
            HanoiTower right = new HanoiTower();
            left.FillTower();
            HanoiProblem Exercice = new HanoiProblem(left,center,right);    
            Exercice.PrintState();
            System.out.println("Inicio");
            Exercice.Solve(left,center,right,4);
            Exercice.PrintState();
           
       }

       static Boolean IsPalindrome(String Text){

           String AuxText="";
           
           for(int i = 0;i<Text.length();i++){
               
               if( Text.charAt(i) != ' ' ){
                AuxText=AuxText+Text.charAt(i);
               }
               
           }
           AuxText=AuxText.toLowerCase();        
                      
           return IsPalindromeRec(AuxText);
       }
       
       
       
            
       static Boolean IsPalindromeRec(String Text){
           if (Text.length()==0 || Text.length()==1){
                return true;
                
            } else {
                return IsPalindromeRec(Text.substring(1,Text.length()-1)) &&   Text.charAt(0)  ==  Text.charAt(Text.length()-1);            
                }
                
            }
       
       static int GreaterCommonDivisor(int val1, int val2){
           
           
           for (int i = 2;       i < Math.sqrt(val1)    ||         i < Math.sqrt(val2)        ;i++){
               if ( val1%i==0 && val2%i==0 ){
                   return i*GreaterCommonDivisor(val1/i,val2/i);
                                             }    //searchin any common divisor
           }
           
           
           
           
           
           
           
           return 1; //if it dont found any divisor, 1 is the universal divisor.
       }
    }







