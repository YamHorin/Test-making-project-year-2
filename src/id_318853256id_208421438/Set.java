package id_318853256id_208421438;

import java.io.Serializable;
import java.util.ArrayList;


public class Set <T extends AmericanAnswers> implements Serializable , Cloneable  {
private ArrayList<T> allAmericanAnswers;



public Set ()
{
	this.allAmericanAnswers = new ArrayList<>();
}

@Override
public String toString() {
	int num = 1;
	String e = "this is all american Questions \n ";
	for (AmericanAnswers americanAnswers : allAmericanAnswers) {
		e = e+"\n"+num+" "+americanAnswers.toString()+"\n"+"\n";
		num++;
	}
	return e;
}
public Set<T> clone() throws CloneNotSupportedException 
{
	return (Set)super.clone();
}

public void add (Object e) throws Exception
{
	try {
        allAmericanAnswers.add((T) e);
        
    } catch (ClassCastException ex) {
        throw new Exception("object was not added" +"\n"+"the object need to be American Answer");
    }
		
}

public void remove (Object e) throws Exception
{
	try {
		 if (allAmericanAnswers.remove((T)e)==false)
			 System.out.println("the object is not on the Set");
		 else
			 System.out.println("removed from set");
        
    } catch (ClassCastException ex) {
        throw new Exception("object was not removed" +"\n"+"the object need to be American Answer");
    }
}

public T get(int numberFromDataAmericanAnswerToChose2) {

	 return this.allAmericanAnswers.get(numberFromDataAmericanAnswerToChose2);
		
}

public ArrayList<T> getAllAmericanAnswers() {
	return allAmericanAnswers;
}

public void setAllAmericanAnswers(ArrayList<T> allAmericanAnswers) {
	this.allAmericanAnswers = allAmericanAnswers;
}



public boolean equals(Object other)
{
	boolean isAllTheSame  = true;
	if (other.getClass().equals(this.getClass()))
	{
		Set temp = (Set)other;
		for (int i = 0; i < temp.getAllAmericanAnswers().size(); i++) {
			for (AmericanAnswers americanAnswers : allAmericanAnswers) {
				if (americanAnswers.equals(temp.getAllAmericanAnswers().get(i))==true)
					isAllTheSame=true;
			}
			isAllTheSame=false;
		}
		return isAllTheSame;
	}
	return false;
	
}



}
