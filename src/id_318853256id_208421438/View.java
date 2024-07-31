package id_318853256id_208421438;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javafx.event.*;
import javafx.scene.input.*;

public class View {
	private ArrayList<Questions> arr_for_Normal_test;
	public Button [] op;
	public Button [] op2;
	public Button addNewOpenQuestion;
	private Button SubmitNewAmericanAnswers;
	private TextField [] NewOpenQuestion;
	private TextField NumberOfAmericanAnswersTextField;
	private TextField TheQuesionOfAmericanAnswersTextField;
	private Button SubmitNumberOfAmericanAnswers;
	private ArrayList<TextField> Answers;
	private ArrayList <ChoiceBox<Boolean>> TrueFalseAmericanAnswers;
	private TextField QuestionOfNewAmericanQuestionTextField;
	private TextField NewNumberQuestionUpdatTextField;
	private TextField NewQuestionTextTextField;
	private Button ButtonSubmitNewQuestionTextSubmit;
	private TextField NewNumberQuestionUpdatAnswerUpdateTextField;
	private Button ButtonSubmitNewAnswerTextSubmit;
	private TextField NewNumberAnswerUpdatAnswerUpdateTextField;
	private Button ButtonSubmitNumberAnswertoDeletSubmit;
	private TextField NewNumberAnswerTo_Delet_TextField;
	private TextField NewNumberQuestionTo_Delet_AnswerTextField;
	private Button ButtonSubmit_Number_Questions_auto_Test;
	private TextField New_number_questions_Auto_Test;
	private TextField Clone_Number_Of_TestTextField;
	private Button Clone_Number_Of_TestSubmit;
	private ArrayList <ChoiceBox<Integer>> Choises_Question_for_test_array;
	private TextField Number_question_NORMAL_testTextField;
	private Button Number_Of_Question_Normal_testSubmit;
	private Button Make_test_Normal_testSubmit;
	private ArrayList<Button> Submit_American_Answers_to_American_Questions;
	private ArrayList<Button> Number_American_answer_to_question_i;
	private ArrayList <TextField> Number_American_answer_to_question_i_Text_Field;
	private ArrayList<ArrayList <ChoiceBox<Integer>>> Current_Choises_American_Answers_For_Question_i;
	private Stage CurrentStage;
	private Button CurrentStageButton;
	private TextField CurrenTextField;
	private ArrayList ComboBoxArr;
	private ArrayList <Integer> NUmberOfQuestions_normal_Test;
	private int PlaceButton=300;
	
