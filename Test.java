package id_318853256id_208421438; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test implements Serializable , Cloneable{
private ArrayList<Questions> allQuestions;
private int numberQuestions;
private char Type;
private int Testid;



public void setTestid(int testid) {
	Testid = testid;
}
public Test clone() throws CloneNotSupportedException 
{
   return (Test)super.clone();
}
public char getType() {
	return Type;
}

public int getTestid() {
	return Testid;
}

public Test (ArrayList<Questions> allQuestions , int numberQuestions  , char HowTheTestWasMade , int Testid)
{
	
	this.allQuestions  = allQuestions;
	this.numberQuestions = numberQuestions;
	this.Type = HowTheTestWasMade;
	this.Testid = Testid;
}
	public String Get_abc_sort()
	{
		String g ="";
		ArrayList <Integer> numbers = new ArrayList<>();
		
		int num;
		for (Questions question : this.allQuestions) {
			num = question.AnswerLenght();
			numbers.add(num);
		}
		 Collections.sort(numbers);
		 for (int i = 0; i < numbers.size(); i++) {
			for (Questions question : this.allQuestions) {
				if (numbers.get(i)==question.AnswerLenght())
					g = "\n"+g+(question.toString())+"\n";
			}
		}
		return g; 
	}
@Override
public String toString() {
	ArrayList<String> allQu = new ArrayList<>();
	String g = "";
	for (Questions Question : allQuestions) {
		allQu.add(Question.getQuestion());
	}
	
	for (int i = 0; i < 5; i++) {
		System.out.println("**********************");
	}

	System.out.println("all the questions in the test after sort in the ABC:");

	Collections.sort(allQu);
	for (int i = 0; i < allQu.size(); i++) {
			
			System.out.println(allQu.get(i));
		
	}
	for (int i = 0; i < 5; i++) {
		System.out.println("**********************");
	}
	System.out.println("sort in answer lenght:");
	
	ArrayList <Integer> numbers = new ArrayList<>();
	
	int num;
	for (Questions question : this.allQuestions) {
		num = question.AnswerLenght();
		numbers.add(num);
	}
	 Collections.sort(numbers);
	 for (int i = 0; i < numbers.size(); i++) {
		for (Questions question : this.allQuestions) {
			if (numbers.get(i)==question.AnswerLenght())
				System.out.println(question.toString());
		}
	}
	 
		for (int i = 0; i < 5; i++) {
			System.out.println("**********************");
		}
	
	
	return " The Test has "+this.numberQuestions+"  Questions";
}

public String showWithoutAnswer()
{	String ad ="";
	ArrayList <String> theQuestionss = new ArrayList<>();
	for (Questions question : allQuestions) {
		theQuestionss.add(question.toStringWithoutAnswers());
	}
	for (String string : theQuestionss) {
		ad = ad+"\n"+string.toString()+"\n";
	}
	return ad;
}
public String showWithAnswers()
{	String ad = "";
	ArrayList <String> theQuestionss = new ArrayList<>();
	for (Questions question : allQuestions) {
		theQuestionss.add(question.toStringWithAnswers());
	}
	for (String string : theQuestionss) {
		ad = ad+"\n"+string.toString()+"\n";
	}
	return ad;
}
public ArrayList<Questions> getQuestions() {
	return this.allQuestions;
}


}
