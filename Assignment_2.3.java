import java.io.*;
import java.util.*;
class Student 
{
   String name, studentId;
   float  mark1, mark2, mark3;
    
	Student(String name, String studentId, float mark1, float mark2, float mark3) 
	{
        this.name = name;
        this.studentId = studentId;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    	}
    
        float getTotalMark() 
	{
        return (mark1 + mark2 + mark3);
    	}
        String getName()
	{
	return(name);
	}	
	String getStudentId()
	{
	return(studentId);
	}
}
 

class FileReading 
	{
    	//Declaring Array List   
	List<Student> students = new ArrayList<>();
    	//reading from file
    	void readData(String NameFile)
	{
	try
	{
        BufferedReader br = new BufferedReader(new FileReader(NameFile));
        String line;
        while ((line = br.readLine()) != null) 
	{
		
		//leaving comments
                 if (line.startsWith("#")) 
		  continue; 
		else
		{
                String[] parts = line.split(",");
            	String name = parts[1]+" "+parts[0];
            	String studentId = parts[2];
		float mark1=0,mark2=0,mark3=0;
		try{
            	mark1 = Float.parseFloat(parts[3]);
		}
		catch(Exception e1)
		{
		mark1=0;
		}
            	try{
            	mark2 = Float.parseFloat(parts[4]);
		}
		catch(Exception e1)
		{
		mark2=0;
		}

            	try{
            	mark3 =Float.parseFloat(parts[5]);
		}
		catch(Exception e1)
		{
		mark3=0;
		}

        //Adding to Arraylist    	
	students.add(new Student(name, studentId, mark1, mark2, mark3));
	        }
        }
        br.close();
	}
	catch(Exception e1)
	{
	System.out.println(e1);
	}
    }
    //function for outputting all the students data. 
    void printAll() 
	{
        for (Student student : students) 
	{
            System.out.println(student.getName() + " (" + student.getStudentId() + "): " + student.getTotalMark());
        }
    }

    	//filtering the data based on threshold based on algorithm 3
    	void filter(int value) 
	{
        for (Student student : students) 
		{
            		if (student.getTotalMark() < value) 
			{
                	System.out.println(student.getName() + " (" + student.getStudentId() + "): " + student.getTotalMark());
            		}
        	}
    	}
    
    		// Sorting the data based on algorithm 4
void sorting() 
{
        students.sort(Comparator.comparing(Student::getTotalMark));
       
	int n = students.size(); 
		for(int i=n-2;i>=1;i--)
		{
			for(int j=0;j<i;j++)
			{
				if (students.get(i).getTotalMark() > students.get(i + 1).getTotalMark()) 
				{ 
				Student temp = students.get(i); 
				students.set(i, students.get(i + 1)); 
				students.set(i + 1, temp); 
				}
			}
		}
	 System.out.println("Top 5 Students:");
        for (int i = students.size() - 5; i < students.size(); i++) 
	{
            System.out.println(students.get(i).getName() + " (" + students.get(i).getStudentId() + "): " + students.get(i).getTotalMark());
        }
        System.out.println("Bottom 5 Students:");
        for (int i = 0; i < 5; i++) 
	{
            System.out.println(students.get(i).getName() + " (" + students.get(i).getStudentId() + "): " + students.get(i).getTotalMark());
        }
}

}