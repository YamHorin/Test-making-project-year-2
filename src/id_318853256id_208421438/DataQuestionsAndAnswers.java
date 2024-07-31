package id_318853256id_208421438;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class DataQuestionsAndAnswers implements Serializable , Cloneable{
	private Set <AmericanAnswers> allAnswerAmerican;
	private ArrayList<Questions> allQuestions;


	public Set<AmericanAnswers> getAllAnswerAmerican() {
		return allAnswerAmerican;
	}
	public void setAllAnswerAmerican(Set<AmericanAnswers> allAnswerAmerican) {
		this.allAnswerAmerican = allAnswerAmerican;
	}
	public ArrayList<Questions> getAllQuestions() {
		return allQuestions;
	}
	public void setAllQuestions(ArrayList<Questions> allQuestions) {
		this.allQuestions = allQuestions;
	}
	public DataQuestionsAndAnswers(ArrayList<Questions> allQuestions, Set<AmericanAnswers> allAnswerAmerican) {
		
		this.allAnswerAmerican = allAnswerAmerican;
		this.allQuestions = allQuestions;
	}
	@Override
	public String toString() {
		String g="";
		for (int i = 0; i < this.allQuestions.size(); i++) {
			System.out.println("   ");
			System.out.println(this.allQuestions.get(i).toString());
			g= g+this.allQuestions.get(i).toString()+"\n"+"\n";
			System.out.println("   ");
		}
		return g+"\n Number of Questions  "+this.allQuestions.size();

	}
	public boolean AddQuestion(Questions newQuestion) {
		for (int i = 0; i < allQuestions.size(); i++) {
				if (this.allQuestions.get(i).equals(newQuestion)==true)
					return false;
		}
		newQuestion.setNumques(this.allQuestions.size()+1);
		this.allQuestions.add(newQuestion);
		return true;
		
	}
	public boolean UpdateQuestionText(int changeQuestion, String newQuestionText) {
		String oldText = this.allQuestions.get(changeQuestion-1).getQuestion();
		this.allQuestions.get(changeQuestion-1).setQuestion(newQuestionText);
		for (int i = 0; i < allQuestions.size(); i++) {
			if (i!=(changeQuestion-1))
			{
					if (this.allQuestions.get(i).equals(this.allQuestions.get(changeQuestion-1))==true)
					{
						this.allQuestions.get(changeQuestion-1).setQuestion(oldText);
						System.out.println("the question is already exist in the same type");
						return false;
					}
						
			}
		}
		return true;
		
	}
	public void DeletAnswer(int numberOfQuestionToDeletAnswer, int numberOfAmericanAnswer) {
		this.allQuestions.get((numberOfQuestionToDeletAnswer)).DeletAnswer(numberOfAmericanAnswer);
		
		}
	public void changeAnswer(int changeTheAnswerOfTHeQuestion, int americanAnswerNum, String newAnswer,
			boolean isCorrect) {
		this.allQuestions.get(changeTheAnswerOfTHeQuestion).changeanswer(newAnswer, americanAnswerNum, isCorrect);
		
		
	}

	public Test MakeNewAutoTest(int numOfQuestions, int numberIdTest)
	{
		ArrayList<Questions> allQuestionsInTheAutoTest = new ArrayList<>();
		ArrayList<AmericanAnswers> americanAnswersDelet  = new ArrayList<>();
//		Set<AmericanAnswers> americanAnswersBackUp = allAnswerAmerican ;
//		try {
//			americanAnswersBackUp = this.allAnswerAmerican.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		ArrayList<Questions> AllQuestionsBackUp = null;
		try {

			ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("ArrayList_Question"));
			AllQuestionsBackUp  = (ArrayList<Questions>)inFile.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		ArrayList <Integer> QuestionsNumbers = new ArrayList<>();
		for (Questions i : this.allQuestions) {
			if (i.getType()=='A')
			{
				americanAnswersDelet = i.getAnswers();
				americanAnswersDelet.clear();
				i.setAnswers(americanAnswersDelet);
			}
		}
		Random rt1  = new Random();
		boolean hasbeensucsess1 = false;
		boolean flagQuestionTwice = true;
		int counter=0;

		for (int i = 0; i < numOfQuestions; i++) {
			int numberQuestionHasBeenChosen1 =rt1.nextInt(this.allQuestions.size());
			do {

				for (Integer integer : QuestionsNumbers) {
					if (integer!=null)
					{
						if (integer==numberQuestionHasBeenChosen1)
						{
							
							counter++;
						}
							
					}
	
				}
				if (counter==0)
				{
					QuestionsNumbers.add(numberQuestionHasBeenChosen1);
					flagQuestionTwice=false;
				}
					
				else
				{
					numberQuestionHasBeenChosen1 =rt1.nextInt(this.allQuestions.size());
					counter=0;
				}
			} while (flagQuestionTwice);
			counter=0;
			flagQuestionTwice=true;
			if (this.allQuestions.get(numberQuestionHasBeenChosen1).getType()=='A')
			{
				for (int j = 0; j < 4; j++) {
				do {
					int numberFromDataAmericanAnswerToChose2  = rt1.nextInt(this.allQuestions.size());

					this.allAnswerAmerican.get(numberFromDataAmericanAnswerToChose2).setSerialnumber(j+1);
					hasbeensucsess1 = this.allQuestions.get(numberQuestionHasBeenChosen1).addAnswerAuto(this.allAnswerAmerican.get(numberFromDataAmericanAnswerToChose2));
					
					
				} while (hasbeensucsess1==false);
				hasbeensucsess1=false;
				}
			}
			this.allQuestions.get(numberQuestionHasBeenChosen1).setNumques(i+1);
			allQuestionsInTheAutoTest.add(this.allQuestions.get(numberQuestionHasBeenChosen1));
		}
		Test a = new Test(allQuestionsInTheAutoTest, numOfQuestions , 'A' , numberIdTest );
		
		this.allQuestions = AllQuestionsBackUp;
		return a;
		
	}
	public void removeObject(int num123) {
		this.allQuestions.remove(num123-1);
		
	}
	
	
		
		
	}
	
		
	
	
		
	
	

	
	

