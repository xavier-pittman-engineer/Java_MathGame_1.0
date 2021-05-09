package com.mycompany.mathgame;

    import java.text.NumberFormat;

public class ProblemType {
    
    
    NumberFormat percent = NumberFormat.getPercentInstance();
    
    int problem = 1;
    int divide=0, multiply=0, add=0, subtract=0;
    int answer;
    int bigNum;
    String strProblem;
  
    
    public String getProblem(){
        return strProblem;
    }
    
    public void setDivide(){
        divide=divide-1;}
    
    public void setMultiply(){
        multiply=multiply-1;}
    
    public void setAdd(){
        add=add-1;}
    
    public void setSubtract(){
        subtract=subtract-1;}
    
    public String retTotal(int answered, int answeredright){
        String Score =  percent.format((double)answeredright/(double)answered);
    return (Score);}
    
    public void getTotal (int answered, int answeredright){
    
        System.out.println("Correct Answers: "+answered +" out of " +answeredright +" " 
            +percent.format((double)answeredright/(double)answered) +"\n");}
    
    public void getDivide(int Correct){
        if (divide>0){
        System.out.println("The Division Percentage is "+percent.format((double)Correct/(double)divide)
                + ". \nYou answered " +(Correct) +" out of " +(divide)+"\n");
        }
        else {System.out.println("No Division was done.\n ");}
    }
    
    public void getMultiply(int Correct){
        if (multiply>0){
        System.out.println("The Multiplication Percentage is " +percent.format((double)Correct/(double)multiply)
                + ". \nYou answered " +(Correct)+" out of " +(multiply)+"\n");
        }
        else {System.out.println("No Multiplication was done.\n ");}
    }
    
    public void getAdd(int Correct){
        if (add>0){
        System.out.println("The Addition Percentage is " +percent.format((double)Correct/(double)add)
                + ". \nYou answered " +(Correct) +" out of " +(add)+"\n");
        }
        else {System.out.println("No Addition was done.\n ");}
    }
    
    public void getSubtract(int Correct){
        if (subtract>0){
        System.out.println("The Subtraction Percentage is " +percent.format((double)Correct/(double)subtract)
                + ". \nYou answered " +(Correct) +" out of " +(subtract)+"\n");
        }
        else {System.out.println("No Subtraction was done.\n");}
    }
    
    public int Select (int choice, int num1, int num2){
        switch(choice){
            
            case(1): bigNum = num1 * num2;
                     System.out.println("Divdide or type quit to quit");
                     answer=num2;
                     divide++;
                     strProblem = ("Number " +problem +"\t\n" +bigNum +" /" +num1 + " = ");
                     break;
                     
            case(2): System.out.println("Multiply or type quit to quit"); 
                     answer=num1*num2;
                     multiply++;
                     //System.out.print(+answer);
					 strProblem = ("Number " +problem +"\t\n" +num1 +" * " +num2 + " = ");
                     break;
                
            case(3): System.out.println("Add or type quit to quit");
                     answer=num1+num2;
                     add++;
                     //System.out.print(+answer);
                     strProblem = ("Number " +problem +"\t\n" +num1 +" + " +num2 + " = ");
					 break;
            
            case(4): bigNum = num1 + num2;
                     System.out.println("Subtract or type quit to quit"); 
                     answer=num2;
					 strProblem = ("Number " +problem +"\t\n" +bigNum +" - " +num1 + " = ");
                     subtract++;
                     //System.out.print(+answer);
                     break;
              
            default: System.out.print("No operation has been chosen") ; 
                     break;}//End Of Switch
        
        problem+=1;//Keeps up with problem number
        
        return (answer);
                        
    }//End of Select Method
    
}//End of Class
