package id_318853256id_208421438;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

public abstract class  Questions implements Serializable, Cloneable {
	private int numques;
	private String Question;
	private char Type;
	public abstract int AnswerLenght();
	public abstract boolean changeanswer(String answer , int numberOfAmericanAnswer , boolean iscorrect);
	@Override
	public boolean	equals(Object other)
	{
		if (other.getClass().equals(this.getClass()))
		{	
			Questions temp = (Questions)other;
			boolean isSameText  = this.Question.equals(temp.Question);
			boolean isSameType  = this.Type==temp.Type;
			if (this.Question ==null || temp.Question ==null)
				return false;
			if (isSameText==true && isSameType==true)
				return true;
			return false;
		}
		return false;
	}
	
	public Questions (int num, String Question,char r)
	{
		this.numques = num;
		this.Question = Question;
		this .Type = r;
		
	}

	public int getNumques() {
		return numques;
	}

	public void setNumques(int numques) {
		this.numques = numques;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}
	@Override
	public abstract String toString(); 

	public char getType() {
		return Type;
	}

	public abstract boolean addAnswerAuto(AmericanAnswers a);

	public abstract void DeletAnswer(int num) ;
	public abstract ArrayList<AmericanAnswers> getAnswers();
	public abstract void setAnswers(ArrayList<AmericanAnswers> answers);
	public abstract void addAnswerAmerican(AmericanAnswers a) ;
	public abstract String toStringWithoutAnswers();
	public abstract String toStringWithAnswers();
	public abstract void AddAnswerOpen(String answer);
	public abstract String getAnswer();
	public abstract String getAnswer1();


	

	
	
	

}
