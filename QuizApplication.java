import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.IOException;

public class QuizApplication{
 public static void main(String ar[]){
     
Quiz quiz=new Quiz();
quiz.begin();
}
}
class Quiz{
void begin(){

Question q1=new Question("Which is a valid keyword in java?", "interface","inherit","unsigned","derive",new Answer("interface"));

Question q2=new Question("Where does an object get created in memory?", "stack","queue","heap","none of the above",new Answer("heap"));

Question q3=new Question("Which keyword is used to prevent a method from getting overriden?","extends","final","static","implements",new Answer("final"));

Question q4=new Question("What is the this() constructor call used?","to invoke a parent class constructor","to invoke a child class constructor","to invoke another constructor of the same class","to invoke another constructor a different class",new Answer("to invoke another constructor of the same class"));

Question q5=new Question("What is the correct syntax for java main method","public static void main()","public void main()","main()","none of the above",new Answer("public static void main()"));

Question questionArr[]={q1,q2,q3,q4,q5};
int countTotal=0;
int countCorrect=0;
int countWrong=0;

for(Question q:questionArr){
System.out.println(q.getQuestion());
System.out.println("A. "+q.getOption1());
System.out.println("B. "+q.getOption2());
System.out.println("C. "+q.getOption3());
System.out.println("D. "+q.getOption4());
System.out.println("\nEnter an option");

Scanner scanner=new Scanner(System.in);
char option=scanner.next().charAt(0);
String answer="";

switch(option){
case 'A':
answer=q.getOption1();
break;
case 'B':
answer=q.getOption2();
break;
case 'C':
answer=q.getOption3();
break;
case 'D':
answer=q.getOption4();
break;
default:
break; 
}

if(answer.equals(q.answer.getAnswer())){

System.out.println(".........");
System.out.println("Correct Answer");
System.out.println(".........");
countCorrect++;

}
else{

System.out.println(".........");
System.out.println("Wrong Answer");
System.out.println(".........");
countWrong++;
}

System.out.println("\n--------------------------------------------\n");
countTotal++;
}
IResult result=new Result(countTotal,countCorrect,countWrong);
result.showResult();

}
}

class Question{
String question;
String option1;
String option2;
String option3;
String option4;
Answer answer;

public Question(String question,String option1,String option2,String option3,String option4,Answer answer){
super();
this.question=question;
this.option1=option1;
this.option2=option2;
this.option3=option3;
this.option4=option4;
this.answer=answer;
}

public String getQuestion(){
return question;
}

public String getOption1(){
return option1;
}

public String getOption2(){
return option2;
}

public String getOption3(){
return option3;
}

public String getOption4(){
return option4;
}

public Answer getAnswer(){
return answer;
}

}
class Answer{

String answer;

public Answer(String answer){
super();
this.answer=answer;
}

public String getAnswer(){
return answer;
}

}

interface IResult{
public void showResult();
public double showPercentage(int correctAnswers,int totalQuestions);
String showPerformance(double percentage);
}

class Result implements IResult{
int totalQuestions;
int correctAnswers;
int wrongAnswers;

public Result(int totalQuestions, int correctAnswers, int wrongAnswers){
super();
this.totalQuestions=totalQuestions;
this.correctAnswers=correctAnswers;
this.wrongAnswers=wrongAnswers;
}


public void showResult(){
System.out.println("Your Results:");
System.out.println("Total Questions:     "+totalQuestions);
System.out.println("Correct Answers:     "+correctAnswers);
System.out.println("Wrong Answers:     "+wrongAnswers);
System.out.println("Percentage:     "+showPercentage(correctAnswers,totalQuestions));
System.out.println("OverAll Performance:     "+showPerformance(showPercentage(correctAnswers,totalQuestions)));

}

public double showPercentage(int correctAnswers,int totalQuestions){
return ((double)correctAnswers/totalQuestions)*100;
}

public String showPerformance(double percentage){
String performance="";

if(percentage > 60){

performance="Good";

}

else if(percentage <40){

performance="Poor";

}

else{

performance="Average";


}

return performance;
}
}