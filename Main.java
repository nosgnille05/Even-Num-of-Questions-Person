import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    distributeEvenNumOfQuestions();
  }

  public static void distributeEvenNumOfQuestions(){
    //Estabish a scanner to take input from the guest
    Scanner scan = new Scanner(System.in);
    System.out.print("How many questions are there?  ");
    int totalNumQuestions = scan.nextInt();
    System.out.print("How many group members?  ");
    int totalNumGroupMembers = scan.nextInt();
    scan.close();

    //Establsh our variables
    int numQuestionDistribution;
    int questionSectionEnd;
    int questionsPerPerson = totalNumQuestions / totalNumGroupMembers;
    int questionsPerPersonExtra = questionsPerPerson + 1;
    int remainingQuestions = numQuestionDistribution = totalNumQuestions % totalNumGroupMembers;
    int questionSectionStart = 1; 

    //Print what we have
    System.out.println("\nQuestions /Person: " + questionsPerPerson);
    System.out.println("Questions /Person Extra: " + questionsPerPersonExtra);
    System.out.println("Num Question Distribution: " + numQuestionDistribution);
    System.out.println("\nGroup Member     # Questions     Questions");  

    //Foor loop to move through all group members
    for (int groupMemberCount = 1; groupMemberCount <= totalNumGroupMembers; groupMemberCount++){

    //Distribute Remainder Questions
    if (numQuestionDistribution > 0 && groupMemberCount >= totalNumGroupMembers - numQuestionDistribution+1){
      questionSectionEnd = questionSectionStart + (questionsPerPersonExtra - 1);
      System.out.print("      " + groupMemberCount);  
      System.out.print("               " + questionsPerPersonExtra + "           ");
      System.out.println(questionSectionStart + " - " + questionSectionEnd);
      questionSectionStart = questionSectionEnd + 1;
      numQuestionDistribution--;
    }
    else{ //No More Remainder Questions
      questionSectionEnd = questionSectionStart + (questionsPerPerson - 1);
      System.out.print("      " + groupMemberCount);  
      System.out.print("               " + questionsPerPerson + "           ");
      System.out.println(questionSectionStart + " - " + questionSectionEnd); 
      questionSectionStart = questionSectionEnd + 1;
    } 
    }
  }
}
