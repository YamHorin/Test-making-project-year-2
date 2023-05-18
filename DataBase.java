package Programs;
import java.sql.*;
import java.util.ArrayList;
public class DataBase {

	private String dbUrl;
	private String nameSQL;
	private String PasswordSql;
	public DataBase()
	{
	    Connection conn = null;
	    this .dbUrl = "jdbc:mysql://localhost:3306/test_making_system";
	    this.nameSQL = "root";
	    this.PasswordSql = "deganit@0800abc";
	
//        try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			this.conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
//            Statement stmt = this.conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM american_answer");
//            while (rs.next()) { 
//            	System.out.println(rs.getInt("American_answer_ID") + "- " + 
//            	rs.getInt("serial_Number")+ "- " +rs.getString("Text") +"--"+rs.getBoolean("is_correct"));  
//            }
//
//      this.conn.close();
//
//	}
//        catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//        catch (SQLException e)
//        {
//        	e.printStackTrace();
//        }
//        
        
	}
	public boolean insertTestIntoDataBase(Test test , int courseNumber)
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            String sql_commend = "INSERT into tests values ("+test.getTestid()+","
            		+" "+test.getQuestions().size()+", '"+test.getType()+"' ,"
            		+"'"+test.getCreat_date()+"' ,"+courseNumber+");";
            
