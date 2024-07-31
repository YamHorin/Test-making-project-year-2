package id_318853256id_208421438;

import java.io.Serializable;
import java.util.ArrayList;

public class OpenQuestions extends Questions implements Serializable, Cloneable  {
	private String answer;
	

	public OpenQuestions(int num, String Question , char r ,String answer) {
		super(num, Question , r);
		this.answer = answer;
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (this.getQuestion()==null)
			return "question number :  "+this.getNumques()+"\n"+"the Question has been DELETED  "+"\n"+"  the answer  "+this.answer+"\n";
		if (this.answer==null)
			return "Question "+this.getNumques()+"  "+this.getQuestion()+"\n"+"the answer has been deleted ";
		return "Question:  "+this.getNumques()+"\n"+this.getQuestion()+"\n"+"the answer:  "+this.answer+"\n";
	}


	public String getAnswer() {
		return answer;
	}
	@Override
	public boolean	equals(Object other)
	{
		if (other!=null)
		{

			if (other.getClass().equals(this.getClass()))
			{	
				OpenQuestions temp = (OpenQuestions)other;
				if ( this.getQuestion()!=null && temp.getQuestion()!=null)
					return this.getQuestion().equalsIgnoreCase(temp.answer);
				return true;
			}
			
		}
		return false;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}





	@Override
	public void DeletAnswer(int num) {
		this.answer=null;
		System.out.println("this answer has been deleted.");
	}


	


	@Override
	public boolean addAnswerAuto(AmericanAnswers a) {
		return false;
	}



	@Override
	public boolean changeanswer(String answer, int numberOfAmericanAnswer, boolean iscorrect) {
		this.answer = answer;
		return true;
	}


	@Override
	public ArrayList<AmericanAnswers> getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAnswers(ArrayList<AmericanAnswers> answers) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void addAnswerAmerican(AmericanAnswers a) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toStringWithoutAnswers() {
		return "Question "+this.getNumques()+"  "+this.getQuestion().toString();
	}


	@Override
	public String toStringWithAnswers() {
		if (this.getQuestion()==null)
			return "Question "+this.getNumques()+"the Question has been DELETED  "+"  the answer  "+this.answer.toString()+"\r";
		if (this.answer==null)
			return "Question "+this.getNumques()+"\n"+"  "+this.getQuestion().toString()+"     the answer has been deleted ";
		return "Question:  "+"\n"+this.getNumques()+"   \n"+this.getQuestion().toString()+"\r"+"the answer  "+this.answer.toString()+"\r";
	}


	@Override
	public int AnswerLenght() {
		if (this.answer==null)
			return 0;
		return answer.length();
	}


	

	@Override
	public void AddAnswerOpen(String answer) {
		this.answer = answer;
		
	}
	

	@Override
	public String getAnswer1(){
		return this.answer;
		
	}
	
}
	


