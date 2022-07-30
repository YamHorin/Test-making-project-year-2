package id_318853256id_208421438;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AmericanQuestions extends Questions implements Serializable, Cloneable{
	private int numofanswers;
	private ArrayList<AmericanAnswers> answers;
	private int numberofCorrectanswers;
	public AmericanQuestions(int num, String Question, char r ,ArrayList<AmericanAnswers> answers) {
		super(num, Question, r);
		this.answers = answers;
		int numOfAnswers = 0;
		int correct =0;
		for (int i = 0; i< answers.size(); i++) {
			if (answers.get(i)!=null)
			{
				numOfAnswers++;
				if (answers.get(i).isCorrect()==true)
					correct++;
			}
			
		}
		this.numofanswers = numOfAnswers;
		this.numberofCorrectanswers = correct;
				
		}
	@Override
	public boolean addAnswerAuto(AmericanAnswers a)
	{	
		
		for (AmericanAnswers americanAnswers : answers) {
			if (americanAnswers!=null)
			{
				if (a.equals(americanAnswers)==true)
					return false;
			}
		}
		int counterOfCorrect = 0;
		this.answers.add(a);
		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i)!=null)
			{
				answers.get(i).setSerialnumber(i+1);
				if (answers.get(i).isCorrect()==true)
					counterOfCorrect++;
				
			}
		}
		if (counterOfCorrect<2)
		{
			counterOfCorrect = 0;
			this.numofanswers = this.answers.size();
			this.numberofCorrectanswers = counterOfCorrect;
			return true;
		}
		counterOfCorrect = 0;
		this.answers.remove(a);
		this.numofanswers = this.answers.size();
		return false;
		
			
	}

	@Override
	public String toString() {
		String g = " ";
		g=g+"Question:  "+this.getNumques()+"   \n"+this.getQuestion()+"\n";
		System.out.println("Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString());
		for (int i = 0; i < this.answers.size(); i++) {
			if (this.answers.get(i)!=null)
			{
				System.out.println(answers.get(i).toString());
				g= g+answers.get(i).toString()+"\n";
			}
			
				
		}
		if (this.numberofCorrectanswers>1)
		{
			g=g+"number of answers "+this.numofanswers+"\n"+"there is MORE then one correct answer \n ";
			System.out.println("number of answers "+this.numofanswers+"\n"+"there is MORE then one correct answer \n \n");
		}
		if (this.numberofCorrectanswers==0)
		{
			g=g+"number of answers "+this.numofanswers+"\n"+"there is NO correct answer \n";
			System.out.println("number of answers "+this.numofanswers+"\n"+"there is NO correct answer \n") ;
		}
			
		return g+"number of answers "+this.numofanswers;
	}
	@Override
	public boolean equals(Object other)
	{
		if (other!=null)
		{
			if (other.getClass().equals(this.getClass()))
			{
				AmericanQuestions temp = (AmericanQuestions)other;
						return super.equals(temp);
			}
		}
			return false;
		}
		
	@Override
	public void DeletAnswer(int num) {
		this.answers.remove((num));
		for (int i = 0; i < this.answers.size(); i++) {
			this.answers.get(i).setSerialnumber(i+1);
		}
		this.numofanswers=this.answers.size();
		int i=0;
		for (AmericanAnswers americanAnswers : answers) {
			if (americanAnswers.isCorrect()==true)
				i++;
		}
		this.numberofCorrectanswers=i;
	}
	public int getNumofanswers() {
		return numofanswers;
	}
	public void setNumofanswers(int numofanswers) {
		this.numofanswers = numofanswers;
	}
	@Override
	public ArrayList<AmericanAnswers> getAnswers() {
		return answers;
	}
	@Override
	public void setAnswers(ArrayList<AmericanAnswers> answers) {
		this.answers = answers;
	}
	public int getNumberofCorrectanswers() {
		return numberofCorrectanswers;
	}
	public void setNumberofCorrectanswers(int numberofCorrectanswers) {
		this.numberofCorrectanswers = numberofCorrectanswers;
	}

	@Override
	public boolean changeanswer(String answer, int numberOfAmericanAnswer, boolean iscorrect) {
		AmericanAnswers d = new AmericanAnswers(numberOfAmericanAnswer, answer, iscorrect);
		for (int i = 0; i < this.answers.size(); i++) {
			if (this.answers.get(i).equals(d)==true)
				return false;
		}
		this.answers.set(numberOfAmericanAnswer-1, d);
		if (iscorrect==true)
			this.numberofCorrectanswers++;
		return true;
		
	}
	@Override
	public void addAnswerAmerican(AmericanAnswers a) {
		this.answers.add(a);
		
	}
	@Override
	public String toStringWithoutAnswers() {
		String s =" ";
		ArrayList<String> answerss = new ArrayList<>();
		for (AmericanAnswers answer: answers) {
			answerss.add(answer.toStringWithoutAnswers());
		}
		for (String string : answerss) {
			s =s +"\n"+string.toString();
		}
		if (this.numberofCorrectanswers>1)
			return "Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString()+" \n" +s+"\n"+"there is MORE then one correct answer";
		if (this.numberofCorrectanswers==0)
			return "Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString()+" \n" +s+"\n"+"there is NO correct answer";
		
		return "Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString()+" \n" +s;
		
	}
	@Override
	public String toStringWithAnswers() {
		String s = null;
		ArrayList<String> answerss = new ArrayList<>();
		for (AmericanAnswers answer: answers) {
			answerss.add(answer.toString());
		}
		for (String string : answerss) {
			s =s +"\n"+string.toString();
		}
		if (this.numberofCorrectanswers>1)
			return "Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString()+" \n" +s+"\n"+"there is MORE then one correct answer";
		if (this.numberofCorrectanswers==0)
			return "Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString()+" \n" +s+"\n"+"there is NO correct answer";
		
		return "Question:  "+this.getNumques()+"   \n"+this.getQuestion().toString()+" \n" +s;
	}
	@Override
	public int AnswerLenght() {
		int lenght=0;
		for (AmericanAnswers americanAnswers : answers) {
			if (americanAnswers!=null)
				lenght  = lenght+americanAnswers.getAnswer().length();
				
		}
		return lenght;
	}
	public void AddAnswerOpen() {
		
		
	}
	@Override
	public void AddAnswerOpen(String answer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAnswer1() {
		// TODO Auto-generated method stub
		return null;
	}

	}
	
	

	

	


