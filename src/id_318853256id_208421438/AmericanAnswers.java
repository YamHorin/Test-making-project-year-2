package id_318853256id_208421438;

import java.io.Serializable;

public class AmericanAnswers implements Serializable , Cloneable ,MenuChange{
	private boolean isCorrect;
	private String Answer;
	private int serialnumber;
	public AmericanAnswers(int num , String f , boolean isCorrect) {
		this.Answer = f;
		this.isCorrect = isCorrect;
		this.serialnumber = num;

	}
	public String toStringWithoutAnswers ()
	{
		if (this.Answer!=null )
		{
			return "Anaswers number" +this.serialnumber +"\n"+this.Answer.toString();
		}
		return null;
	}
	@Override
	public String toString() {
		if (this.Answer!=null )
		{
			if (this.isCorrect ==true)
				return "Answer number: " +this.serialnumber +"\n"+this.Answer.toString()+"\n is CORRECT";
			else
			return "Answer number: " +this.serialnumber+"\n" +this.Answer.toString()+"\n is worng";
		}
		else
			return "Answer number" +this.serialnumber +"the answer has been DELETED";
	}
	@Override
	public boolean equals(Object other)
	{
		if (other.getClass().equals(this.getClass()))
		{
			AmericanAnswers temp = (AmericanAnswers)other;
			
			if (this.Answer.equalsIgnoreCase(temp.Answer)==true)
				return true;
		}
		return false;
		
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public int getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}
	

}