	public Button getButtonSubmitNumberAnswertoDeletSubmit() {
		return ButtonSubmitNumberAnswertoDeletSubmit;
	}
	//main window:
	public View (Stage primaryStage)
	{
		NUmberOfQuestions_normal_Test = new ArrayList<>();
		Submit_American_Answers_to_American_Questions= new ArrayList<>();
		Current_Choises_American_Answers_For_Question_i =new ArrayList<>();
		this.Number_American_answer_to_question_i = new ArrayList<>();
		this.Number_American_answer_to_question_i_Text_Field = new ArrayList<>();
		this.Answers =new ArrayList<>();
		this.TrueFalseAmericanAnswers = new ArrayList<>();
		Text text  = new Text ();
		text.setText("Welcome to Test Maker program");
		text.setY(50);
		text.setX(130);
		text.setFont(Font.font("Verdara", 30));
		Text select  = new Text();
		select.setText("please select you options:");
		select.setY(100);
		select.setX(130);
		select.setFont(Font.font("Verdara", 20));
		Button op1 = new Button("for case 1.1 - show all the Question and Answers in the data press 1");
		Button op2 = new Button("for case 2.1- add an question to the data press 2");
		Button op3 = new Button("for case 3.1 - update a text of a question press 3");
		Button op4 = new Button("for case 4.1 - update a text of an answer press 4 ");
		Button op5 = new Button("for case 5.1 - to delet an answer from the data press 5");
		Button op6 = new Button("for case 6.1- make a test press 6");
		Button op7 = new Button("for case 7.1 - make an auto test press 7");
		Button op8 = new Button("for case 4.2  - clone a Test from a test you have done  press 8");
		Button op9 = new Button("for case 3.2  - sort the Questions in the lenght of the answer press 9");
		Button op10 = new Button("to see all the american answers in the data press 10");
		Group root  = new Group();
		op1.setMinSize(50, 30);
		op1.setLayoutX(130);
		op1.setLayoutY(150);
		op2.setLayoutX(130);
		op2.setLayoutY(190);
		op3.setLayoutX(130);
		op3.setLayoutY(230);
		op4.setLayoutX(130);
		op4.setLayoutY(270);
		op5.setLayoutX(130);
		op5.setLayoutY(310);
		op6.setLayoutX(130);
		op6.setLayoutY(350);
		op7.setLayoutX(130);
		op7.setLayoutY(390);
		op8.setLayoutX(130);
		op8.setLayoutY(430);
		op9.setLayoutX(130);
		op9.setLayoutY(470);
		op10.setLayoutX(130);
		op10.setLayoutY(510);
		this.op = new Button[10];
		op[0]  = op1;
		op[1]  = op2;
		op[2]  = op3;
		op[3]  = op4;
		op[4]  = op5;
		op[5]  = op6;
		op[6]  = op7;
		op[7]  = op8;
		op[8]  = op9;
		op[9]  = op10;
		Image image  = new Image("test.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(200);
		imageview.setX(400);
		root.getChildren().add(imageview);
		root.getChildren().add(text);
		root.getChildren().add(select);
		root.getChildren().add(op1);
		root.getChildren().add(op2);
		root.getChildren().add(op3);
		root.getChildren().add(op4);
		root.getChildren().add(op5);
		root.getChildren().add(op6);
		root.getChildren().add(op7);
		root.getChildren().add(op8);
		root.getChildren().add(op9);
		root.getChildren().add(op10);
		
		Scene scene  = new Scene(root , 800, 600);
		primaryStage.setTitle("Test maker");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void opsion1 (String str)
	{
		
		
		Text text  = new Text ("All the Questions in the data :"+"\n"+str);
		text.setFont(Font.font("Verdana",20));
		ScrollPane root = new ScrollPane();
		Scene scene = new Scene(root, 600, 600);
        text.wrappingWidthProperty().bind(scene.widthProperty());
        root.setFitToWidth(true);
        root.setContent(text);
		Stage stage  = new Stage ();
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void addEventHandlerToButtonOP2(int num, EventHandler<MouseEvent> event) {
		op2 [num].setOnMousePressed(event);
	}
	public void addEventHandlerToButton(int num, EventHandler<MouseEvent> event) {
		op[num].setOnMousePressed(event);
	}
	public Object getButton(int i) {
		return op[i-1];
	}
	public void Makeopsion2Screen() {
		Button AQ = new Button ("For American Question press here");
		AQ.setLayoutX(150);
		AQ.setLayoutY(150);
		Button OQ = new Button ("For Open Question press here");
		OQ.setLayoutX(150);
		OQ.setLayoutY(200);
		this.op2 = new Button[2];
		op2[0] = AQ;
		op2[1] = OQ;
		Group root = new Group();
		Image image  = new Image("test.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(200);
		imageview.setX(400);
		root.getChildren().add(imageview);
		root.getChildren().add(OQ);
		root.getChildren().add(AQ);
		Scene scene  = new Scene(root , 800, 600);
		Stage op2 = new Stage();
		op2.setScene(scene);
		op2.setTitle("Make a New Question To The Data");
		op2.show();
	   
		
	}
	public Object getButtonOP2(int i) {
		return op2[i-1];
	}
	public void NewOpenQuestionScreen() {
		
		
			
		      TextField textField1 = new TextField();
		      textField1.setLayoutX(130);
		      textField1.setLayoutY(200);
		      
		      TextField textField2 = new TextField();
		      Button button = new Button("Submit");
		      button.setLayoutX(130);
		      button.setLayoutY(300);
		      textField2.setLayoutX(130);
		      textField2.setLayoutY(250);
		      Label label1 = new Label("Question: ");
		      Label label2 = new Label("Answer: ");
		      label1.setLayoutX(80);
		      label1.setLayoutY(200);
		      label2.setLayoutX(80);
		      label2.setLayoutY(250);
		      Group root = new Group();
		      root.getChildren().add(label1);
		      root.getChildren().add(label2);
		      root.getChildren().add(button);
		      root.getChildren().add( textField1);
		      root.getChildren().add( textField2);
		      Scene scene  = new Scene (root, 600,600);
		      Stage st3 = new Stage();
		      st3.setScene(scene);
		      st3.show();
		      this.addNewOpenQuestion = button;
		      this.NewOpenQuestion = new TextField[2];
		      this.NewOpenQuestion[0] = textField1;
		      this.NewOpenQuestion[1] = textField2;
	}
	
	public TextField getNewOpenQuestionTextField(char textfiled) {
		if (textfiled=='q')
			return this.NewOpenQuestion[0];
		else
			return this.NewOpenQuestion[1];
	}
	public Button getaddNewOpenQuestionbutton ()
	{
		return this.addNewOpenQuestion;
	}
	public void addEventHandlerToButtonAddNewQuestion(EventHandler<MouseEvent> eventHandler ) {
		// TODO Auto-generated method stub
		this.addNewOpenQuestion.setOnMousePressed(eventHandler);
	}
	public void NewAmericanQuestionScreen() {
		Text text2  = new Text ("please type your Question:");


		TextField textField2 = new TextField();//
		textField2.setLayoutX(130);
		textField2.setLayoutY(80);
		this.TheQuesionOfAmericanAnswersTextField = textField2;
		text2.setY(50);
		text2.setX(130);
		Text text  = new Text ("please type how many american answers you want");
		text.setY(170);
		text.setX(130);
		text.setFont(Font.font("Verdara", 19));
		text2.setFont(Font.font("Verdara", 19));
		 Button button = new Button("Submit"); 
	      button.setLayoutX(130);
	      button.setLayoutY(400);
	      TextField textField1 = new TextField();
	      textField1.setLayoutX(130);
	      textField1.setLayoutY(200);
	      this.NumberOfAmericanAnswersTextField = textField1;
	      this.SubmitNumberOfAmericanAnswers  = button;
	      Group r = new Group();
	      Image image  = new Image("test.png");
			ImageView imageview = new ImageView (image);
			imageview.setY(200);
			imageview.setX(400);
			r.getChildren().add(textField2);
			r.getChildren().add(text2);
			r.getChildren().add(imageview);
	      r.getChildren().add(textField1);
	      r.getChildren().add(text);
	      r.getChildren().add(button);
	      Scene scene  = new Scene (r,600,600);
	      Stage NumberAmericanAnswersSelect = new Stage();
	      NumberAmericanAnswersSelect.setScene(scene);
	      NumberAmericanAnswersSelect.show();
	}
	public void addEventHandlerToButtonSubmitNumberOfAmericanAnswer(EventHandler<MouseEvent> eventHandler ) {
		// TODO Auto-generated method stub
		this.SubmitNumberOfAmericanAnswers.setOnMousePressed(eventHandler);
	}
	public TextField getNumberOfAmericanAnswersTextField() {
		return NumberOfAmericanAnswersTextField;
	}
	public Button getSubmitNumberOfAmericanAnswers() {
		return SubmitNumberOfAmericanAnswers;
	}
	public Group makeGroupOfAmericanAnswer(int i) {
		Text text  = new Text("Answer" +i);
		text.setLayoutX(130);
		text.setLayoutY(50 +((i-1)*105));
		text.setFont(Font.font("Verdara", 19));
		TextField textField = new TextField(); 
		textField.setLayoutX(130);
	    textField.setLayoutY(80 +((i-1)*105));
	    ChoiceBox <Boolean> choise = new ChoiceBox<>();
	    choise.getItems().add(true);
	    choise.getItems().add(false);
	    choise.minWidth(60);
	    choise.minHeight(65);
	    choise.setLayoutX(130);
	    choise.setLayoutY(110+((i-1)*105));
	    Group u = new Group();
	    u.getChildren().add(choise);
	    u.getChildren().add(text);
	    u.getChildren().add(textField);
	    this.Answers.add(textField);
	    this.TrueFalseAmericanAnswers.add(choise);
	    return u;
	    
		
	}
	public void MakeWindowNewAmericanQuestion(Group all) {
		Button submit = new Button("Submit");
		submit.setLayoutX(350);
		submit.setLayoutY(070);
		this.SubmitNewAmericanAnswers = submit;
		all.getChildren().add(submit);
		ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setContent(all);
        Scene scene = new Scene(root, 600, 600);
        Stage AmericanAnswerMaker  = new Stage();
        AmericanAnswerMaker.setScene(scene);
        AmericanAnswerMaker.show();
        
	}
	public TextField getQuestionOfNewAmericanQuestionTextField() {
		return QuestionOfNewAmericanQuestionTextField;
	}
	public void addEventHandlerToButtonSubmitNewAmericanAnswers(EventHandler<MouseEvent> eventHandler ) {
		// TODO Auto-generated method stub
		this.SubmitNewAmericanAnswers.setOnMousePressed(eventHandler);
	}
	
	public Button getSubmitNewAmericanAnswers() {
		return SubmitNewAmericanAnswers;
	}
	public ArrayList<TextField> getAnswers() {
		return Answers;
	}
	public ArrayList<ChoiceBox<Boolean>> getTrueFalseAmericanAnswers() {
		return TrueFalseAmericanAnswers;
	}
	public TextField getTheQuesionOfAmericanAnswersTextField() {
		return TheQuesionOfAmericanAnswersTextField;
	}
	public void EroorWindowAmericanAnswersMaker() {
		Text text = new Text ("EROOR , you need to fill all the select boxes and Text Files");
		text.setLayoutX(50);
		text.setLayoutY(100);
		text.setStyle("-fx-text-fill:RED; -fx-font-size:20px; -fx-font-weight:bold;  -fx-text-fill:red ;-fx-text-inner-color:red ;");
		text.setFill(Color.RED);
		Button ok = new Button("ok");
		ok.setMinSize(100,30);
		ok.setLayoutX(300);
		ok.setLayoutY(130);
		Group root = new Group();
		root.getChildren().add(text);
		root.getChildren().add(ok);
		Scene scene  = new Scene (root , 700,250);
		Stage st = new Stage ();
		st.setTitle("EROOR!");
		st.setScene(scene);
		st.show();
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (arg0.getSource()==ok)
				{
					st.close();
				}
				
			}
		});
		
		
	}
	public void ShowEroorWindowNumberAmericanAnswerIsNotEnter() {
		Text text = new Text ("EROOR , you need to put  a value in the Text Field...");
		text.setLayoutX(150);
		text.setLayoutY(100);
		text.setStyle("-fx-text-fill:RED; -fx-font-size:20px; -fx-font-weight:bold;  -fx-text-fill:red ;-fx-text-inner-color:red ;");
		text.setFill(Color.RED);
		Button ok = new Button("ok");
		ok.setMinSize(100,30);
		ok.setLayoutX(300);
		ok.setLayoutY(130);
		Group root = new Group();
		root.getChildren().add(text);
		root.getChildren().add(ok);
		Scene scene  = new Scene (root , 700,250);
		Stage st = new Stage ();
		st.setTitle("EROOR!");
		st.setScene(scene);
		st.show();
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (arg0.getSource()==ok)
				{
					st.close();
				}
				
			}
		});
		
		
	}
	public void MakeWindowForNewNumberQuestionUpdata() {
		Image image  = new Image("update5.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(200);
		imageview.setX(100);
		Text text  = new Text ("please enter the Number of Question you want to update ");
		text.setY(50);
		text.setX(130);
		text.setFont(Font.font("Verdana",17));	
		TextField NumberQuetion = new TextField();
		NumberQuetion.setLayoutX(130);
		NumberQuetion.setLayoutY(80);
		this.NewNumberQuestionUpdatTextField = NumberQuetion;
		Text text2  = new Text ("please enter the New Quesrion: ");
		text2.setFont(Font.font("Verdana",17));	
		text2.setY(130);
		text2.setX(130);
		TextField NewQuestionTexxt = new TextField();
		NewQuestionTexxt.setLayoutX(130);
		NewQuestionTexxt.setLayoutY(150);
		this.NewQuestionTextTextField = NewQuestionTexxt;
		Button SubmitNewTextQuestion = new Button("Submit");
		SubmitNewTextQuestion.setMinSize(100,30);
		SubmitNewTextQuestion.setLayoutX(370);
		SubmitNewTextQuestion.setLayoutY(150);
		this.ButtonSubmitNewQuestionTextSubmit = SubmitNewTextQuestion;
		Group root = new Group();
		root.getChildren().add(SubmitNewTextQuestion);
		root.getChildren().add(NewQuestionTexxt );
		root.getChildren().add(text);
		root.getChildren().add(imageview);
		root.getChildren().add(NumberQuetion);
		root.getChildren().add(text2);
		Scene scene = new Scene(root, 800, 600);
        Stage QuestionUpdate  = new Stage();
        QuestionUpdate.setScene(scene);
        QuestionUpdate.show();
        
		
	}
	public void addEventHandlerToButtonUpdateQuestion(EventHandler<MouseEvent> eventHandler) {
		this.ButtonSubmitNewQuestionTextSubmit.setOnMousePressed(eventHandler);
		
	}
	public TextField getNewNumberQuestionUpdatTextField() {
		return NewNumberQuestionUpdatTextField;
	}
	public TextField getNewQuestionTextTextField() {
		return NewQuestionTextTextField;
	}
	public Button getButtonSubmitNewQuestionTextSubmit() {
		return ButtonSubmitNewQuestionTextSubmit;
	}
	public void ShowEroorWindowNumberIsOutOfRange() {
		Text text = new Text ("EROOR , Number is Out Of Range");
		text.setLayoutX(150);
		text.setLayoutY(100);
		text.setStyle("-fx-text-fill:RED; -fx-font-size:20px; -fx-font-weight:bold;  -fx-text-fill:red ;-fx-text-inner-color:red ;");
		text.setFill(Color.RED);
		Button ok = new Button("ok");
		ok.setMinSize(100,30);
		ok.setLayoutX(300);
		ok.setLayoutY(130);
		Group root = new Group();
		root.getChildren().add(text);
		root.getChildren().add(ok);
		Scene scene  = new Scene (root , 700,250);
		Stage st = new Stage ();
		st.setTitle("EROOR!");
		st.setScene(scene);
		st.show();
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (arg0.getSource()==ok)
				{
					st.close();
				}
				
			}
		});
		
		
		
	}
	public void ShowEroorWindowTheQuestionIsExistIntheData() {
		Text text = new Text ("EROOR :the question is already exist in the same type");
		text.setLayoutX(150);
		text.setLayoutY(100);
		text.setStyle("-fx-text-fill:RED; -fx-font-size:20px; -fx-font-weight:bold;  -fx-text-fill:red ;-fx-text-inner-color:red ;");
		text.setFill(Color.RED);
		Button ok = new Button("ok");
		ok.setMinSize(100,30);
		ok.setLayoutX(300);
		ok.setLayoutY(130);
		Group root = new Group();
		root.getChildren().add(text);
		root.getChildren().add(ok);
		Scene scene  = new Scene (root , 700,250);
		Stage st = new Stage ();
		st.setTitle("EROOR!");
		st.setScene(scene);
		st.show();
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (arg0.getSource()==ok)
				{
					st.close();
				}
				
			}
		});
		
		
		
	}
	public void MakeWindowUpdateAnAnswer() {
		Image image  = new Image("update5.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(350);
		imageview.setX(130);
		Text text3 = new Text ("Please enter the number of answer you want to change if it is an american question , for a open question press any number:");
		text3.setY(220);
		text3.setX(130);

		TextField NumberAnswerToUpdateText = new TextField();
		NumberAnswerToUpdateText.setLayoutX(130);
		NumberAnswerToUpdateText.setLayoutY(250);
		this.NewNumberAnswerUpdatAnswerUpdateTextField = NumberAnswerToUpdateText;
		Text text  = new Text ("please enter the Number of Question you want to update the answer:");
		text.setY(50);
		text.setX(130);
		TextField NumberQuetionAnswerUpdate = new TextField();
		NumberQuetionAnswerUpdate.setLayoutX(130);
		NumberQuetionAnswerUpdate.setLayoutY(80);
		this.NewNumberQuestionUpdatAnswerUpdateTextField = NumberQuetionAnswerUpdate;
		Text text2  = new Text ("please enter the New ANSWER: ");
		text2.setY(125);
		text2.setX(130);
		text.setFont(Font.font("Verdana",15));
		text2.setFont(Font.font("Verdana",15));
		text3.setFont(Font.font("Verdana",15));
		TextField NewANSWERTexxt = new TextField();
		NewANSWERTexxt.setLayoutX(130);
		NewANSWERTexxt.setLayoutY(150);
		this.NewQuestionTextTextField = NewANSWERTexxt;
		Button SubmitNewTextAnswerButton = new Button("Submit");
		SubmitNewTextAnswerButton.setMinSize(100,30);
		SubmitNewTextAnswerButton.setLayoutX(130);
		SubmitNewTextAnswerButton.setLayoutY(280);
		this.ButtonSubmitNewAnswerTextSubmit = SubmitNewTextAnswerButton;
		Group root = new Group();
		root.getChildren().add(SubmitNewTextAnswerButton);
		root.getChildren().add(NewANSWERTexxt );
		root.getChildren().add(text);
		root.getChildren().add(imageview);
		root.getChildren().add(NumberQuetionAnswerUpdate);
		root.getChildren().add(text2);
		root.getChildren().add(text3);
		root.getChildren().add(NumberAnswerToUpdateText);
		Scene scene = new Scene(root, 1100, 600);
        Stage QuestionUpdate  = new Stage();
        QuestionUpdate.setScene(scene);
        QuestionUpdate.show();
		
	}
	public Button[] getOp() {
		return op;
	}
	public void setOp(Button[] op) {
		this.op = op;
	}
	public Button[] getOp2() {
		return op2;
	}
	public void setOp2(Button[] op2) {
		this.op2 = op2;
	}
	public Button getAddNewOpenQuestion() {
		return addNewOpenQuestion;
	}
	public void setAddNewOpenQuestion(Button addNewOpenQuestion) {
		this.addNewOpenQuestion = addNewOpenQuestion;
	}
	public TextField[] getNewOpenQuestion() {
		return NewOpenQuestion;
	}
	public void setNewOpenQuestion(TextField[] newOpenQuestion) {
		NewOpenQuestion = newOpenQuestion;
	}
	public TextField getNewNumberQuestionUpdatAnswerUpdateTextField() {
		return NewNumberQuestionUpdatAnswerUpdateTextField;
	}
	public void setNewNumberQuestionUpdatAnswerUpdateTextField(TextField newNumberQuestionUpdatAnswerUpdateTextField) {
		NewNumberQuestionUpdatAnswerUpdateTextField = newNumberQuestionUpdatAnswerUpdateTextField;
	}
	public Button getButtonSubmitNewAnswerTextSubmit() {
		return ButtonSubmitNewAnswerTextSubmit;
	}
	public void setButtonSubmitNewAnswerTextSubmit(Button buttonSubmitNewAnswerTextSubmit) {
		ButtonSubmitNewAnswerTextSubmit = buttonSubmitNewAnswerTextSubmit;
	}
	public TextField getNewNumberAnswerUpdatAnswerUpdateTextField() {
		return NewNumberAnswerUpdatAnswerUpdateTextField;
	}

	public void addEventHandlerToButtonUpdateAnswerSubmit(EventHandler<MouseEvent> eventHandler) {
		this.ButtonSubmitNewAnswerTextSubmit.setOnMousePressed(eventHandler);
		
	}
	public void MakeWindowDeletAnAnswer() {
		Image image  = new Image("update5.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(350);
		imageview.setX(130);
		Text text3 = new Text ("Please enter the number of answer you want to Delet if it is an american question , for a open question press any number:");
		text3.setY(220);
		text3.setX(130);

		TextField NumberAnswerToUpdateText = new TextField();
		NumberAnswerToUpdateText.setLayoutX(130);
		NumberAnswerToUpdateText.setLayoutY(250);
		this.NewNumberAnswerTo_Delet_TextField = NumberAnswerToUpdateText;
		Text text  = new Text ("please enter the Number of Question you want to Delet the answer:");
		text.setY(50);
		text.setX(130);
		TextField NumberQuetionAnswerUpdate = new TextField();
		NumberQuetionAnswerUpdate.setLayoutX(130);
		NumberQuetionAnswerUpdate.setLayoutY(80);
		this.NewNumberQuestionTo_Delet_AnswerTextField = NumberQuetionAnswerUpdate;
		
		text.setFont(Font.font("Verdana",15));
		
		text3.setFont(Font.font("Verdana",15));
		
		Button SubmitNewTextAnswerButton = new Button("Submit");
		SubmitNewTextAnswerButton.setMinSize(100,30);
		SubmitNewTextAnswerButton.setLayoutX(130);
		SubmitNewTextAnswerButton.setLayoutY(280);
		this.ButtonSubmitNumberAnswertoDeletSubmit = SubmitNewTextAnswerButton;
		Group root = new Group();
		root.getChildren().add(SubmitNewTextAnswerButton);
		
		root.getChildren().add(text);
		root.getChildren().add(imageview);
		root.getChildren().add(NumberQuetionAnswerUpdate);

		root.getChildren().add(text3);
		root.getChildren().add(NumberAnswerToUpdateText);
		Scene scene = new Scene(root, 1100, 600);
        Stage QuestionUpdate  = new Stage();
        QuestionUpdate.setScene(scene);
        QuestionUpdate.show();
		
	}
	public void addEventHandlerToButtonDeletAnswerSubmit(EventHandler<MouseEvent> eventHandler) {
		this.ButtonSubmitNumberAnswertoDeletSubmit.setOnMousePressed(eventHandler);
		
	}
	public TextField getNewNumberQuestionTo_Delet_AnswerTextField() {
		return NewNumberQuestionTo_Delet_AnswerTextField;
	}
	public TextField getNewNumberAnswerTo_Delet_TextField() {
		return NewNumberAnswerTo_Delet_TextField;
	}
	public void MakeWindowAutoTest() {
		Button b = new Button("Submit");
		b.setMinSize(100,30);
		b.setLayoutX(130);
		b.setLayoutY(110);
		this.ButtonSubmit_Number_Questions_auto_Test = b;
		Text text  = new Text ("please enter the Number of Questions you want in the test:");
		text.setY(50);
		text.setX(130);
		TextField NumberQuetionAnswerUpdate = new TextField();
		NumberQuetionAnswerUpdate.setLayoutX(130);
		NumberQuetionAnswerUpdate.setLayoutY(80);
		this.New_number_questions_Auto_Test = NumberQuetionAnswerUpdate;
		
		text.setFont(Font.font("Verdana",15));
		
		Image image  = new Image("test.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(200);
		imageview.setX(400);
		Group root = new Group();

		root.getChildren().add(b);
		
		root.getChildren().add(imageview);
		root.getChildren().add(text);
		root.getChildren().add(NumberQuetionAnswerUpdate);
		Scene scene = new Scene(root, 800, 600);
        Stage QuestionUpdate  = new Stage();
        QuestionUpdate.setScene(scene);
        QuestionUpdate.show();
		
		
	}
	public Button getButtonSubmitNumberQuestion_Auto_Test() {
		// TODO Auto-generated method stub
		return this.ButtonSubmit_Number_Questions_auto_Test;
	}
	public void addEventHandlerToButton_Submit_Auto_Questions_Number(EventHandler<MouseEvent> eventHandler) {
		this.ButtonSubmit_Number_Questions_auto_Test.setOnMousePressed(eventHandler);
		
	}
	public TextField getNew_number_questions_Auto_Test() {
		return New_number_questions_Auto_Test;
	}
	public void Make_Window_Select_test_to_clone() {
		Button b = new Button("Submit");
		b.setMinSize(100,30);
		b.setLayoutX(130);
		b.setLayoutY(110);
		this.Clone_Number_Of_TestSubmit = b;
		Text text  = new Text ("please enter the Number of Test you want clone , if this is latest test press 0");
		text.setY(50);
		text.setX(130);
		TextField NumberQuetionAnswerUpdate = new TextField();
		NumberQuetionAnswerUpdate.setLayoutX(130);
		NumberQuetionAnswerUpdate.setLayoutY(80);
		this.Clone_Number_Of_TestTextField = NumberQuetionAnswerUpdate;
		
		text.setFont(Font.font("Verdana",15));
		
		Image image  = new Image("test.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(200);
		imageview.setX(400);
		Group root = new Group();

		root.getChildren().add(b);
		
		root.getChildren().add(imageview);
		root.getChildren().add(text);
		root.getChildren().add(NumberQuetionAnswerUpdate);
		Scene scene = new Scene(root, 800, 600);
        Stage QuestionUpdate  = new Stage();
        QuestionUpdate.setScene(scene);
        QuestionUpdate.show();
		
		
	}
	public TextField getClone_Number_Of_TestTextField() {
		return Clone_Number_Of_TestTextField;
	}
	public Button getClone_Number_Of_TestSubmit() {
		return Clone_Number_Of_TestSubmit;
	}
	public void addEventHandlerToButton_Clone_Number_Of_TestSubmit(EventHandler<MouseEvent> eventHandler) {
		this.Clone_Number_Of_TestSubmit.setOnMousePressed(eventHandler);
		
	}
	public ArrayList <ChoiceBox<Integer>> getChoises_Question_for_test_array() {
		return Choises_Question_for_test_array;
	}
	public TextField getNumber_question_NORMAL_testTextField() {
		return Number_question_NORMAL_testTextField;
	}
	public Button getNumber_Of_Question_Normal_testSubmit() {
		return Number_Of_Question_Normal_testSubmit;
	}
	public Button getMake_test_Normal_testSubmit() {
		return Make_test_Normal_testSubmit;
	}
	public void addEventHandlerToNumber_Of_Question_Normal_testSubmit(EventHandler<MouseEvent> eventHandler) {
		this.Number_Of_Question_Normal_testSubmit.setOnMousePressed(eventHandler);
		
	}
	public void addEventHandlerToMake_test_Normal_testSubmi(EventHandler<MouseEvent> eventHandler) {
		this.Make_test_Normal_testSubmit.setOnMousePressed(eventHandler);
		
	}
	public void Make_Window_Select_Number_Question_To_Make_Noraml_Test() {
		Button b = new Button("Submit");
		b.setMinSize(100,30);
		b.setLayoutX(130);
		b.setLayoutY(110);
		this.Number_Of_Question_Normal_testSubmit= b;
		Text text  = new Text ("please enter the Number of Question you want in the Test:");
		text.setY(50);
		text.setX(130);
		TextField NumberQuetionAnswerUpdate = new TextField();
		NumberQuetionAnswerUpdate.setLayoutX(130);
		NumberQuetionAnswerUpdate.setLayoutY(80);
		this.Number_question_NORMAL_testTextField = NumberQuetionAnswerUpdate;
		this.Number_American_answer_to_question_i_Text_Field.add(NumberQuetionAnswerUpdate);
		text.setFont(Font.font("Verdana",15));
		
		Image image  = new Image("test.png");
		ImageView imageview = new ImageView (image);
		imageview.setY(200);
		imageview.setX(400);
		Group root = new Group();

		root.getChildren().add(b);
		
		root.getChildren().add(imageview);
		root.getChildren().add(text);
		root.getChildren().add(NumberQuetionAnswerUpdate);
		Scene scene = new Scene(root, 800, 600);
        Stage QuestionUpdate  = new Stage();
        QuestionUpdate.setScene(scene);
        QuestionUpdate.show();
		
		
	}
	public Group make_Group_Normal_Test(int numberOfQuestions , int NumberQuestionInTheData) {
		this.Choises_Question_for_test_array  = new ArrayList<>();
		 Group all = new Group();
		for (int i = 0; i < numberOfQuestions; i++) {
			Text text  = new Text("Question " +(i+1));
			text.setLayoutX(140);
			text.setLayoutY(50 +((i)*105));
			text.setFont(Font.font("Verdara", 15));
		    ChoiceBox <Integer> choise = new ChoiceBox<>();
		    choise.minWidth(60);
		    choise.minHeight(65);
		    choise.setLayoutX(140);
		    choise.setLayoutY(80+((i)*105));
		    for (int j = 0; j < NumberQuestionInTheData; j++) {
				choise.getItems().add((j+1));
			}
		    Choises_Question_for_test_array.add(choise);
		    Group u = new Group();
		    u.getChildren().add(choise);
		    u.getChildren().add(text);
			all.getChildren().add(u);
		}
		return all;
		
	}
	public void make_Window_Choise_Questions_Normal_Test(Group all) {
		Button submit = new Button("Submit");
		submit.setLayoutX(350);
		submit.setLayoutY(this.PlaceButton);
		this.Make_test_Normal_testSubmit = submit;
		all.getChildren().add(submit);
		ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setContent(all);
        Scene scene = new Scene(root, 600, 600);
        Stage AmericanAnswerMaker  = new Stage();
        AmericanAnswerMaker.setScene(scene);
        AmericanAnswerMaker.show();
		
	}
	public ArrayList<Button> getSubmit_American_Answers_to_American_Questions() {
		return Submit_American_Answers_to_American_Questions;
	}
	public void make_Window_choose_new_american_answer_for_AmericanQuestion(int i) {
		Text text  = new Text ("please enter the Number of American answers you want in the Question "+ i +"(up to 10...)");
		text.setY(50);
		text.setX(50);
		text.setFont(Font.font("Verdara", 20));
		TextField num = new TextField();
		this.Number_American_answer_to_question_i_Text_Field.add(num);
		this.CurrenTextField = num;
		num.setLayoutX(50);
		num.setLayoutY(80);
		Button b = new Button("Submit");
		b.setLayoutX(50);
		b.setLayoutY(110);
		this.Number_American_answer_to_question_i.add(b);
		this.CurrentStageButton = (b);
		Group p = new Group();
		p.getChildren().add(text);
		p.getChildren().add(b);
		p.getChildren().add(num);
		Scene scene = new Scene(p, 900,500);
		Stage st = new Stage();
		st.setScene(scene);
		this.CurrentStage  = st;
		
		
		
		
		 
		
	}
	public void addEventHandlerToButton_Submit_Numberr_American_Answer_To_Question_NormalTest(
			int i, EventHandler<MouseEvent> eventHandler) {
		this.Number_American_answer_to_question_i.get((i)).setOnMousePressed(eventHandler);
		
	}
	public TextField getTextFieldWindow_choose_new_american_answer_for_AmericanQuestion(int i) {
		return this.Number_American_answer_to_question_i_Text_Field.get(i);
	}
	public Group make_Group_Normal_Test_american_Answer(int numberOfAmericanAnswerNormalTest,
			int numberOfAmericanAnswers, int i) {
		ArrayList <ChoiceBox<Integer>> current  = new ArrayList<>();
		Current_Choises_American_Answers_For_Question_i.add(current);
		int numberOfQuestions = numberOfAmericanAnswerNormalTest;
		 Group all = new Group();
		for (int i1 = 0; i1 < numberOfQuestions; i1++) {
			Text text  = new Text("Answer " +(i1+1));
			text.setLayoutX(140);
			text.setLayoutY(50 +((i1)*105));
			text.setFont(Font.font("Verdara", 15));
		    ChoiceBox <Integer> choise = new ChoiceBox<>();
		    choise.minWidth(60);
		    choise.minHeight(65);
		    choise.setLayoutX(140);
		    choise.setLayoutY(80+((i1)*105));
		    for (int j = 0; j < numberOfAmericanAnswers; j++) {
				choise.getItems().add((j+1));
			}
		    current.add(choise);
		    Group u = new Group();
		    u.getChildren().add(choise);
		    u.getChildren().add(text);
			all.getChildren().add(u);
		}
		return all;
	}
	public void newWindow_Select_Answer(Group all) {
		
		Button submit = new Button("Submit");
		submit.setLayoutX(350);
		submit.setLayoutY(500);
		this.Submit_American_Answers_to_American_Questions.add(submit);
		this.CurrentStageButton = submit;
		all.getChildren().add(submit);
		ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);
        root.setContent(all);
        Scene scene = new Scene(root, 600, 600);
        Stage AmericanAnswerMaker  = new Stage();
        AmericanAnswerMaker.setScene(scene);
        AmericanAnswerMaker.show();
        this.CurrentStage = AmericanAnswerMaker;
        
		
	}
	public Button getSubmit_American_Answers_to_American_Questions(int i)
	{
		return this.Submit_American_Answers_to_American_Questions.get(i-1);
	}
	
	public void addEvenetHandlerto_Submit_American_Answers_to_American_Questions(int i, EventHandler<MouseEvent> eventHandler)
	{
		this.Submit_American_Answers_to_American_Questions.get(i-1).setOnMousePressed(eventHandler);
		 
	}
	
	public Button Number_American_answer_to_question_i(int i)
	{
		return this.Number_American_answer_to_question_i.get(i);
	}
	
	public Stage getCurrentStage() {
		return CurrentStage;
	}
	public Button getCurrentStageButton() {
		return CurrentStageButton;
	}
	public TextField getCurrenTextField() {
		return CurrenTextField;
	}
	public ArrayList<ChoiceBox<Integer>> getCurrent_Choises_American_Answers_For_Question_i(int i) {
		return Current_Choises_American_Answers_For_Question_i.get(i-1);
	}
	public void addEventHandlerTo_Current_Button (EventHandler<MouseEvent> eventHandler) {
		this.CurrentStageButton.setOnMousePressed(eventHandler);
		
	}
	public TextField getNumber_American_answer_to_question_i_Text_Field(int i) {
		return this.Number_American_answer_to_question_i_Text_Field.get(i);
	}
	public Group GroupComoBox(int numberOfQuestions, int NumberQuestionInTheData , ArrayList<Questions> arrDATA , Set<AmericanAnswers> arrAmericanAnswersData) {
		this.arr_for_Normal_test = new ArrayList<>();
		this.ComboBoxArr  = new ArrayList<>();
		 Group all = new Group();
		 this.PlaceButton=PlaceButton+(50*numberOfQuestions);
		for (int i = 0; i < numberOfQuestions; i++) {
			final int i1 = i;
			Text text  = new Text("Question " +(i+1));
			text.setLayoutX(140);
			text.setLayoutY(50 +((i)*105));
			text.setFont(Font.font("Verdara", 15));
		    ComboBox <Integer> choise = new ComboBox<>();
		    choise.minWidth(60);
		    choise.minHeight(65);
		    choise.setLayoutX(140);
		    choise.setLayoutY(80+((i)*105));
		    for (int j = 0; j < NumberQuestionInTheData; j++) {
				choise.getItems().add((j+1));
			}
		    ComboBoxArr.add(choise);
		    Group u = new Group();
		    u.getChildren().add(choise);
		    u.getChildren().add(text);
			all.getChildren().add(u);
		    choise.setOnAction((event) -> {
		        int selectedIndex = choise.getSelectionModel().getSelectedIndex();
		        Object selectedItem = choise.getSelectionModel().getSelectedItem();
		        Questions e = arrDATA.get(selectedIndex);
		        e.setNumques(i1+1);
		        if (arrDATA.get(selectedIndex).getType()=='A')
		        {
		        	Text text2 = new Text("Select how many Answer you wnat in the American Quetion:");
		        	text2.setLayoutX(300);
					text2.setLayoutY(50 +((i1)*105));
					text2.setFont(Font.font("Verdara", 15));
					ComboBox<Integer> c  = new ComboBox<>();
					for (int j = 0; j < 11; j++) {
						c.getItems().add((j+1));
					}
					c.minWidth(60);
				    c.minHeight(65);
				    c.setLayoutX(300);
				    c.setLayoutY(80 +((i1)*105));
				    u.getChildren().add(c);
				    u.getChildren().add(text2);
				    c.setOnAction((even) -> {
				    	ArrayList<AmericanAnswers> arr = new ArrayList<>();
				    	for(int t =0; t<c.getSelectionModel().getSelectedIndex()+1;t++)
				    	{
				    		final int t1 = t;
							Text text3  = new Text("answer " +(t+1));
							text3.setLayoutX(750 +(150*t));
							text3.setLayoutY(50 +((i1)*105));
							text3.setFont(Font.font("Verdara", 15));
						    ComboBox <Integer> choise2 = new ComboBox<>();
						    choise2.minWidth(60);
						    choise2.minHeight(65);
						    choise2.setLayoutX(750 +(150*t));
						    choise2.setLayoutY(80+((i1)*105));
						    for (int j = 0; j < 16; j++) {
								choise2.getItems().add((j+1));
							}
						    u.getChildren().add(choise2);
						    u.getChildren().add(text3);
						    choise2.setOnAction((event2) ->{
						    	int SelectAnswer = choise2.getSelectionModel().getSelectedIndex();
						    	AmericanAnswers t2 = arrAmericanAnswersData.get(SelectAnswer);
						    	if ( arr.size()<(t1+1))
						        	 arr.add(t2);
						        else
						        	arr.set(t1,t2);
						    	e.setAnswers(arr);
						    });
						    
				    	}
				    });
						
					
		        }
		        
		        if ( this.arr_for_Normal_test.size()<(i1+1))
		        	 this.arr_for_Normal_test.add(e);
		        else
		        	this.arr_for_Normal_test.set(i1,e);
		       
		        
		    });
		    
		  
		}
		return all;
		
	}
	public ArrayList<Questions> getArrQuestions() {
		return this.arr_for_Normal_test;
	}
	public void ShowEroorWindowNumberIsOutOfRangeCloneATest() {
		Text text = new Text ("EROOR , Number is Out Of Range Or you need to make a test first....");
		text.setLayoutX(150);
		text.setLayoutY(100);
		text.setStyle("-fx-text-fill:RED; -fx-font-size:20px; -fx-font-weight:bold;  -fx-text-fill:red ;-fx-text-inner-color:red ;");
		text.setFill(Color.RED);
		Button ok = new Button("ok");
		ok.setMinSize(100,30);
		ok.setLayoutX(300);
		ok.setLayoutY(130);
		Group root = new Group();
		root.getChildren().add(text);
		root.getChildren().add(ok);
		Scene scene  = new Scene (root , 900,250);
		Stage st = new Stage ();
		st.setTitle("EROOR!");
		st.setScene(scene);
		st.show();
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (arg0.getSource()==ok)
				{
					st.close();
				}
				
			}
		});
		
		
		
	}
	
	

}
