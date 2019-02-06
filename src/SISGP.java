import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.text.*;
import java.nio.file.Files;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class SISGP
	{
		static ArrayList<Student> students = new ArrayList<Student>();
		
		public static void main(String[] args) throws FileNotFoundException
			{
				readStudents();
				printStudents();
				calculateGPA();
			}
		
		public static void readStudents() throws FileNotFoundException
		{
			Scanner fileReader = new Scanner(new File("Students.txt"));
			while(fileReader.hasNextLine())
				{
					String input = fileReader.nextLine();
					String[] info = input.split(" ");
					
					String name = (info[0] + " " + info[1]);
					Student s = new Student(name);
					
					for(int i = 0; i < 3; i++)
						{
							int period = i+1;
							String className = info[2 + (i*2)];
							String grade = info[3 + (i*2)];
							s.getClasses().add(new Course(period, className, grade));
						}
					
					students.add(s);
				}
		}
		public static void printStudents()
		{
			for(Student s: students)
				{
					System.out.print((students.indexOf(s) + 1) + ") " + s.getName() + " ");
					System.out.printf("%.2f", s.getGPA());
					for(Course c: s.getClasses())
						{
							System.out.print(", " + c.getName() + " " + c.getGrade());
						}
					System.out.print("\n");
      }
	}

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class SISGP
	{
		static ArrayList<Student> students = new ArrayList<Student>();
		static Scanner userIntPut = new Scanner(System.in);
		static int userChoice;
		
		public static void main(String[] args) throws FileNotFoundException
			{
				readStudents();
				System.out.println("Welcome to the Student Information System. Accessing database...\n Would you like to: \n\t"
						+ "1) Add or Delete a student\n\t"
						+ "2) Change a student's Grades or Schedule\n\t"
						+ "3) Sort students\n\t"
						+ "4) Print student roster");
				userChoice = userIntPut.nextInt();
				switch(userChoice)
				{
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						printStudents();
					default:
						break;
				}
			}
		
		public static void readStudents() throws FileNotFoundException
		{
			Scanner fileReader = new Scanner(new File("Students.txt"));
			while(fileReader.hasNextLine())
				{
					String input = fileReader.nextLine();
					String[] info = input.split(" ");
					
					String name = (info[0] + " " + info[1]);
					Student s = new Student(name);
					
					for(int i = 0; i < 3; i++)
						{
							int period = i+1;
							String className = info[2 + (i*2)];
							String grade = info[3 + (i*2)];
							s.getClasses().add(new Course(period, className, grade));
						}
					
					students.add(s);
				}
		}
		
		public static void printStudents()
		{
			for(Student s: students)
				{
					System.out.print((students.indexOf(s) + 1) + ") " + s.getName() + " ");
					System.out.printf("%.2f", s.getGPA());
					for(Course c: s.getClasses())
						{
							System.out.print(", " + c.getName() + " " + c.getGrade());
						}
					System.out.print("\n");
				}
		}
		//removes students from the array
		public static void removeStudents()
		{
			
			boolean removeRunner = true;
			while(removeRunner == true)
			{
			System.out.println("What Student would you like to delete?");
			printStudents();
			Scanner removing = new Scanner(System.in);
			int childRemove = removing.nextInt();
			
			if(childRemove == 1)
			{
				students.remove(childRemove - 1);
			}
			else
			{
			students.remove(childRemove - 1);
			printStudents(); //calls printStudents method with the student missing that you chose
			}
		
			System.out.println("Would you like to remove another student?");
			Scanner remove = new Scanner(System.in);
			String rerunRemove = remove.nextLine();
			if(rerunRemove == ("yes"))
				{
					removeRunner = true;
					printStudents();
					
				}
			else
			{
					removeRunner = false;
			}
		}
		}
  
    public static void calculateGPA()
		{//hi
			DecimalFormat deFor = new DecimalFormat("#.##");
			double gpa =0;
			for(int i =0; i < students.size(); i++)
				{
					for(int a =0; a < students.get(i).getClasses().size();a++)
						{
							switch(students.get(i).getClasses().get(a).getGrade())
							{
								case "A+":
									gpa += 4.3;
									break;
								case "A":
									gpa += 4.0;
									break;
								case "A-":
									gpa += 3.7;
									break;
								case "B+":
									gpa += 3.3;
									break;
								case "B":
									gpa += 3.0;
									break;
								case "B-":
									gpa += 2.7;
									break;
								case "C+":
									gpa += 2.3;
									break;
								case "C":
									gpa += 2.0;
									break;
								case "C-":
									gpa += 1.7;
									break;
								case "D+":
									gpa += 1.3;
									break;
								case "D":
									gpa += 1.0;
									break;
								case "D-":
									gpa += 0.7;
									break;
								case "F":
									gpa += 0;
									break;
							}
						}
					students.get(i).setGPA(gpa/3);
					gpa =0;
				}
		}

	}
  
  
		

	

