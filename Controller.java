package id_318853256id_208421438;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
	
	private Model theModel;
	private View theView;
	private int number;
	private int counter=0;
	public Controller(Model m, View v) {
		theModel = m;
		theView = v;
		
		for (int i = 0; i < 10; i++) {
			theView.addEventHandlerToButton(i, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				if (arg0.getSource()==theView.getButton(1))
				{
					opsion1();
				}
				if (arg0.getSource()==theView.getButton(2))
					opsion2();
				if (arg0.getSource()==theView.getButton(3))
					opsion3();
				if (arg0.getSource()==theView.getButton(4))
					opsion4();
				if (arg0.getSource()==theView.getButton(5))
					opsion5();	
				if (arg0.getSource()==theView.getButton(7))
					opsion7();
				if (arg0.getSource()==theView.getButton(8))
					opsion8();
				if (arg0.getSource()==theView.getButton(6))
					tryComoBox();
				if (arg0.getSource()==theView.getButton(9))
					opsion9();
				if (arg0.getSource()==theView.getButton(10))
					opsion10();
				
				}
				
			});
		}
		
	}
	protected void tryComoBox() {
		theView.Make_Window_Select_Number_Question_To_Make_Noraml_Test();
		theView.addEventHandlerToNumber_Of_Question_Normal_testSubmit(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getSource() == theView.getNumber_Of_Question_Normal_testSubmit())
				{
					
					try {
						int NumberOfQuestions = Integer.parseInt(theView.getNumber_question_NORMAL_testTextField().getText());
						Group p  =theView.GroupComoBox(NumberOfQuestions , theModel.getNumberOfQuestionInTHeData() ,theModel.getAllQuestion() , theModel.getAllAmericanAnswers());
						theView.make_Window_Choise_Questions_Normal_Test(p);
						theView.addEventHandlerToMake_test_Normal_testSubmi(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent arg0) {
								ArrayList<Questions> arr = theView.getArrQuestions();
								ArrayList<Integer> numbers  = new ArrayList<>();
								for (int i = 0; i < arr.size(); i++) {
									numbers.add((i+1));
								}
								for (int i = 0; i < arr.size(); i++) {
									arr.get(i).setNumques((numbers.get(i)));
									if (arr.get(i).getType()=='A')
									{
										ArrayList<AmericanAnswers> p =arr.get(i).getAnswers();
										for (int j = 0; j < p.size(); j++) {
											p.get(i-1).setSerialnumber((j+1));
										}
										arr.get(i).setAnswers(p);
									}
								}
								String g =theModel.MakeNewNormalTest(arr);
								theView.opsion1(g);
							}
						
						});
					}
					catch (NumberFormatException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
				   }
				}
			}
		});
	}
	protected void opsion10() {
		String g = theModel.getAmericanAnswersToString();
		theView.opsion1(g);
		
	}
	protected void opsion9() {
		String g = theModel.SortAnswers();
		theView.opsion1(g);
		
	}
	public void Make_american_Question_SELECTIONT_Window_on_Noraml_Test(int i) {
		ArrayList<AmericanAnswers> arr = new ArrayList<>();
		
		
	}

	public  void opsion8() {
		theView.Make_Window_Select_test_to_clone();
		theView.addEventHandlerToButton_Clone_Number_Of_TestSubmit(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getSource() == theView.getClone_Number_Of_TestSubmit())
				{
					try {
						int Number_Test_To_Clone = Integer.parseInt(theView.getClone_Number_Of_TestTextField().getText());
						System.out.println(Number_Test_To_Clone);
						String g =theModel.cloneTheTest(Number_Test_To_Clone);
						theView.opsion1(g);
						
					} catch (NumberFormatException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
					} catch (Exception e) {
						theView.ShowEroorWindowNumberIsOutOfRangeCloneATest();
					}
				}
				
			}
			
		});
		
	}

	public void opsion7() {
		theView.MakeWindowAutoTest();
		theView.addEventHandlerToButton_Submit_Auto_Questions_Number(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getSource()== theView.getButtonSubmitNumberQuestion_Auto_Test())
				{
					try {
						int number_Of_Questions_auto_test = Integer.parseInt(theView.getNew_number_questions_Auto_Test().getText());
						
						String g = theModel.Make_Auto_test(number_Of_Questions_auto_test);
						theView.opsion1(g);
						
					} catch (NumberFormatException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
					}
				}
				
				}
		});
	
	}

	public void opsion5() {
		theView.MakeWindowDeletAnAnswer();
		theView.addEventHandlerToButtonDeletAnswerSubmit(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getSource()== theView.getButtonSubmitNumberAnswertoDeletSubmit())
				{
					try {
						int Number_Question_to_Delet_answer = Integer.parseInt(theView.getNewNumberQuestionTo_Delet_AnswerTextField().getText())-1;
						int Number_answer_to_Delet = Integer.parseInt(theView.getNewNumberAnswerTo_Delet_TextField().getText())-1;
						System.out.println(Number_answer_to_Delet+ "  "+Number_Question_to_Delet_answer);
						theModel.Delet_The_Answer (Number_Question_to_Delet_answer , Number_answer_to_Delet);
						opsion1();
					} catch (NumberFormatException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
					}
					 catch (Exception e) {
						 theView.ShowEroorWindowNumberIsOutOfRange();
						}
				}
			}
			});
			
	}

	public void opsion4() {
		theView.MakeWindowUpdateAnAnswer();
		theView.addEventHandlerToButtonUpdateAnswerSubmit(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getSource()== theView.getButtonSubmitNewAnswerTextSubmit())
				{
					try {
						int numQuestionChangeAnswer = Integer.parseInt(theView.getNewNumberQuestionUpdatAnswerUpdateTextField().getText())-1;
						String NewAnswer = theView.getNewQuestionTextTextField().getText();
						int numberAnswerAmerican  = Integer.parseInt(theView.getNewNumberAnswerUpdatAnswerUpdateTextField().getText());
						theModel.changeAnswer(NewAnswer , numQuestionChangeAnswer , numberAnswerAmerican);
						opsion1();
						} catch (NumberFormatException e) {
							theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
						}
						catch (Exception e) {

							 theView.ShowEroorWindowNumberIsOutOfRange();
						}
				}
				}
				});
		
	}

	public void opsion3() {
		theView.MakeWindowForNewNumberQuestionUpdata();
		theView.addEventHandlerToButtonUpdateQuestion(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getSource()== theView.getButtonSubmitNewQuestionTextSubmit())
				{
					try {
						int NumberQuestion = Integer.parseInt(theView.getNewNumberQuestionUpdatTextField().getText());
						theModel.CheckNumberQuestionToUpdate(NumberQuestion);
						String newText   = theView.getNewQuestionTextTextField().getText();
						
						boolean u =theModel.UpdateQuestionText(NumberQuestion , newText);
						if (u=true)
							opsion1();
						else
							theView.ShowEroorWindowTheQuestionIsExistIntheData();
						
					} catch (NumberFormatException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
					}
					 catch (Exception e) {
						 theView.ShowEroorWindowNumberIsOutOfRange();	
						}
				}
				
			}
			
		});
		
	}

	public void opsion2()
	{
		theView.Makeopsion2Screen();
		
		for (int i = 0; i < 2; i++) {
			theView.addEventHandlerToButtonOP2(i, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent op2) {
				if (op2.getSource()==theView.getButtonOP2(1))
				{
					MakeNewAmericanQuestion();
				}
				if (op2.getSource()==theView.getButtonOP2(2))
					MakeNewOpenQuestion();
					
				}
				
			});
		}
		
	}
	public void MakeNewOpenQuestion() {
		theView.NewOpenQuestionScreen();
		theView.addEventHandlerToButtonAddNewQuestion(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent st3) {
				if (st3.getSource()==theView.getaddNewOpenQuestionbutton())
				{
					try {
						String answer = theView.getNewOpenQuestionTextField('A').getText();
						String Question = theView.getNewOpenQuestionTextField('q').getText();
						if (answer ==""|| Question=="")
							throw new NullPointerException();
						theModel.AddNewOpenQuestion(Question, answer);
						opsion1();
					} catch (NullPointerException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
					}
					
				}
				
			}
			
		});
			
		
		
	}

	public void MakeNewAmericanQuestion() {
		theView.NewAmericanQuestionScreen();
		theView.addEventHandlerToButtonSubmitNumberOfAmericanAnswer(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent NumberAmericanAnswersSelect) {
				if (NumberAmericanAnswersSelect.getSource()==theView.getSubmitNumberOfAmericanAnswers())
				{
					String QuestionItSELF  = theView.getTheQuesionOfAmericanAnswersTextField().getText();
					ArrayList<AmericanAnswers> arr = new ArrayList<>();
					Group all = new Group();
					try {int NumberAmericanAnswers = Integer.parseInt (theView.getNumberOfAmericanAnswersTextField().getText());
					for (int i = 0; i < NumberAmericanAnswers; i++) {
						Group w = theView.makeGroupOfAmericanAnswer(i+1);
						all.getChildren().add(w);
					}
					theView.MakeWindowNewAmericanQuestion(all);
					theView.addEventHandlerToButtonSubmitNewAmericanAnswers(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent AmericanAnswerMaker) {
							if (AmericanAnswerMaker.getSource()==theView.getSubmitNewAmericanAnswers())
							{
								
								ArrayList<TextField> TheAnswers = theView.getAnswers();
								ArrayList<ChoiceBox<Boolean>> TheAnswersTrueFlase = theView.getTrueFalseAmericanAnswers();
								try {
									for (int i = 0; i < NumberAmericanAnswers; i++) {
										String Answer = TheAnswers.get(i).getText();
										if (Answer ==null || Answer =="")
											throw new NullPointerException();
										boolean TrueFalse  = TheAnswersTrueFlase.get(i).getValue();
										AmericanAnswers w = new AmericanAnswers((i+1), Answer, TrueFalse);
										arr.add(w);
									}
									theModel.AddNewAmericanAnswer(arr , QuestionItSELF);
									opsion1();
								} catch (NullPointerException e) {
									theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
								}
							
								
								}
								
				
								}							
						}
					);	
					} catch (NumberFormatException e) {
						theView.ShowEroorWindowNumberAmericanAnswerIsNotEnter();
					}
					
						
					
					
				}
				
			}
			
		});
		
		
	}

	public void opsion1()
	{
		String str = theModel.Opsion1();
		theView.opsion1(str);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

		
	
	
	}
