package id_318853256id_208421438;

import java.util.Scanner;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDateTime; 
import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter; 

public class main  {
	public static  String Exam_file_Without_Answers ="Exam    "+Date()+"   ";
	public static  String Exam_file_With_Answers ="Solution   "+Date()+"   ";
	public static final String Array_file__Question_Data = "ArrayList_Question";
	public static final String Array_file__American_Answers_Data = "ArrayList_American_Answers";
	public static final String ArrayLisr_file_Tests = "ArrayList_Tests";

	
	public static void checkRangeCases(ArrayList<String> g , int num) throws Exception
	{
		if (num>g.size())
			throw new Exception();
	}

	public static ArrayList<Questions> sortQuestionInTHeDataByAnswerLenght(DataQuestionsAndAnswers data)
	{
		ArrayList <Questions>newArr = new ArrayList<>();
		ArrayList <Integer> numbers = new ArrayList<>();
		ArrayList <Questions> Questions = data.getAllQuestions();
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
		}
		 return newArr;
		
	}
	public static Test CloneATest(ArrayList<Test> allTests ) throws Exception
	{
		if (allTests.size()==0)
			throw new Exception();
		System.out.println("enter the number of a test you want to clone , if you want to clone the resent test you enter press 0");
		int numOfTest = 0;
		Scanner input=new Scanner(System.in);
		boolean flagoutOfRangeClone =true;
		Test f = null;
		do {
			try {
				numOfTest  = Integer.parseInt(input.nextLine());
				
				checkRangeOfTestNumber(allTests, numOfTest);
				flagoutOfRangeClone = false;
				
			}
			catch (NumberFormatException ed)
			{
				System.out.println("the input is not a number...");
			}
			catch (Exception e) {
				System.out.println("the number is out of range...");
			}
			
		} while (flagoutOfRangeClone);
	
		numOfTest = numOfTest-1;
		if (numOfTest==-1) {
			try {
				f = allTests.get(allTests.size()-1).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				f = allTests.get(numOfTest).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

		}
		return f;
		
		
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
		String st = a.showWithAnswers();
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
		String st = a.showWithoutAnswer();
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


	
	
	public static int premenu()
	{
		Scanner input = new  Scanner (System.in);
		System.out.println("--------------------");
		System.out.println("*******************");
		System.out.println("---MENU for making the test---");
		System.out.println("Welcome enter your Choise:");
		System.out.println("for case 1.1 - show all the Question and Answers in the data press 1 ");
		System.out.println("for case 2.1- add an question to the data press 2");
		System.out.println("for case 3.1 - update a text of a question press 3");
		System.out.println("for case 4.1 - update a text of an answer press 4 ");
		System.out.println("for case 5.1 - to delet an answer from the data press 5");
		System.out.println("for case 6.1- make a test press 6");
		System.out.println("for case 7.1 - make an auto test press 7");
		System.out.println("for case 4.2  - clone a Test from a test you have done  press 8");
		System.out.println("for case 3.2  - sort the Questions in the lenght of the answer press 9");
		System.out.println("to see all the american answers in the data press 10");
		System.out.println("remove a object 11");
		System.out.println("For ending the code and SAVING THE DATA OF THE QUESTIONS and THE AMERICAN ANSWERS press 0");
		System.out.println("*******************");
		System.out.println("--------------------");
		boolean flag = true;
		int num =0;
		do {
			try {
				num  = Integer.parseInt(input.nextLine());
				flag = false;
			} catch (NumberFormatException e) {
				System.out.println("the input is not a number....");
				
			}
			
		} while (flag);
		return num;

	}
	
	
	// menu checkpoint//
	public static void main(String[] args) {
		

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
		int num = premenu();
		while (num!=0)
		{
			switch (num) {
			case 1:
				System.out.println(data.toString());
				num = premenu();
				break;
			case 2:
				Questions newQuestion;
				ArrayList <AmericanAnswers> arr  = new ArrayList<>();
					System.out.println("Enter the type of Question you want, for an american question (molti choise question ) press 1 , for an open Question press 2");
					int choise = 0;
					boolean flag   = true;
					boolean flagTwich =false;
					do {
						
					try {
						choise = Integer.parseInt(input.nextLine());
						 checkNumberAddQuestion(choise);
						flag = false;
					}
						
					catch (NumberFormatException ed)
					{
						System.out.println("the input is not a number...");
					}
					catch (IllegalArgumentException ed) {
						System.out.println("The input is out of range...");
					}
					
					} while (flag);
				
					System.out.println("Eneter the question:");
					String str  = input.nextLine();
					
					do {
						if (choise == 1)
						{
						
							
							System.out.println("Enter the number of american Answers (up to 10):");
							boolean illegakrangeAmericanAnswer  = true;
							int numOfAmericanANswers = 0;
							do {
								
								try {
									numOfAmericanANswers = Integer.parseInt(input.nextLine());
									numOfAmericanANswers =checkrangeNumberOfAmericanAnswer(numOfAmericanANswers);
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
							
							boolean flagForTrueFalse = true;
							boolean TrueFalse;
							for (int i = 0; i < numOfAmericanANswers; i++) {
								System.out.println("Eneter the text for answer number "+(i+1));
								String text =input.nextLine();
								System.out.println("enter 1 if the answer is true , 2 for false");
								int choiseTF = 0 ;
								do {
									
									try {
										choiseTF  = Integer.parseInt(input.nextLine());
										 checkNumberAddQuestion(choise);
										 flagForTrueFalse = false;
									}
										
									catch (NumberFormatException ed)
									{
										System.out.println("the input is not a number...");
									}
									catch (IllegalArgumentException ed) {
										System.out.println("The input is out of range...");
									}
									
									} while (flagForTrueFalse);
								if(choiseTF ==1)
									TrueFalse = true;
								else
									TrueFalse = false;
								AmericanAnswers	newAnswer2  = new AmericanAnswers(i+1, text,TrueFalse);
								arr.add(newAnswer2);
							}
							 newQuestion = new AmericanQuestions(data.getAllQuestions().size()+1, str, 'A', arr);
						}
						else
						{
							System.out.println("Enter your answer:");
							String str3 = input.nextLine();
							 newQuestion = new OpenQuestions(data.getAllQuestions().size()+1, str, 'O', str3);
						}
						flagTwich = data.AddQuestion(newQuestion);
						
					} while (flagTwich==false);
					System.out.println("Question added !!");
					System.out.println("******************");
					try {
						ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
						outFile.writeObject(data.getAllQuestions());
						outFile.close();
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println(data.toString());
				num = premenu();
				break;
			case 3:
				boolean flagNotInTheArr = false;
				do {
				System.out.println("enter the number of question you want to update");
				boolean flagNumberQuestion =true ;
				int numberQuestionUpdate = 0;
						do {
							
							try {
								numberQuestionUpdate = Integer.parseInt(input.nextLine());
								numberQuestionUpdate = checkNumberToGetFromArrQuestionForNomalTest(numberQuestionUpdate, data.getAllQuestions());
								flagNumberQuestion = false;
							}
								
						catch (NumberFormatException r)
						{
							System.out.println("the input is not a number");
						}
						
						catch (IllegalArgumentException e) {
							System.out.println("The input is out of range...");
						}
						} while (flagNumberQuestion);
				System.out.println("enter the new text:");
				String text2 = input.nextLine();
				flagNotInTheArr = data.UpdateQuestionText(numberQuestionUpdate, text2);
					
					
				} while (flagNotInTheArr==false);
				try {
					ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
					outFile.writeObject(data.getAllQuestions());
					outFile.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(data.toString());
				num = premenu();
				break;
			case 4:
				boolean TrueFalse;
				boolean flagForTrueFalse = true;
				boolean flagOfTheAnswerIsOutOfRange = true;
				System.out.println("enter the number of question the answer you want to update");
				boolean flagNumberQuestion =true ;
				int numberQuestionUpdate = 0;
						do {
							
							
							try {
								numberQuestionUpdate = Integer.parseInt(input.nextLine());
								numberQuestionUpdate = checkNumberToGetFromArrQuestionForNomalTest(numberQuestionUpdate, data.getAllQuestions());
								flagNumberQuestion = false;
							}
								
						catch (NumberFormatException r)
						{
							System.out.println("the input is not a number");
						}
						
						catch (IllegalArgumentException e) {
							System.out.println("The input is out of range...");
						}
						} while (flagNumberQuestion);
						numberQuestionUpdate=numberQuestionUpdate-1;
						
				if (data.getAllQuestions().get(numberQuestionUpdate).getType()=='A')
				{
					System.out.println("get the number of american answer you want to update");
					int NumberOfAnswerToUpdate = 0;
					do {
						
						try {
							NumberOfAnswerToUpdate = Integer.parseInt(input.nextLine());
							checkOfChoiseOfAmericanAnswer(NumberOfAnswerToUpdate,data.getAllQuestions().get(NumberOfAnswerToUpdate).getAnswers());
							flagOfTheAnswerIsOutOfRange = false;
						}
						
						catch (NumberFormatException r)
						{
							System.out.println("the input is not a number");
						}
						
						catch (IllegalArgumentException e) {
							System.out.println("The input is out of range...");
						}
					} while (flagOfTheAnswerIsOutOfRange);
					
					System.out.println("Enter the new text of the answer:");
					String rt  =input.nextLine();
					System.out.println("enter 1 if the answer is true , 2 for false");
					int choiseTF = 0 ;
					do {
						
						try {
							choiseTF  = Integer.parseInt(input.nextLine());
							 checkNumberAddQuestion(choiseTF);
							 flagForTrueFalse = false;
						}
							
						catch (NumberFormatException ed)
						{
							System.out.println("the input is not a number...");
						}
						catch (IllegalArgumentException ed) {
							System.out.println("The input is out of range...");
						}
						
						} while (flagForTrueFalse);
					if(choiseTF ==1)
						TrueFalse = true;
					else
						TrueFalse = false;
					
					 data.changeAnswer(numberQuestionUpdate, NumberOfAnswerToUpdate, rt, TrueFalse);
					 AmericanAnswers j = new AmericanAnswers(NumberOfAnswerToUpdate, rt, TrueFalse);
					 try {
						 CollectionOfAllAmericanAnswers.add(j);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					
				}
				else
				{
					System.out.println("Enter the new text of the answer:");
					String rt  =input.nextLine();
					data.changeAnswer(numberQuestionUpdate, 0, rt, false);
				}
				System.out.println("Answer change!!!");
				System.out.println("        ");
				System.out.println("        ");
				System.out.println(data.toString());
				try {
					ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
					outFile.writeObject(data.getAllQuestions());
					outFile.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				num = premenu();
				break;
			case 5:
				boolean flagOfTheAnswerIsOutOfRange1 = true;
				System.out.println("enter the number of the Question you want to delet the answer:");
				boolean flagNumberQuestion1 =true ;
				int numberQuestionUpdate1 = 0;
						do {
							
							try {
								numberQuestionUpdate1 = Integer.parseInt(input.nextLine());
								numberQuestionUpdate1 = numberQuestionUpdate1-1;
								numberQuestionUpdate1 = checkNumberToGetFromArrQuestionForNomalTest(numberQuestionUpdate1, data.getAllQuestions());
								flagNumberQuestion1 = false;
							}
								
						catch (NumberFormatException r)
						{
							System.out.println("the input is not a number");
						}
						
						catch (IllegalArgumentException e) {
							System.out.println("The input is out of range...");
						}
						} while (flagNumberQuestion1);
						int deletTheAnswerNumber =0;
						if (data.getAllQuestions().get(numberQuestionUpdate1).getType()=='A')
						{
							System.out.println("enter the number of answer you want to change:");
							
							do {
								
								try {
									deletTheAnswerNumber = Integer.parseInt(input.nextLine());
									checkOfChoiseOfAmericanAnswer(deletTheAnswerNumber,data.getAllQuestions().get(numberQuestionUpdate1).getAnswers());
									flagOfTheAnswerIsOutOfRange1 = false;
								}
								
								catch (NumberFormatException r)
								{
									System.out.println("the input is not a number");
								}
								
								catch (IllegalArgumentException e) {
									System.out.println("The input is out of range...");
								}
							} while (flagOfTheAnswerIsOutOfRange1);
							AmericanAnswers f= data.getAllQuestions().get(numberQuestionUpdate1).getAnswers().get(deletTheAnswerNumber);
							try {
								CollectionOfAllAmericanAnswers.remove(f);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						
						data.DeletAnswer(numberQuestionUpdate1, deletTheAnswerNumber);
						System.out.println(data.toString());
						try {
							ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
							outFile.writeObject(data.getAllQuestions());
							outFile.close();
							
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
				
				num = premenu();
				break;
			case 6:
				NumberIdTest = NumberIdTest+1;
				System.out.println(NumberIdTest);
				System.out.println("enter the number of questions you want in the test:");
				boolean flagNormalNumber = true;
				int numOfQuestions = 1;
				do {
					
					try {
						numOfQuestions = Integer.parseInt(input.nextLine());
						flagNormalNumber = false;
						
					}catch (NumberFormatException ed)
					{
						System.out.println("the input is not a number...");
					}
				} while (flagNormalNumber);
				Test a = MakeNomalTest(data , numOfQuestions , NumberIdTest);
				all_Tests.add(a);
				System.out.println(a.toString());
				try {
					saveFile_With_Answers(a);
					System.out.println("save file with answers");
					System.out.println("    ");
					saveFile_Without_Answers(a);
					System.out.println("save file without answers");
					readFileWith_Answers(a);
					readFileWithout_Answers(a);
					
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}
				catch (IOException e) {
					System.out.println(e);
				}
				num = premenu();
				break;
			case 7:

				NumberIdTest  = NumberIdTest+1;
				System.out.println(NumberIdTest);
				System.out.println("enter the number of questions you want in the test:");
				boolean flagNormalNumber1 = true;
				int numOfQuestions1 = 1;
				do {
					
					try {
						numOfQuestions1 = Integer.parseInt(input.nextLine());
						flagNormalNumber1 = false;
						
					}catch (NumberFormatException ed)
					{
						System.out.println("the input is not a number...");
					}
				} while (flagNormalNumber1);
				Test ac = data.MakeNewAutoTest(numOfQuestions1  , NumberIdTest);
				all_Tests.add(ac);
				System.out.println(ac.toString());
				try {
					saveFile_Without_Answers(ac);
					saveFile_With_Answers(ac);
					readFileWith_Answers(ac);
					readFileWithout_Answers(ac);
					
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}
				catch (IOException e) {
					System.out.println(e);
				}
				
				num = premenu();
				break;
			case 8:
				Test g;
				try {
					g = CloneATest(all_Tests);

					g.setTestid(NumberIdTest+1);
					all_Tests.add(g);
					System.out.println(g.toString());
					try {
						saveFile_Without_Answers(g);
						saveFile_With_Answers(g);
						readFileWith_Answers(g);
						readFileWithout_Answers(g);
						
					} catch (FileNotFoundException e) {
						System.out.println(e);
					}
					catch (IOException e) {
						System.out.println(e);
					}
				} catch (Exception e11) {
					System.out.println("to use this application you need to make a test first make a new test and then come back :)");
				}
				num = premenu();
				break;
			case 9:
				ArrayList<Questions> j = new ArrayList<>();
				j = sortQuestionInTHeDataByAnswerLenght(data);
				num = premenu();
				break;
			case 10:
				System.out.println(data.getAllAnswerAmerican().toString());
				num = premenu();
				break;
			case 11:
				int num123  = input.nextInt();
				data.removeObject(num123);
			default:
				System.out.println("the number is out of range...");
				num = premenu();
				break;
			}
		}

		System.out.println("Saving the array Questions to the Computer");
		System.out.println("File Saved as "+Array_file__Question_Data);
		System.out.println("Saving the array of American Answers to the Computer");
		System.out.println("File Saved as "+Array_file__American_Answers_Data);
		
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__Question_Data));
			outFile.writeObject(data.getAllQuestions());
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(Array_file__American_Answers_Data));
			outFile.writeObject(data.getAllAnswerAmerican());
			outFile.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Save the array of Tests");
		System.out.println("File saved as "+ArrayLisr_file_Tests);
		try {
			ObjectOutputStream outFile =new ObjectOutputStream(new FileOutputStream(ArrayLisr_file_Tests));
			outFile.writeObject(all_Tests);
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("the end of the program");
	

	}





}
