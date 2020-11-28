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
       
       static double StaticHouseLoan(double loan, double r, double quota){
                      //exercice about calculate the loan to buy a house with the french system
           double interest = loan*r/12;
           double amort=quota-interest;
           List<Double> Log = new ArrayList<Double>();
           
           if (amort<0){
               System.out.println("Not enought quota");
               return 0;
           }
           return StaticHouseLoan(Log,loan,r,quota);

       }
       
       static double StaticHouseLoan(List Log, double loan, double r, double quota){
          
         double interest = loan*(r/12);
         double amort=quota-interest;
           
           if (loan <= quota){
               Log.add(0.00);
               for(int i=0;i<Log.size();i++ ){
                   System.out.println(i+" : "+String.format("%.2f",Log.get(i)));
               }
               return 0;
           } else {
               loan=loan-amort;
               Log.add(loan);
               return StaticHouseLoan(Log, loan, r,quota);
           }
           

  
       }
       
       static void nQueenProblem(int n){
         
       class QueenPosition{ //Queen Position objects to define the x,y and diagonals for each Queen
           int x,y,d1,d2;
           public QueenPosition(int posx, int posy){
               x=posx;
               y=posy;
               d1=x+y;
               d2=x-y;
                      }
           void set(int posx, int posy){
               x=posx;
               y=posy;
               d1=x+y;
               d2=x-y;
           }
            }  

        class nQueenProblem{
        
           boolean CheckPosition(List<QueenPosition> Positions,QueenPosition Position){
               List<Integer> xpos=new ArrayList<Integer>();
               List<Integer> ypos=new ArrayList<Integer>();
               List<Integer> d1pos=new ArrayList<Integer>();
               List<Integer> d2pos=new ArrayList<Integer>();
               for(int i=0;i<Positions.size();i++){
                   xpos.add(Positions.get(i).x);
                   ypos.add(Positions.get(i).y);
                   d1pos.add(Positions.get(i).d1);
                   d2pos.add(Positions.get(i).d2);
               } 
            return (!(xpos.contains(Position.x) || ypos.contains(Position.y) || d1pos.contains(Position.d1) || d2pos.contains(Position.d2)));
            } //function to check if i can put a queen in a specific Position
         
            List<QueenPosition> nQueen(int n){

                List Positions = new ArrayList<QueenPosition>();
                return nQueen(Positions,n);
                
                
            } //initialization of function just with the n rows.
            
            List<QueenPosition> nQueen(List<QueenPosition> Positions,int n){

                if ( Positions.size()==n ){ return Positions; } //1st stop condition for recursivity: We already have all the queens in the ground. if it finds that we already have all the queens in the ground, it finish the functions and returns the input list because it dosnt need to do anyting anymore, this is one kind of stop condition for the recursitvity
                
                List<QueenPosition> aux_Positions = new ArrayList<QueenPosition>(); //for data structure purposes, we will need an aux list to fill with the candidate solution. It will be filled with the new posible queen positions and it will be cleared if the positions lead us to a non-solution.     
                for (int t=0;t<Positions.size();t++){
                     aux_Positions.add(Positions.get(t)); //for data structure purposes we need to copy each element in the aux_variable. If we dont, it won't copy the contnt but it will create a new reference to the main variable, and it will made that if we change the aux_variable it also will change the main variable.
                     }
                

                   QueenPosition Queen=new QueenPosition(0,0); //initialize a position just for having the data structure to fill in the next lines.
                   
                     for(int i =0;i<n;i++){
                         for(int k=0;k<n;k++){
                             Queen.set(i,k); //we will try each posible position in the ground
                             
                             if(CheckPosition(aux_Positions,Queen)){ //it will check if it is a viable position.
                                 aux_Positions.add(Queen); //if it is, it will add to the aux list
                                 aux_Positions=nQueen(aux_Positions,n); // and it will try to solve the problem with the new queen in the ground
                                 
                                 if(aux_Positions.size()==n){ //2on STOP condition: if that resolves the exercies,it will return the aux variable as solution with n queens on the ground
                                    return aux_Positions;
                                       } else { //if that DONT resolve the problem, it will erase all changes made in the aux variable and will continue the exercice with the next posible position.
                                      aux_Positions.clear();
                                     for (int t=0;t<Positions.size();t++){
                                     aux_Positions.add(Positions.get(t));
                                         }
                                 }
                                       
                             }
                             
                             
                         }
                     }
       
        
                    return Positions; //when the functions tested all the posible positions, it will return the list of the queens in the ground in that moment.
                                        // there is 2 posibilities:
                                                //1) Theres <n queens on the ground: it will lead to the previous recursive iteration to erase all changes made and try the next queen position.
               }                                //2) Theres 0 queens on the ground: That means that it tried every posible combination and didnt found any solution, so it will return an empty list that means that tehre is no solutions.
           
            
            List<QueenPosition> Solution;
            public nQueenProblem(int n){
                Solution=nQueen(n);
                
            }
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        nQueenProblem Problem=new nQueenProblem(n);
        if(Problem.Solution.size()==0){ System.out.println("No solution"); //if the functions returns 0 size list, it means that it didnt found any solution that fills the n row's condition
        } else {
        System.out.println("Number of queens: "+Problem.Solution.size());
        
        for (int i =0;i<Problem.Solution.size();i++){
            System.out.println("Reina "+i+" : x="+Problem.Solution.get(i).x+" : y= "+Problem.Solution.get(i).y + "    diagonals:"+Problem.Solution.get(i).d1+":"+Problem.Solution.get(i).d2);
        }

        
       }
       
       }
    }







