/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;


/**
 *
 * @author user
 */
import java.io.Serializable;
import java.time.*;
import java.time.format.*;
import java.util.*;


public class Course implements Serializable {
    protected LocalDate initDate;
    protected Faculty courseCoord;  
    protected String courseName;                    
    protected int durat;           
    protected double courseFee;
    protected ArrayList<Faculty> arrInstructor = new ArrayList<Faculty>();     
    protected ArrayList<Participant> arrStudents = new ArrayList<Participant>(); 
    public Course() 
    {
    
    }
    public Course(String name, double fee, String date, int duration) throws Exception
    {
        if(!name.isEmpty())
            courseName = name;
        else throw new EmptyDetailException("name");
        if(fee<0)
            throw new WrongFeeException();
        else 
            courseFee= fee;
        initDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        if(duration<0 || duration >14)
            throw new DurationExceedException();
        else durat = duration;
    }
    
    @Override
    
    public String toString() 
    {
        try{
        return "Course Name:"+courseName+"\n"+"Course Coordinator:"+courseCoord.personName+"\n"+"Course Fee:"+courseFee+"\n"+"Course start date:"+initDate+"\n"+"Course duration:"+durat+"\n"+"----------------------------------"+"\n";
        }
        catch(Exception e)
        {
            System.out.println(e.getClass());return e.getMessage();
        }
        }
        
   public void initCourse(Course newCourse) {
        this.initDate = newCourse.initDate;
        this.courseName = newCourse.courseName;
        this.courseCoord= newCourse.courseCoord;
        this.courseFee = newCourse.courseFee;
        this.durat = newCourse.durat;
        this.arrInstructor = newCourse.arrInstructor;
        this.arrStudents = newCourse.arrStudents;
    }     
    
    public void newCoordinator(Faculty coordinator) {
       courseCoord=coordinator;
    }
    
    public void appendInstructor(Faculty inst) throws Exception
    {
        if(this.arrInstructor.size()>6) 
            throw new InstructorExceedException();
        else 
        {
            int flag=0;
            for(int i=0;i<this.arrInstructor.size();i++)
                if(arrInstructor.get(i).personName.equals(inst.personName))
                    flag = 1;
            if(flag==1)
                throw new InstructorRevisitException();
            else 
                this.arrInstructor.add(inst);
        }
    }
    public void appendParticipant(Participant pt) throws Exception
    {
        if(this.arrStudents.size()>5) 
            throw new ParticipantExceedException();
        else 
        {
            int temp=0;
            for(int i=0;i<this.arrStudents.size();i++)
                if(this.arrStudents.get(i).personName.equals(pt.personName))
                    temp=1;
            if(temp==1)
                throw new ParticipantRevisitException();
            else 
                this.arrStudents.add(pt);
        }
    }
    public ArrayList<Participant> studArray() throws Exception
    {
        ArrayList<Participant> p = new ArrayList<Participant>(arrStudents);
        if(!arrStudents.isEmpty())
            return arrStudents;
        else 
            throw new ParticipantEmpty();
    }
    public ArrayList<Faculty> facsArray()
    {
        ArrayList<Faculty> f = new ArrayList<Faculty>(arrInstructor);
        f.add(0,courseCoord);
        return f;
    }
    
    public boolean equals(String coursnam) {
        return courseName.equals(coursnam);
    }
    public boolean equals(Course course) {
        return (this.courseName.equals(course.courseName) &&this.courseFee == (course.courseFee) &&this.initDate.equals(course.initDate) &&this.durat == (course.durat) &&this.arrInstructor.equals(course.arrInstructor) &&this.arrStudents.equals(course.arrStudents)) ;
    }
}