package com.lti.model;

import java.util.ArrayList;
import java.util.List;

import com.lti.model.Question.Difficulty;

public class QuestionBankLoader {
	
	public List<Question> loadQuestionOnJava(){
		String subjectName ="Java";
		QuestionBank qb = new QuestionBank();
		qb.addNewSubject(subjectName);
		
		Question q = new Question("What is java?", Difficulty.EASY);
		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("Java is a database", false));
		ops.add(new Option("Java is a programming language", true));
		ops.add(new Option("Java is an OS", false));
		ops.add(new Option("Java is a file system", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		q = new Question("What is JDK?", Difficulty.EASY);
		ops = new ArrayList<Option>();
		ops.add(new Option("JDK is a Java Development Kit", true));
		ops.add(new Option("JDK is a garbage collector", false));
		ops.add(new Option("JDK is an interface", false));
		ops.add(new Option("JDK is a file system", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		q = new Question("What is JRE?", Difficulty.EASY);
		ops = new ArrayList<Option>();
		ops.add(new Option("JRE is a Java Development Kit", false));
		ops.add(new Option("JRE is a Java Runtime Environment", true));
		ops.add(new Option("JRE is an interface", false));
		ops.add(new Option("JRE is a file system", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		q = new Question("What is JVM?", Difficulty.EASY);
		ops = new ArrayList<Option>();
		ops.add(new Option("JVM is a Java Development Kit", false));
		ops.add(new Option("JVM is a programming language", false));
		ops.add(new Option("JVM is an Java Virtual Machine", true));
		ops.add(new Option("JVM is a file system", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		q = new Question("What is Comprable?", Difficulty.EASY);
		ops = new ArrayList<Option>();
		ops.add(new Option("Comparable is an interface", true));
		ops.add(new Option("Comparable is a method", false));
		ops.add(new Option("Comparable is an OS", false));
		ops.add(new Option("None of the above", false));
		q.setOptions(ops);
		qb.addNewQuestion(subjectName, q);
		
		return qb.getQuestionsFor(subjectName);
		
	}
}
