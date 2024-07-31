package id_318853256id_208421438;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Model {
	public static  String Exam_file_Without_Answers ="Exam    "+Date()+"   ";
	public static  String Exam_file_With_Answers ="Solution   "+Date()+"   ";
	public static final String Array_file__Question_Data = "ArrayList_Question";
	public static final String Array_file__American_Answers_Data = "ArrayList_American_Answers";
	public static final String ArrayLisr_file_Tests = "ArrayList_Tests";
	private DataQuestionsAndAnswers data;
	private ArrayList<Test> all_Tests;
	private ArrayList<Questions> arrQuestionsData;
	private Set<AmericanAnswers> CollectionOfAllAmericanAnswers;
	
	
	public Model ()
	{
		ArrayList<Test> all_Tests = new ArrayList<>();
		try {

		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(ArrayLisr_file_Tests));
		all_Tests  = (ArrayList<Test>)inFile.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		int NumberIdTest = all_Tests.size();

		Scanner input = new  Scanner (System.in);
		ArrayList<Questions> arrQuestionsData = new ArrayList<>();
		Set<AmericanAnswers> CollectionOfAllAmericanAnswers = new Set<>();
		try {

			ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(Array_file__Question_Data));
			arrQuestionsData  = (ArrayList<Questions>)inFile.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {

			ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(Array_file__American_Answers_Data));
			CollectionOfAllAmericanAnswers  = (Set<AmericanAnswers>)inFile.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	
		DataQuestionsAndAnswers data  = new DataQuestionsAndAnswers(arrQuestionsData , CollectionOfAllAmericanAnswers);
		this.data = data;
		this.all_Tests = all_Tests;
		this.CollectionOfAllAmericanAnswers =CollectionOfAllAmericanAnswers;
		this.arrQuestionsData   = arrQuestionsData;
	}

	
	public static void checkRangeCases(ArrayList<String> g , int num) throws Exception
	{
		if (num>g.size())
			throw new Exception();
	}

	public static String sortQuestionInTHeDataByAnswerLenght(ArrayList<Questions> arrayList)
	{
		String g = "";
		ArrayList <Questions>newArr = new ArrayList<>();
		ArrayList <Integer> numbers = new ArrayList<>();
		ArrayList <Questions> Questions =arrayList;
		int num;
		for (Questions question : Questions) {
			num = question.AnswerLenght();
			numbers.add(num);
		}
		 Collections.sort(numbers);
		 
		 for (int i = 0; i < numbers.size(); i++) {
			for (Questions question : Questions) {
				if (numbers.get(i)==question.AnswerLenght())
					newArr.add(question);
			}
		}
		 for (int i = 0; i < newArr.size(); i++) {
			System.out.println(newArr.get(i).toString());
			g = g+"\n"+newArr.get(i).toString()+"\n"+"\n";
		}
		 return g;
		 
		
	}
	public Test CloneATest(int num ) throws Exception
	{ 
		
		if (num > this.all_Tests.size() || this.all_Tests.size()==0)
			throw new Exception();
		Test clone_this;
		if (num==-1)
			clone_this = this.all_Tests.get(this.all_Tests.size()-1);
		else
			clone_this = this.all_Tests.get(num);
		Test f = clone_this.clone();
		return f;
		
		
	}
	
	public String Opsion1 ()
	{
		return this.data.toString();
	}

	
	public static void checkRangeOfTestNumber (ArrayList<Test> allTests , int num)throws Exception
	{
		if (num>allTests.size())
			throw new Exception();
	}
	
	public static void saveFile_With_Answers(Test a)throws IOException
	{
		System.out.println("  ");
		System.out.println("File of test saved as: "+Exam_file_With_Answers+a.getTestid()+"  "+a.getType());
		File f = new File (Exam_file_With_Answers+a.getTestid()+"  "+a.getType());
		PrintWriter pw  = new PrintWriter (f);
		String st = a.showWithAnswers()+"\n"+"All the question sort in answers lenght:"+"\n"+sortQuestionInTHeDataByAnswerLenght(a.getQuestions())+"\n"+"all questions sort in abc:"+a.Get_abc_sort();
		pw.println(st);
		pw.close();
		System.out.println("  ");
	}
	
	public static void saveFile_Without_Answers(Test a)throws IOException
	{
		System.out.println("  ");
		System.out.println("File of test saved as: "+Exam_file_Without_Answers+a.getTestid()+"  "+a.getType());
		File f = new File (Exam_file_Without_Answers+a.getTestid()+"  "+a.getType());
		PrintWriter pw  = new PrintWriter (f);
		String st = a.showWithAnswers()+"\n"+"All the question sort in answers lenght:"+"\n"+sortQuestionInTHeDataByAnswerLenght(a.getQuestions())+"\n"+"all questions sort in abc:"+a.Get_abc_sort();
		pw.println(st);
		pw.close();
		System.out.println("  ");
	}
	
	public static void readFileWithout_Answers(Test a)throws FileNotFoundException
	{
		System.out.println(" ");
		System.out.println("read from file: "+Exam_file_Without_Answers +a.getTestid()+"  "+a.getType());
		File f = new File (Exam_file_Without_Answers +a.getTestid()+"  "+a.getType());
		Scanner g = new Scanner(f);
		while (g.hasNext())
		{
			String s = g.nextLine();
			System.out.println(s);
		}
		g.close();
	}
	public static void readFileWith_Answers(Test a)throws FileNotFoundException
	{
		System.out.println(" ");
		System.out.println("read from file: "+Exam_file_With_Answers+a.getTestid()+"  "+a.getType());
		File f = new File (Exam_file_With_Answers+a.getTestid()+"  "+a.getType());
		Scanner g = new Scanner(f);
		while (g.hasNext())
		{
			String s = g.nextLine();
			System.out.println(s);
		}
		g.close();
	}
	
	public static String Date ()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_");  
		   LocalDateTime now = LocalDateTime.now();  
		   String w  = dtf.format(now);
		   return w;
	}
	public static void checkOfChoiseOfAmericanAnswer(int num ,ArrayList<AmericanAnswers> AmericanAnswers) throws IllegalArgumentException
	{
		if (num>AmericanAnswers.size())
			throw new IllegalArgumentException();
	}
	
	
	public static void checkNumberAddQuestion (int num)throws IllegalArgumentException
	{
		if (num==0 ||num>2)
			throw new IllegalArgumentException();
	}
	public static void checkIfTheQuestionIsNotINTHeTest(int num, ArrayList<Integer> numbersOfQuestions)throws Exception
	{
		for (Integer integer : numbersOfQuestions) {
			if (num == integer)
				throw new Exception();
		}
	}
	public static int checkrangeNumberOfAmericanAnswer(int num)throws IllegalArgumentException
	{
		if (num < 0 || num > 10)
			throw new IllegalArgumentException();
		return num;
	}
	
	public static int checkrangeAmericanAnswerNomalTest(int num, Set<AmericanAnswers> americanAnswers) throws IllegalArgumentException
	{
		if (num < 0 || num > americanAnswers.getAllAmericanAnswers().size())
			throw new IllegalArgumentException();
		return num;
	}
	public static int checkNumberToGetFromArrQuestionForNomalTest(int num, ArrayList<Questions> allQuestions) throws IllegalArgumentException
	{
		if (num < 0 || num > allQuestions.size())
			throw new IllegalArgumentException();
		return num;
	}
	public static Test MakeNomalTest(DataQuestionsAndAnswers y , int numberOfQuestionNormalTest ,int NumberIdTest)
	{
		ArrayList<AmericanAnswers> americanAnswersDelet  = new ArrayList<>();
		Set<AmericanAnswers> americanAnswersBackUp = null;
		try {
			americanAnswersBackUp = (Set<AmericanAnswers>) y.getAllAnswerAmerican().clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		ArrayList<Questions> AllQuestionsBackUp  = null;
		try {

			ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(Array_file__Question_Data));
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
		ArrayList<Integer> numbersOfQuestionForTheTest  =  new ArrayList<>(); 
		ArrayList<Questions> QuestionForTheTest  =  new ArrayList<>(); 
		ArrayList<Questions> allQuestions  = y.getAllQuestions();
		Set<AmericanAnswers> AmericanAnswers = y.getAllAnswerAmerican();
		Scanner input = new  Scanner (System.in);
		ArrayList<AmericanAnswers> americanAnswerstoDelet =  new ArrayList<>();
		ArrayList<AmericanAnswers> americanAnswer =  new ArrayList<>();
		for (Questions a : allQuestions) {
			if (a.getType()=='A')
			{
				americanAnswersDelet = a.getAnswers();
				americanAnswersDelet.clear();
				a.setAnswers(americanAnswerstoDelet);
			}
		}
		// get the data from the user//

		for (int i = 0; i < numberOfQuestionNormalTest; i++) {
			boolean illegalrangeQuestion=true;
			boolean illegakrangeAmericanAnswer=true;
			boolean illegalNumberAmericanAnswers = true;
			System.out.println("Enter the number of question  "+ (i+1) +"  you want in the test");
			int numberQuestionHasBeanChose = 0;
			do {
				
				try {
					numberQuestionHasBeanChose  = Integer.parseInt(input.nextLine());
					numberQuestionHasBeanChose = checkNumberToGetFromArrQuestionForNomalTest(numberQuestionHasBeanChose, allQuestions);
					checkIfTheQuestionIsNotINTHeTest(numberQuestionHasBeanChose, numbersOfQuestionForTheTest);
					illegalrangeQuestion = false;
				}
				catch (NumberFormatException r)
				{
					System.out.println("the input is not a number");
				}
				
				catch (IllegalArgumentException e) {
					System.out.println("The input is out of range...");
				}
				catch (Exception m)
				{
					System.out.println("the input is already in the test.");
				}
				 
			} while (illegalrangeQuestion);
			allQuestions.get(numberQuestionHasBeanChose-1).setNumques(i+1);
			if (allQuestions.get(numberQuestionHasBeanChose-1).getType()=='A')
			{
				System.out.println("enter how many american answers you want (up to 10)");
				int numOfAmericanAnswers = 0 ;
				
				do {
					
					try {
						numOfAmericanAnswers = Integer.parseInt(input.nextLine());
						numOfAmericanAnswers =checkrangeNumberOfAmericanAnswer(numOfAmericanAnswers);
						illegakrangeAmericanAnswer = false;
						
					}
					catch (NumberFormatException rg)
					{
						System.out.println("the input is not a number");
					}
					catch (IllegalArgumentException e) {
						System.out.println("the number is out of range...");
					}
					
				} while (illegakrangeAmericanAnswer);
				for (int j = 0; j < numOfAmericanAnswers; j++) {
					
					System.out.println("Enter the number of the american answer you want to be in the american question:");
					int numberOfAmericanAnswerChosen = 0;
					do {
						
						try {
							numberOfAmericanAnswerChosen= Integer.parseInt(input.nextLine());
							numberOfAmericanAnswerChosen =checkrangeAmericanAnswerNomalTest(numberOfAmericanAnswerChosen, AmericanAnswers);
							illegakrangeAmericanAnswer = false;
						}
					catch (NumberFormatException rg)
					{
						System.out.println("the input is not a number");
					}
					catch (IllegalArgumentException eg) {
						System.out.println("The input is out of range...");
					}
					} while (illegakrangeAmericanAnswer);
					// add the answer to the american question
					AmericanAnswers.get(numberOfAmericanAnswerChosen).setSerialnumber(j+1);
					allQuestions.get(numberQuestionHasBeanChose-1).addAnswerAmerican(AmericanAnswers.get(numberOfAmericanAnswerChosen));
				}
				
				
			}
			Questions temp  =allQuestions.get(numberQuestionHasBeanChose-1);
			QuestionForTheTest.add(temp);
			System.out.println("Question has been added!");
			 numbersOfQuestionForTheTest.add(numberQuestionHasBeanChose);
		}
		
		Test ab = new Test(QuestionForTheTest,numberOfQuestionNormalTest  ,'N', numberOfQuestionNormalTest);
		try {
			saveFile_Without_Answers(ab);
			saveFile_With_Answers(ab);
			readFileWith_Answers(ab);
			readFileWithout_Answers(ab);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		y.setAllQuestions(AllQuestionsBackUp);
		y.setAllAnswerAmerican(americanAnswersBackUp);
		return ab;
		}


	public void AddNewOpenQuestion(String question, String answer) {
		Questions newQuestion;
		newQuestion = new OpenQuestions(this.data.getAllQuestions().size()+1, question, 'O', answer);
		this.data.AddQuestion(newQuestion);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
			outFile.writeObject(this.data.getAllQuestions());
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	public void AddNewAmericanAnswer(ArrayList<AmericanAnswers> arr, String questionItSELF) {
		Questions newQuestion;
		newQuestion = new AmericanQuestions(this.data.getAllQuestions().size()+1, questionItSELF, 'A', arr);
		this.data.AddQuestion(newQuestion);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
			outFile.writeObject(this.data.getAllQuestions());
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void CheckNumberQuestionToUpdate (int num) throws Exception
	{
		if (num >this.data.getAllQuestions().size() )
			throw new Exception();
	}


	public boolean UpdateQuestionText(int numberQuestion, String newText) {
		return this.data.UpdateQuestionText(numberQuestion, newText);
		
	}


	public void changeAnswer(String newAnswer, int numQuestionChangeAnswer, int numberAnswerAmerican) throws Exception{
		if (numQuestionChangeAnswer > this.data.getAllQuestions().size())
			throw new Exception();
		if (this.data.getAllQuestions().get(numQuestionChangeAnswer).getType()=='A')
		{
			if (numberAnswerAmerican> this.data.getAllQuestions().get(numQuestionChangeAnswer).getAnswers().size())
				throw new Exception();
			else
			{
				this.data.changeAnswer(numQuestionChangeAnswer, numberAnswerAmerican, newAnswer, false);
			}
		}
		this.data.changeAnswer(numQuestionChangeAnswer, numberAnswerAmerican, newAnswer, false);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
			outFile.writeObject(this.data.getAllQuestions());
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public void Delet_The_Answer(int number_Question_to_Delet_answer, int number_answer_to_Delet) throws Exception {
		// TODO Auto-generated method stub
		if (number_Question_to_Delet_answer > this.data.getAllQuestions().size())
			throw new Exception();
		if (this.data.getAllQuestions().get(number_Question_to_Delet_answer).getClass().getSimpleName()=="AmericanQuestions")
		{
			if (number_answer_to_Delet> this.data.getAllQuestions().get(number_Question_to_Delet_answer).getAnswers().size())
				throw new Exception();
		}
		this.data.DeletAnswer(number_Question_to_Delet_answer, number_answer_to_Delet);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
			outFile.writeObject(this.data.getAllQuestions());
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String Make_Auto_test(int number_Of_Questions_auto_test) {
		String g = "";
		Test f = this.data.MakeNewAutoTest(number_Of_Questions_auto_test,(this.all_Tests.size()+1));
		this.all_Tests.add(f);
		try {
			saveFile_With_Answers(f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		g = g+"File of test saved as: "+Exam_file_Without_Answers+f.getTestid()+"  "+f.getType()+"\n"+f.showWithoutAnswer();
		try {
			saveFile_Without_Answers(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g ="\n"+g+"File of test saved as: "+Exam_file_With_Answers+ f.getTestid()+"  "+f.getType()+"\n"+f.showWithAnswers();
		g = g+"\n"+"All the question sort in answers lenght:"+"\n"+sortQuestionInTHeDataByAnswerLenght(f.getQuestions());
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(ArrayLisr_file_Tests));
			outFile.writeObject(this.all_Tests);
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}


	public String cloneTheTest(int number_Test_To_Clone) throws Exception {
		Test f = CloneATest(number_Test_To_Clone);
		String g = "";
		f.setTestid((this.all_Tests.size()+1));
		this.all_Tests.add(f);
		try {
			saveFile_With_Answers(f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		g = g+"File of test saved as: "+Exam_file_Without_Answers+f.getTestid()+"  "+f.getType()+"\n"+f.showWithoutAnswer();
		try {
			saveFile_Without_Answers(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g ="\n"+g+"File of test saved as: "+Exam_file_With_Answers+ f.getTestid()+"  "+f.getType()+"\n"+f.showWithAnswers();
		g = g+"\n"+"All the question sort in answers lenght:"+"\n"+sortQuestionInTHeDataByAnswerLenght(f.getQuestions());
		System.out.println("File saved as "+ArrayLisr_file_Tests);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(ArrayLisr_file_Tests));
			outFile.writeObject(this.all_Tests);
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
		
		
	}

	public int getNumberOfQuestionInTHeData() {
		return this.data.getAllQuestions().size();
	}


	public Questions getQuestion(int value) {
		
		Questions r = this.data.getAllQuestions().get(value);
		return r;
		
	}


	public int getNumberOfAmericanAnswers() {
		return this.CollectionOfAllAmericanAnswers.getAllAmericanAnswers().size();
	}


	public AmericanAnswers getAmericanAnswer(int NumberAmericanAnswer) {
		return this.data.getAllAnswerAmerican().get(NumberAmericanAnswer);
	}


	public String SortAnswers() {
		return sortQuestionInTHeDataByAnswerLenght(this.data.getAllQuestions());
	}


	public String getAmericanAnswersToString() {
		return this.data.getAllAnswerAmerican().toString();
	}


	public String MakeNewNormalTest(ArrayList<Questions> arr_for_new_test) {
		
		Test f = new Test( arr_for_new_test, arr_for_new_test.size(), 'N', (this.all_Tests.size()+1));
		this.all_Tests.add(f);
		String g = "";
		try {
			saveFile_With_Answers(f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		g = g+"File of test saved as: "+Exam_file_Without_Answers+f.getTestid()+"  "+f.getType()+"\n"+f.showWithoutAnswer();
		try {
			saveFile_Without_Answers(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g ="\n"+g+"File of test saved as: "+Exam_file_With_Answers+ f.getTestid()+"  "+f.getType()+"\n"+f.showWithAnswers();
		g = g+"\n"+"All the question sort in answers lenght:"+"\n"+sortQuestionInTHeDataByAnswerLenght(f.getQuestions());
		System.out.println("File saved as "+ArrayLisr_file_Tests);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(ArrayLisr_file_Tests));
			outFile.writeObject(this.all_Tests);
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}


	public ArrayList<Questions> getAllQuestion() {
		return data.getAllQuestions();
	}


	public Set<AmericanAnswers> getAllAmericanAnswers() {
		return this.data.getAllAnswerAmerican();
	}


	
	
		
	}



