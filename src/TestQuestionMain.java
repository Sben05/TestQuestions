import java.util.ArrayList;
import java.util.Scanner;
public class TestQuestionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TestQuestion> questions = new ArrayList<TestQuestion>();
		Scanner scan = new Scanner(System.in);
		boolean prompt = true;
		boolean mcq = false;
		boolean tf = false;
		
		while (prompt) {
			System.out.println("Would you like to create a Multiple Choice (Enter 0) or True/False (Enter 1) question?");
			int decision = scan.nextInt();
			if (decision == 0) {
				mcq = true;
				prompt = false;
			}
			else if (decision == 1) {
				tf = true;
				prompt = false;
			}
		}
		
		if (mcq) {
			System.out.println("What is the text of the question?");
			scan.nextLine();
			String text = scan.nextLine();
			System.out.println("How many answers are there?");
			int answerNum = scan.nextInt();
			String[] answerArr = new String[answerNum];
			scan.nextLine();
			for (int i = 0; i<answerNum; i++) {
				
				System.out.println("What is choice "+(i+1)+"?");
				answerArr[i] = scan.nextLine();
				
				
			}
			
			System.out.println("What is the correct answer?");
			String correctAnswer = scan.nextLine();
			MCQuestion question = new MCQuestion(text, answerArr, correctAnswer);
			questions.add(question);
			mcq = false;
		}
		else {
			System.out.println("What is the text of the question?");
			scan.nextLine();
			String text = scan.nextLine();
			System.out.println("What is the correct answer?");
			String correctAnswer = scan.nextLine();
			TrueFalse question = new TrueFalse(text, correctAnswer);
			questions.add(question);
			tf = false;
		}
		
		boolean moreQuestions = true;
		while(moreQuestions) {
			System.out.println("Would you like to add more questions?(Y/N)");
			String continueQuestions = scan.nextLine();
			if(continueQuestions.equals("Y")) {
				prompt = true;
				while (prompt) {
					System.out.println("Would you like to create a Multiple Choice (Enter 0) or True/False (Enter 1) question?");
					int decision = scan.nextInt();
					if (decision == 0) {
						mcq = true;
						prompt = false;
					}
					else if (decision == 1) {
						tf = true;
						prompt = false;
					}
				}
				
				if (mcq) {
					System.out.println("What is the text of the question?");
					scan.nextLine();
					String text = scan.nextLine();
					System.out.println("How many answers are there?");
					int answerNum = scan.nextInt();
					String[] answerArr = new String[answerNum];
					scan.nextLine();
					for (int i = 0; i<answerNum; i++) {
						
						System.out.println("What is choice "+(i+1)+"?");
						answerArr[i] = scan.nextLine();
						
						
					}
					System.out.println("What is the correct answer?");
					String correctAnswer = scan.nextLine();
					MCQuestion question = new MCQuestion(text, answerArr, correctAnswer);
					questions.add(question);
					mcq = false;
				}
				else {
					System.out.println("What is the text of the question?");
					scan.nextLine();
					String text = scan.nextLine();
					System.out.println("What is the correct answer?");
					String correctAnswer = scan.nextLine();
					TrueFalse question = new TrueFalse(text, correctAnswer);
					questions.add(question);
					tf = false;
				}
			}
			else
				moreQuestions = false;
		}
		
		for (int i = 0; i<questions.size(); i++) {
			System.out.println(questions.get(i).toString());
		}
	}

}
