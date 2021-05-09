// *****************************************************************************
// PROGRAM:Math Tutor 
//
// PROGRAMMER: Xavier Pittman
//
// DESCRIPTION: Generate Random Math Problems.  Gives feedback on how well the user scores.
// Gives the user an option to see how well he/she scored in a specific field.
// The program runs until the user tells it to quit.
//
// *****************************************************************************
package com.mycompany.mathgame;
    
    import java.util.Scanner;
    import org.apache.commons.lang3.math.NumberUtils;
    //This dependency had to be added in the pom.xml file. 
    // The version number had to be exact.
    // Please note XML code
    /*    <dependencies>
         <dependency>
          <groupId>org.apache.commons</groupId>
          <artifactId>commons-lang3</artifactId>
          <version>3.12.0</version>
         </dependency>
        </dependencies>     */

public class mathGameMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//For the Input
           
        ProblemType Operand = new ProblemType(); //Class That handles problems
        //Listing l1 = new Listing ();
        //SinglyLinkedList oleMiss = new SinglyLinkedList();
        
        int answer, numCorrect=0, Answered=0, divr=0, subr=0,addr=0,mulr=0;
        boolean keepLoopUp,keepLoopUp2;
        
       String guessRaw="go";//Variable used to exit Loops
       String quitRaw="go"; //Variable used to exit Loops
        
        //String strProblem;
        
        do{
            
        guessRaw="go"; //Dummy assignment
        quitRaw="go";  //Dummy assignment
            
            while(!(guessRaw.equalsIgnoreCase("quit")))
            { int Operator=(int)(4*Math.random()+1);//This randomly selects operator
                int num1=(int)(9*Math.random()+1);//This randomly selects a number
                int num2=(int)(9*Math.random()+1);//This randomly selects a number
        
                answer = Operand.Select(Operator,num1,num2);//Selects a problem
                System.out.println(Operand.getProblem());//Prints the problem
                guessRaw=input.nextLine();//Input from user 
                
                if (guessRaw.equalsIgnoreCase("quit"))
                    {System.out.println("You ended the session\n");
                    Answered+=0;
                    switch (Operator) {
                        case 1 -> Operand.setDivide();
                        case 2 -> Operand.setMultiply();
                        case 3 -> Operand.setAdd();
                        case 4 -> Operand.setSubtract();
                        default -> {
                            }//End of default
                        }////End of switch
                    }//Keeps up with num of problems answered--Ends if
    
                else if ((!(guessRaw.equalsIgnoreCase("quit"))) && (!(NumberUtils.isParsable(guessRaw)))){
                    
                    System.out.println("Invalid Response\n");
                    
                    }//Handles issue if user doesn't type a valid answer

                else if (Integer.parseInt(guessRaw)==answer)
                    {System.out.println("Correct!\n");
                    numCorrect++;
                    Answered++;

                    switch (Operator) {
                        case 1 -> divr++;
                        case 2 -> mulr++;
                        case 3 -> addr++;
                        case 4 -> subr++;
                        default -> {
                            }
                        }
                //Operator if
                //strProblem = Operand.getProblem();
                //l1.setName(strProblem);
                //oleMiss.insert(l1);

                    }//End of Operator if. Keeps up with num of correct

                else if (Integer.parseInt(guessRaw)!=answer)
                    {System.out.println("Incorrect. The Correct Answer is: "+answer +"\n");
                    Answered++;
                    // l1.setName(Operand.getProblem());
                       // oleMiss.insert(l1);}
                    }//GameLoop
                
                }//Ends do 2nd
                        
            //This is a if that displays a message depending on performance
            if (Answered>0 && 100*numCorrect/Answered>=80 && numCorrect!=0){System.out.println("Great Job!!!!");}
            if (Answered>0 && 100*numCorrect/Answered<=60){System.out.println("More Practice...");}
    
            String selectionRaw;
        do{
            //This will let users make a choice of which category they'd like to see
            System.out.println("To see results for a specific category type:"
                    + "\n1 for Subtraction, 2 for Addition, 3  for Multiplication, 4 for Division, 5 for All\n"
                    + "Type Quit to Quit\n");
                        
            //Switch for displaying a specific operands results
        
            selectionRaw=input.nextLine();//Input Statement
        
            switch (selectionRaw){//Start of switch that gives choices to view scores and %
            
                case ("1") -> Operand.getSubtract(subr);
                    //Subtraction case
                case ("2") -> Operand.getAdd(addr);
                    //Addition case
                case ("3") -> Operand.getMultiply(mulr);
                    //Multiplication case
                case ("4") -> Operand.getDivide(divr);
                    //Division case
                case ("5") -> {
                    Operand.getTotal(numCorrect, Answered);
                    Operand.getSubtract(subr);
                    Operand.getAdd(addr);
                    Operand.getMultiply(mulr);
                    Operand.getDivide(divr);
                        //Display all case
                    }
                case ("quit") -> System.out.println("Quit"); //Exit menu choice
                    //Quit Case
                default -> System.out.println("Invalid Choice");    //Invalid menu choice
                
                }   //End of switch   
                
        } while (!(selectionRaw.equalsIgnoreCase("quit")));//End of while & do
    
        do{//Loop for restarting the program or quitting
            System.out.println("Would you like to continue? \tGo = Continue \tStop = End Session/Next Player \n");
            quitRaw=input.nextLine();//decides if the program should continue
            
            keepLoopUp =!(quitRaw.equalsIgnoreCase("Go"));//Returns True if not Go
            keepLoopUp2 =!(quitRaw.equalsIgnoreCase("Stop"));//Returns True if not Stop
            
            } while (keepLoopUp && keepLoopUp2);//End of do while loop 
            //End of quit or restart loop
            
    } while (keepLoopUp2);//Ends While & do
        
        //oleMiss.showAll();
        
    }//End of Main
    
}//End of Program