            int numRowAffected  = stmt.executeUpdate(sql_commend);
            if (numRowAffected!=1)
            	return false;
            conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		
		return true;
	}
	
	
	public String Opsion1()
	{
		Connection conn = null;
		 String str ="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();

            ResultSet QuestionSet = stmt.executeQuery("select * from questions");
            while (QuestionSet.next())
            {
            	str+=QuestionSet.getInt("Question_Number")+"]"+"\n"+QuestionSet.getString("Question_Text")+"\n";
            	int QuestionNumTemp = QuestionSet.getInt("Question_Number");
            	if (QuestionSet.getString("Question_Type").charAt(0)=='O')
            	{
            		str+="\nthis is a open Question (answer in sentence)\n";
                    ResultSet openAnswer = stmt1.executeQuery("SELECT Question_Answer from open_questions WHERE  "
                    		+ "open_questions.Question_Number = "+QuestionNumTemp+";");
                    while(openAnswer.next())
                    {
                    	str+="\nanswer:"+openAnswer.getString("Question_Answer") +"\n\n\n";
                    }
            		
            	}
            	else
            	{
            		str+="\nthis is a American Question \n";
            		ResultSet NumberCorrectAnswers = stmt2.executeQuery("select number_of_correct_answers from american_question "
            				+ "WHERE Question_Number = "+ QuestionNumTemp+";");
            		while(NumberCorrectAnswers.next())
            			str+="\n\n there are "+NumberCorrectAnswers.getInt("number_of_correct_answers")+"  Correct answers\n";
            		ResultSet AmericanQuestionTOCURRENTQuestion =stmt3.executeQuery("SELECT serial_Number , Text , is_correct from american_answer join american_question_to_american_answer\r\n"
            				+ "on american_question_to_american_answer.american_answer_id  = "
            				+ "american_answer.American_answer_ID and american_Question_id = "+QuestionNumTemp+" order by serial_Number ASC;") ;
            		while (AmericanQuestionTOCURRENTQuestion.next())
            		{
            			str+="\n"+AmericanQuestionTOCURRENTQuestion.getInt("serial_Number")+") "+
            					AmericanQuestionTOCURRENTQuestion.getString("Text")+"\n";
            			if (AmericanQuestionTOCURRENTQuestion.getBoolean("is_correct")==true)
            				str+="\n"+"True Answer\n";
            			else
            				str+="\n"+"False Answer\n";
            		}
            		str+="\n\n";
            		
            	}
            }

            conn.close();
		}  
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return str;
	}
	public String opsion10()
	{
		Connection conn = null;
		 String str ="";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
	            Statement stmt = conn.createStatement();
	            ResultSet AmericanAnswers = stmt.executeQuery("select * from american_answer");
	            while (AmericanAnswers.next()) {
					str+="\nAmerican answer ID = "+AmericanAnswers.getInt("American_answer_ID");
					str+="\n\nserial_Number(what is shown in the question) =  "+AmericanAnswers.getInt("serial_Number");
					str+="\n\n"+AmericanAnswers.getString("Text")+"\n";
					if (AmericanAnswers.getBoolean("is_correct")==true)
						str+="\na True Answer\n";
					else
						str+="\na FALSE Answer\n";
				}
			
		}
		 
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
		 
		 return str;
	}
	
	public ArrayList<Questions> BringArrayQuestionFromDataBase()
	{
		ArrayList<Questions> arrQuestionsData = new ArrayList<>();
		
		int numOfQuestion ,QuestionNumTemp , numAmericanAnswerCurrent  ;
		boolean isTheAnswerCurrect;
		
		//remember to add the answers of the american answer
		String StrQuestion , OpenQuestionAnswerSTR = null , AmericanAnswerText;
		char type;
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();

            ResultSet QuestionSet = stmt.executeQuery("select * from questions");
            while (QuestionSet.next())
            {
            	
            	numOfQuestion=QuestionSet.getInt("Question_Number");
            	StrQuestion = QuestionSet.getString("Question_Text");
            	type = QuestionSet.getString("Question_Type").charAt(0);
            	QuestionNumTemp = QuestionSet.getInt("Question_Number");
            	if (QuestionSet.getString("Question_Type").charAt(0)=='O')
            	{
            		//make new open Question 
                    ResultSet openAnswer = stmt1.executeQuery("SELECT Question_Answer from open_questions WHERE  "
                    		+ "open_questions.Question_Number = "+QuestionNumTemp+";");
                    while(openAnswer.next())
                    {
                    	OpenQuestionAnswerSTR=openAnswer.getString("Question_Answer") +"\n";
                    }
                    
            		OpenQuestions tmp = new OpenQuestions(numOfQuestion, StrQuestion, type, OpenQuestionAnswerSTR);
            		arrQuestionsData.add(tmp);
            	}
            	else
            	{
            		ArrayList<AmericanAnswers> arrAmericanAnswer = new ArrayList<>();
            		ResultSet AmericanAnswersToQuestion =stmt3.executeQuery("SELECT serial_Number , Text , is_correct from american_answer join american_question_to_american_answer\r\n"
            				+ "on american_question_to_american_answer.american_answer_id = "
            				+ "american_answer.American_answer_ID and american_Question_id = "+QuestionNumTemp+";") ;
            		while (AmericanAnswersToQuestion.next())
            		{
            			
            			numAmericanAnswerCurrent = AmericanAnswersToQuestion.getInt("serial_Number");
            			AmericanAnswerText = AmericanAnswersToQuestion.getString("Text");
            			isTheAnswerCurrect = AmericanAnswersToQuestion.getBoolean("is_correct");
            			AmericanAnswers ans = new AmericanAnswers(numAmericanAnswerCurrent, AmericanAnswerText, isTheAnswerCurrect);
            			arrAmericanAnswer.add(ans);
            		}
            		AmericanQuestions tmpA = new AmericanQuestions(numOfQuestion, StrQuestion, type, arrAmericanAnswer);
            		arrQuestionsData.add(tmpA);
            		
            	}
            }

            conn.close();
		}  
			
			
		
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
		return arrQuestionsData; 
		 
		
	}
	public boolean opsion3 (int NumberQuestion ,String newText) //true if works false if not 
	{
		String commend2;
		char type = 0;
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            String commend  = "UPDATE questions "
            		+ " SET "
            		+ "   Question_Text = '"+newText
            		+ "' WHERE  "
            		+ "    Question_Number ="+NumberQuestion+";";
            ResultSet typeQuestion = stmt1.executeQuery("SELECT Question_Type FROM questions WHERE Question_Number="+NumberQuestion+";");
            while(typeQuestion.next())
            type = typeQuestion.getString("Question_Type").charAt(0);
            if (type=='O')
            {
            	  commend2  = " UPDATE open_questions "
                 		+ " SET "
                 		+ "    Question_Text = '"+newText
                 		+ "' WHERE   Question_Number ="+NumberQuestion+";";
                 		
            }
            else
            {
            	 commend2  = " UPDATE american_question "
                  		+ " SET "
                  		+ "    Question_Text = '"+newText
                  		+ "' WHERE  Question_Number ="+NumberQuestion+";";
                  		
            	
            }
           
            int numAffectedRows = stmt.executeUpdate(commend) +stmt2.executeUpdate(commend2);
            if (numAffectedRows!=2)
            	return false;
            conn.close();
            
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		
		return true;
		
	}
	public Set<AmericanAnswers> makeSetAmericanAnswers()
	{
		Set<AmericanAnswers> arr = new Set<>();
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            ResultSet americanAnswer = stmt.executeQuery("SELECT * from american_answer");
            while(americanAnswer.next())
            {
            	int serialNum  = americanAnswer.getInt("serial_Number");
            	String Textans = americanAnswer.getString("Text");
            	boolean is_correct  = americanAnswer.getBoolean("is_correct");
            	AmericanAnswers a = new AmericanAnswers(serialNum, Textans, is_correct);
            	try {
					arr.add(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
            
            conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return arr;
	}

	public boolean opsion4(String newAnswer, int numQuestionChangeAnswer, int numberAnswerAmerican) {
		String commend_sql;
		int id_AmericanAnswer = 0;
		char type = 0;
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet typeAnswer = stmt1.executeQuery("SELECT Question_Type FROM questions WHERE Question_Number="+numQuestionChangeAnswer+";");
            while(typeAnswer.next())
            type = typeAnswer.getString("Question_Type").charAt(0);
          
            if (type=='O')
            {
            	  commend_sql  = " UPDATE open_questions "
                 		+ " SET "
                 		+ "    Question_Answer = '"+newAnswer
                 		+ "' WHERE   Question_Number ="+numQuestionChangeAnswer+";";
                 		
            }
            else
            {
            	ResultSet AmericanAnswer_Number_TOQuestion =stmt2.executeQuery("SELECT * from american_answer join american_question_to_american_answer\r\n"
        				+ "on american_question_to_american_answer.american_answer_id = "
        				+ "american_answer.American_answer_ID and serial_Number = "+numberAnswerAmerican+
        				" and american_Question_id = "+numQuestionChangeAnswer+";");
            	while(AmericanAnswer_Number_TOQuestion.next())
            		id_AmericanAnswer = AmericanAnswer_Number_TOQuestion.getInt("American_answer_ID");
            	 commend_sql  = " UPDATE american_answer "
                  		+ " SET "
                  		+ "    Text = '"+newAnswer
                  		+ "' WHERE  American_answer_ID ="+id_AmericanAnswer+";";
                  		
            	
            }
           
            int numAffectedRows = stmt2.executeUpdate(commend_sql);
            if (numAffectedRows!=1)
            	return false;
            conn.close();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		
		return true;
		
	}

	public boolean opsion5(int number_Question_to_Delet_answer, int number_answer_to_Delet) {
		Connection conn = null;
		char type = 0;
		int id_AmericanAnswer=0;
		String sql_Commend , sql_Commend_2 , sql_Commend_3;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet typeAnswer = stmt1.executeQuery("SELECT Question_Type FROM questions WHERE Question_Number="+number_Question_to_Delet_answer+";");
            while(typeAnswer.next())
            type = typeAnswer.getString("Question_Type").charAt(0);
			if (type == 'O')
			{
				sql_Commend = " UPDATE open_questions "
                 		+ " SET "
                 		+ "    Question_Answer = NULL"
                 		+ " WHERE   Question_Number ="+number_Question_to_Delet_answer+";";
				int numAffectedRows = stmt.executeUpdate(sql_Commend);
				if (numAffectedRows!=1)
					return false;
			}
			else
			{
				sql_Commend = " UPDATE american_question "
                 		+ " SET "
                 		+ "  number_of_answers=number_of_answers-1"
                 		+ " WHERE   Question_Number ="+number_Question_to_Delet_answer+";";
				ResultSet AmericanAnswer_Number_TOQuestion =stmt2.executeQuery("SELECT * from american_answer join american_question_to_american_answer\r\n"
        				+ "on american_question_to_american_answer.american_answer_id = "
        				+ "american_answer.American_answer_ID and serial_Number = "+number_answer_to_Delet+
        				" and american_Question_id = "+number_Question_to_Delet_answer+";");
            	while(AmericanAnswer_Number_TOQuestion.next())
            		id_AmericanAnswer = AmericanAnswer_Number_TOQuestion.getInt("American_answer_ID");
            	String sql_Commend_4 = "SET FOREIGN_KEY_CHECKS=0;";
            	String sql_Commend_5 = "SET FOREIGN_KEY_CHECKS=1;";
            	sql_Commend_2 = "DELETE FROM american_answer WHERE American_answer_ID="+id_AmericanAnswer+";";
            	sql_Commend_3 = "DELETE FROM american_question_to_american_answer WHERE american_answer_id="+id_AmericanAnswer+";";
            	int numAffectedRows = stmt.executeUpdate(sql_Commend);
            	numAffectedRows+= stmt.executeUpdate(sql_Commend_4);
            	numAffectedRows+= stmt.executeUpdate(sql_Commend_2);
            	numAffectedRows+=stmt.executeUpdate(sql_Commend_3);
            	numAffectedRows+=stmt.executeUpdate(sql_Commend_5);
            	if (numAffectedRows==2)
            		return false;
            	
            	
				
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return true;
	}
	public boolean addOpenQuestion_to_database(OpenQuestions nquestion) {
		String sql_Commend , sql_Commend_2;
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            sql_Commend = "INSERT into questions VALUES("
            		+nquestion.getNumques()+" , "+"'"
            		+nquestion.getQuestion()+"'"+" , "
            		+"'O'"+");";
            System.out.println(sql_Commend);
            sql_Commend_2 = "INSERT into  open_questions VALUES("
            		+nquestion.getNumques()+" , "+"'"
            		+nquestion.getQuestion()+"'"+" , "
            		+"'"+nquestion.getAnswer()+"'"+");";
            int numOfRows=0;
            numOfRows+=stmt.executeUpdate(sql_Commend);
            numOfRows+=stmt1.executeUpdate(sql_Commend_2);
            if (numOfRows!=2)
            	return false;
            conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return true;
	}
	public boolean addAmericanQuestion_ToDataBase(AmericanQuestions nquestion) {
		String sql_Commend , sql_Commend_2 , sql_commend_3 ;
		String sql_commend_american_answers[];
		String sql_commend_american_answers_to_Match_table[];
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            Statement stmt4 = conn.createStatement();
            //questions table
            sql_Commend = "INSERT into questions VALUES("
            		+nquestion.getNumques()+" , "+"'"
            		+nquestion.getQuestion()+"'"+" , "
            		+"'A'"+");";
            System.out.println(sql_Commend);
            //american question table 
            sql_Commend_2 = "INSERT into  american_question VALUES("
            		+nquestion.getNumques()+" , "+"'"
            		+nquestion.getQuestion()+"'"+" , "
            		+""+nquestion.getAnswers().size()+" , "+nquestion.getNumberOfCorrectAnswer_American()+");";
            int numofAnswers = nquestion.getAnswers().size();
            sql_commend_american_answers = new String[numofAnswers];
            sql_commend_american_answers_to_Match_table = new String[numofAnswers];
            //last place of american answers
            sql_commend_3 = "select count(*) from 	american_answer";
            ResultSet rs = stmt3.executeQuery(sql_commend_3 );
            rs.next();
            int lastPlace = rs.getInt(1);
            System.out.println(lastPlace);
            lastPlace++;
            //american answers table
            for (int i = 0; i < sql_commend_american_answers.length; i++) {
            	 sql_commend_american_answers[i] = "INSERT INTO american_answer VALUES("+lastPlace+" , "+
            +nquestion.getAnswers().get(i).getSerialnumber()+" , "+"'"+nquestion.getAnswers().get(i).getAnswer()+"'"
            +","+nquestion.getAnswers().get(i).isCorrect()+");\n";
            	System.out.println(sql_commend_american_answers[i]); 
            	sql_commend_american_answers_to_Match_table[i] =" insert into american_question_to_american_answer values ("+lastPlace+" , "+nquestion.getNumques()+");";  
            	lastPlace++;
			}
            
            int numOfRows=0;
            String sql_Commend_4 = "SET FOREIGN_KEY_CHECKS=0;";
        	String sql_Commend_5 = "SET FOREIGN_KEY_CHECKS=1;";
        	stmt.executeUpdate(sql_Commend_4);
            numOfRows+=stmt.executeUpdate(sql_Commend);
            numOfRows+=stmt1.executeUpdate(sql_Commend_2);
            
            for (int i = 0; i < sql_commend_american_answers.length; i++) {
            	numOfRows+=stmt4.executeUpdate(sql_commend_american_answers[i]);
            	numOfRows+= stmt2.executeUpdate(sql_commend_american_answers_to_Match_table[i]);
			}
            if (numOfRows!=2+2*(numofAnswers))
            	return false;
            stmt.executeUpdate(sql_Commend_5);
            conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return true;
		
	}
	public ArrayList<course> bring_data_course()
	{
		ArrayList<course> arr = new ArrayList<>();
		String sql_Commend;
		sql_Commend = "Select * from course";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
           ResultSet set  = stmt.executeQuery(sql_Commend);
           while(set.next())
           {
        	   course tmp  = new course(set.getInt("id_COURSE"), set.getString("name_COURSE"));
        	   arr.add(tmp);
           }
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return arr;
	}
	public boolean  insert_new_course(int num , String name)
	{
		String sql_commend = "INSERT INTO course values ("+num+",'"+name+"');";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, nameSQL, PasswordSql);
            Statement stmt = conn.createStatement();
            int numofRows = stmt.executeUpdate(sql_commend);
            if (numofRows!=1)
            	return false;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e)
        {
        	e.printStackTrace();
        }
		return true;
	}
	
}
