import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;
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
 
