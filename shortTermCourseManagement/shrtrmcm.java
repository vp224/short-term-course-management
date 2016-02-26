/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.util.*;
import java.io.*;
import java.time.*;

class InstructorRevisitException extends Exception {//same instructor is being revsiited again
    public InstructorRevisitException() {
        super("The faculty is alreay present in course");
    }
}
class ParticipantRevisitException extends Exception {//same participant is being revisited again
    public ParticipantRevisitException() {
        super("The student is alreay present in course");
    }
}
class WrongFeeException extends Exception {//thrown when the fee entered is negative
    public WrongFeeException()
    {
        super("Course's fee is negative");
    }
}
class DurationExceedException extends Exception {//thriwn when the duration of the course is not within 2 weeks
    public DurationExceedException() {
        super("Duration is not within 2 weeks");
    }
}
class InstructorExceedException extends Exception {//thrown when the numbe rof instructors is greater than 6
    public InstructorExceedException() {
        System.out.println("No more Instructor can be taken in this course");
    }
}
class ParticipantExceedException extends Exception {
    public ParticipantExceedException() {//no more participants can be taken in this course and thrown when the participants exceed 6 in number
        System.out.println("No more Participants can be taken in this course");
    }
}
class ParticipantEmpty extends Exception {//thrown when the partcicipant list is empty
    public ParticipantEmpty() {
        System.out.println("No Participants are there in this course");
    }
}
class CoursereVisitException extends Exception {//thrown when the same course is being revisited 
    public CoursereVisitException() {
        super("The course is alreay present");
    }
}
class CourseListFullException extends Exception {//thrown when the course list is full
    public CourseListFullException() {
        super("No more courses can be taken in");
    }
}
class NotMatchCurrentyearException extends Exception {// thrown when the current year and the adding year are not in the same year
    public NotMatchCurrentyearException(int currYear, int addingYear) {
        super(addingYear+"and"+ currYear+"are not in the same year");
    }
}

class Assment implements Serializable{
    public int thisYear;//var of present year
    public ArrayList<Course> courseArray = new ArrayList<Course>();//array list of courses
    public Assment(int year) {//constructor to initilaise the year
        thisYear = year;
    }
    public void add(Course newCourse) throws Exception {//function to add a course when there is no exception being thrown
        if(courseArray.size()>10)
            throw new CourseListFullException();
            
        else
        {
                if(newCourse.initDate.getYear() == thisYear) {
                int flag=0;
                for(int i=0;i<this.courseArray.size();i++) 
                    if(courseArray.get(i).courseName.equals(newCourse.courseName)) 
                        flag= 1;
                if(flag==0) 
                    courseArray.add(newCourse);
                else
                    throw new CoursereVisitException();
            }
            else
                throw new NotMatchCurrentyearException(thisYear, newCourse.initDate.getYear());  
        }
    }
    public void modify(Assment modList) throws Exception//return a modified list of courses when there is no exception
    {
        if(modList.courseArray.size() > 10)
            throw new CourseListFullException();
        else
        {
            if(modList.thisYear != thisYear) 
                throw new NotMatchCurrentyearException(thisYear,modList.thisYear);
            else
            {
                courseArray.clear();
                courseArray.addAll(modList.courseArray);
            }
        }
    }
}
class Institute implements Serializable {
    public ArrayList<Assment> assments = new ArrayList<Assment>();//an arary list of assesments(terms) of the course
    public void countYears(int years[],int n) {
        for(int i=0;i<n;i++)
        {
            Assment ass=new Assment(years[i]);
            assments.add(ass);
        }
    }
    public void copyInstitute(Institute newInsti) throws Exception{
        for(int a=0,b=0;b<newInsti.assments.size();b++) 
        {
            if(a < this.assments.size()) {
                this.assments.get(a).modify(newInsti.assments.get(b));
                a++;
            }
            else
                this.assments.add(newInsti.assments.get(b));
        }
    }
}
public class shrtrmcm {
    public static void main(String[] args) {
        Institute instii = new Institute();
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the year in which course management is to be done:");
        int year = Integer.parseInt(in.nextLine());
        int years[] = {year};
        instii.countYears(years,1); 
        instii.assments.add(new Assment(year));
        try {
            File f = new File("instii"+ReadData.extension);//when the previuosly stored data is being read
            if(f.exists()) {
                System.out.println("Year data is already present and you are reading previously stored dat");
                instii = (Institute)ReadData.read(instii,Integer.toString(year)+"instii");
            }
            else 
                System.out.println("Course List for:"+ year+" being made");
        }
        catch(Exception e) {
            System.out.println(e.getClass());
        }
        String sk;
        first:for(int i=0;;i++) {//the list of options as specified in the question
            System.out.println("WELCOME TO COURSE MANAGEMENT");
            System.out.println("1.)Create Course");
            System.out.println("2.)Display Courses");
            System.out.println("3.)Create Participant for a course");
            System.out.println("4.)Display Participants/ Faculty of a Course");
            System.out.println("5.)Delete Course/Faculty/Participant details");
            System.out.println("6.)Alter Course/Faculty/Participant details");
            System.out.println("7.)Save/Read Data");
            System.out.println("8.)terminate");
            int temp = Integer.parseInt(in.nextLine());
            switch(temp)
            {
                case 1 :
                {//access the details of the course
                         System.out.println("Enter the name of the course");
                         String newcname=in.nextLine();
                         System.out.println("Enter the start date of the new course");
                         String newcdate=in.nextLine();
                         System.out.println("Enter the fee of the new course");
                         String newfee=in.nextLine();
                         System.out.println("Enter the duration of the new course less than 2 weeks");
                         String newdurat=in.nextLine();
                         try 
                         {// access the details of the coordinator of the course
                            Course tempCourse = new Course(newcname,Double.parseDouble(newfee),newcdate,Integer.parseInt(newdurat));
                            System.out.println("Enter the name of the coordinator");
                            String coordname=in.nextLine();
                            System.out.println("Enter the department of coordinator");
                            String coorddept=in.nextLine();
                            System.out.println("Enter the address of the coordinator");
                            String coordadd=in.nextLine();
                            System.out.println("Enter the email of the coordinator");
                            String coordemail=in.nextLine();
                            System.out.println("Enter the mobile no of the coordinator");
                            String coordmob=in.nextLine();
                            Faculty coordtemp=new Faculty(coorddept,coordname, coordadd, coordemail,Long.parseLong(coordmob));
                            tempCourse.newCoordinator(coordtemp);
                            System.out.println("Start entering the details of the instructors;once you complete adding the arrInstructor type end of list for the dept of instructor or else the intake will end after taking 5 members");
                            while (true) {
                                if (tempCourse.arrInstructor.size() >6) //breaks when the instructor array list exceeds 6 in size
                                    break;
                            System.out.println("Enter instructor department");
                            String instdept=in.nextLine();
                            if(instdept.equals("end of list"))//when end of list is typed for the deptt of the instructor the intake stops and breaks put of the loop
                                break;
                            System.out.println("Enter instructor name");//access the details of the instructor when there s no exception
                            String instname=in.nextLine();
                            System.out.println("Enter instructor address");
                            String instadd=in.nextLine();
                            System.out.println("Enter instructor email");
                            String instemail=in.nextLine();
                            System.out.println("Enter instructor mobile number");
                            String instmob=in.nextLine();
                            
                           
                                   
                                if(instdept.isEmpty()||instname.isEmpty()||instadd.isEmpty()||instemail.isEmpty()||instmob.isEmpty())//if any of the details is an empty string then the input provide is a wrong input
                                    System.out.println("Wrong input!!");
                                else
                                {
                                    Faculty insttemp=new Faculty(instdept,instname,instadd,instemail,Long.parseLong(instmob));//parse the required details as per the calle functions
                                  tempCourse.appendInstructor(insttemp);
                                }}
                           
                            instii.assments.get(0).add(tempCourse);
                            System.out.println("########Course added succesfully#######");
                        }
                        catch(Exception e) {
                            System.out.println(e.getClass());
                            System.out.println("Sorry!! Details couldnt be updated");
                        }
                    }
                    break;
                case 2 :System.out.println("These are the list of courses:");
                        instii.assments.get(0).courseArray.forEach(e -> {System.out.println(e.toString());});
                    break;
                case 3 :
                {//access the details of the participant or adding him/her in the participant array list
                        System.out.println("Enter the participants name");
                        String partname=in.nextLine();
                        System.out.println("Enter the participants address");
                        String partadd=in.nextLine();
                        System.out.println("Enter the participants organization name");
                        String partorg=in.nextLine();
                        System.out.println("Enter the participants email");
                        String partemail=in.nextLine();
                        System.out.println("Enter the participants mobile no");
                        String partmob=in.nextLine();
                        try {
                            Participant temppartic= new Participant(partname, partadd, Long.parseLong(partmob),partorg,partemail );
                            System.out.println("These are the list of courses in which you want to add your participant");
                            instii.assments.get(0).courseArray.forEach(e->System.out.println(e.courseName));
                            System.out.print("Select one course name:");
                            String courseReq = in.nextLine();
                            instii.assments.get(0).courseArray.stream().filter((s) -> (s.courseName.equals(courseReq))).forEach((s) -> {s.arrStudents.add(temppartic);});// using a lambda expression for adding the new participant
                            System.out.println("Student has been added succesfully");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getClass());
                        }
                    }
                    break;
                case 4 :
                {
                        System.out.println("Enter the string Faculty or Participant to display the list");
                        String strChoice= in.nextLine();
                        System.out.println("These are the courses for which you want to diplay the faculty/partcipants list");
                        instii.assments.get(0).courseArray.forEach(e->System.out.println(e.courseName));
                        System.out.print("Enter the course name of which you want to display the "+strChoice+"list");
                        String coursetodisp = in.nextLine();
                        Course coursevar= new Course();
                        instii.assments.get(0).courseArray.stream().filter(e -> e.courseName.equals(coursetodisp)).forEach(coursevar::initCourse);
                        if(strChoice.equals("Participant"))
                        {
                            if(coursevar.arrStudents.isEmpty())
                                System.out.println("No student is present in the list");//if the array list of students is emty throw a console printable exception
                            else 
                                coursevar.arrStudents.forEach(s -> {System.out.println(s.personName);});
                                 
                        }
                         
                        else if(strChoice.equals("Faculty"))
                        {
                            if(coursevar.facsArray().isEmpty())
                                System.out.println("No faculty is present in the list");//if the faculty array list is empty throw a console printable exception
                            else 
                                coursevar.facsArray().forEach(s->{System.out.println(s.personName);});
                        }
                        else
                            System.out.println("Invalid input");
                        }
                    
                    break;
                case 5: 
                    {//case for deleting entitites...
                     
                            System.out.println("These are the list of courses present list of courses");
                            instii.assments.get(0).courseArray.forEach(e->System.out.println(e.courseName));
                           
                            System.out.print("Enter the name of the course of whose details are to be deleted : ");
                            String coursdelnam;
                            coursdelnam =in.nextLine();
                            Course oldCourse = new Course();
                            instii.assments.get(0).courseArray.stream().filter(e -> e.equals(coursdelnam)).forEach(oldCourse::initCourse);//lambda expression which intiates oldcourse by calling upon it setcourse method
                            System.out.println("Enter what do you want to delete.Accordingly input the string as Course||Faculty||Participant : ");
                            String str=in.nextLine();
                            if(str.equals("Course"))
                            {
                                try
                                {
                                int flag= 0;
                                for(int k=0;k<instii.assments.get(0).courseArray.size();k++) 
                                            flag=1;
                                if(flag==1) 
                                {
                                   instii.assments.get(0).courseArray.removeIf(e->e.courseName.equals(coursdelnam));
                                    System.out.println("#####Course removed succesfully#####");
                                }
                                else
                                    System.out.println("Course not present.so cant be removed!");
                                       
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e.getClass());
                                }
                            
                            } 
                                
                            else if(str.equals("Faculty")) {
                                    System.out.println("The list of faculty");
                                    oldCourse.facsArray().forEach(e->System.out.println(e.personName));
                                    System.out.print("Enter the faculty name :");
                                    String facremnam ;
                                    facremnam=in.nextLine();
                                    if (oldCourse.courseCoord.personName.equals(facremnam)) {
                                        while (true) {
                                            try 
                                            {
                                                System.out.println("Enter the name of the new coordinator");
                                                String coordnam=in.nextLine();
                                                System.out.println("Enter the department of the new coordinator");
                                                String coordep=in.nextLine();
                                                System.out.println("Enter the address of the new coordinator");
                                                String coordadd=in.nextLine();
                                                System.out.println("Enter the email id of the new coordinator");
                                                String coordemail=in.nextLine();
                                                System.out.println("Enter the mobile number of the new coordinator");
                                                Long coordmob=Long.parseLong(in.nextLine());
                                                if (coordep.isEmpty()||coordnam.isEmpty()||coordadd.isEmpty()||coordemail.isEmpty()) 
                                                {
                                                    if (oldCourse.arrInstructor.isEmpty()) 
                                                       System.out.println("empty string being typed");
                                                    else
                                                        oldCourse.newCoordinator(oldCourse.arrInstructor.remove(0));
                                                } 
                                                else 
                                                {
                                                    Faculty fcoordvar=new Faculty(coordep,coordnam,coordadd,coordemail,coordmob);
                                                    oldCourse.newCoordinator(fcoordvar);
                                                }
                                                for(int j=0 ; j< instii.assments.get(0).courseArray.size() ; j++)
                                                    if(instii.assments.get(0).courseArray.get(j).equals(coursdelnam))
                                                        instii.assments.get(0).courseArray.set(j, oldCourse);
                                                break;
                                            } 
                                            catch (Exception e) {
                                                System.out.println(e.getClass());
                                            }

                                        }
                                    } else {
                                        instii.assments.get(0).courseArray.stream().filter(e -> e.equals(coursdelnam)).forEach(e -> {e.arrInstructor.removeIf(s -> s.personName.equals(facremnam));
                                                                                                                        System.out.println("#####Faculty removed succesfully#####");});
                                    }
                                }
                 
                                else if(str.equals("Participant")){
                                    if(!oldCourse.arrStudents.isEmpty()) {
                                        System.out.println("These are the list of participants from which you can delete");
                                        oldCourse.arrStudents.forEach(e -> System.out.println(e.personName));
                                        System.out.println("enter the name of the student to be deleted ");
                                        str= in.nextLine();
                                        String studentInput = str;
                                        instii.assments.get(0).courseArray.stream().filter(e -> e.courseName.equals(coursdelnam)).forEach(e -> {
                                                                                                                    e.arrStudents.removeIf(p->p.personName.equals(studentInput));System.out.println("Removed");});}
                                    else
                                        System.out.println("Students list empty.nothing to delete");
                                }
                             else
                                     System.out.println("Wrong Input");
                        }
                break;
                case 6: 
                {
                            System.out.println("These are the courses for which details can be altered");
                            instii.assments.get(0).courseArray.forEach(e->System.out.println(e.courseName));
                            System.out.print("Enter the name of the course for which details are to be altered : ");
                            String str = in.nextLine();
                            String altercname;
                            altercname = str;
                            Course oldCourse = new Course();
                            instii.assments.get(0).courseArray.stream().filter(e -> e.equals(altercname)).forEach(oldCourse::initCourse);
                            System.out.println("Enter the option Faculty/Course/Partcicpant which is to be altered");
                            str=in.nextLine();
                            if(str.equals("Course"))
                            {
                                    System.out.println("These are the list of courses for which courses can be altered");
                                    instii.assments.get(0).courseArray.forEach(e->System.out.println(e));
                                    System.out.println("Enter the name of the new course or type same if the name is as the old one");
                                    String newcnam=in.nextLine();
                                    String s1=oldCourse.courseName;
                                    System.out.println("Enter the start date of the new course or type same if the name is as the old one");
                                    String newcdate=in.nextLine();
                                    System.out.println("Enter the fee of the new course or type same if the name is as the old one");
                                    String newcfee=in.nextLine();
                                    System.out.println("Enter the duration of the new course or type same if the name is as the old one");
                                    String newcdurat=in.nextLine();
                                    try {
                                        if(newcnam.equals("same"))
                                            newcnam = oldCourse.courseName;
                                        if(newcfee.equals("same"))
                                            newcfee = Double.toString(oldCourse.courseFee);
                                        if(newcdate.equals("same"))
                                           newcdate = oldCourse.initDate.toString();
                                        if(newcdurat.equals("same"))
                                            newcdurat = Integer.toString(oldCourse.durat);
                                        Faculty tempCoord = oldCourse.courseCoord;
                                        oldCourse = new Course(newcnam, Double.parseDouble(newcfee),newcdate, Integer.parseInt(newcdurat));
                                        oldCourse.courseCoord = tempCoord;
                                        for(int k=0 ; k < instii.assments.get(0).courseArray.size() ; k++) {
                                            if(instii.assments.get(0).courseArray.get(k).courseName.equals(s1))
                                                instii.assments.get(0).courseArray.set(k, oldCourse);
                                        }
                                        System.out.println("#####course alteration done succesfully#####");
                                    } 
                                    catch(Exception e) {
                                        System.out.println(e.getClass());
                                    }
          
                                }
       
                            else if(str.equals("Faculty")) 
                            {
                                    System.out.println("Enter the option Add or Change");
                                    str = in.nextLine(); 
                                    if(str.equals("Add"))
                                    {
                                        System.out.println("Enter the Instructors department to be added");
                                        String addidept=in.nextLine();
                                        System.out.println("Enter the Instructors name to be added");
                                        String addinam=in.nextLine();
                                        System.out.println("Enter the Instructors address to be added");
                                        String addiadd=in.nextLine();
                                        System.out.println("Enter the Instructors email to be added");
                                        String addiemail=in.nextLine();
                                        System.out.println("Enter the Instructors mobile to be added");
                                        String addimob=in.nextLine();
                                        
                                        try {
                                            Faculty addtempf=new Faculty(addidept,addinam,addiadd,addiemail,Long.parseLong(addimob));
                                            oldCourse.appendInstructor(addtempf);
                                                    
                                            for(int m=0 ; m < instii.assments.get(0).courseArray.size(); m++)
                                            {
                                                if(instii.assments.get(0).courseArray.get(m).courseName.equals(altercname))
                                                {
                                                    instii.assments.get(0).courseArray.get(m).initCourse(oldCourse);
                                                    System.out.println("#####Course added succesfully#####");
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                    else 
                                    {
                                        oldCourse.facsArray().forEach(e -> System.out.println(e));
                                        System.out.print("Enter the Faculty name :");
                                        String chngfacnam = in.nextLine();
                                        if (oldCourse.courseCoord.equals(chngfacnam)) {
                                            while (true) {
                                                try {
                                                    System.out.println("Enter the dept of the coordinator or same if it is same as before");
                                                    String chngcoord=in.nextLine();
                                                    System.out.println("Enter the name of the Coordinator or same if it is same as before");
                                                    String chngnamcrd=in.nextLine();
                                                    System.out.println("Enter the address of the coordinator or same if it is same as before");
                                                    String chngcrdadd=in.nextLine();
                                                    System.out.println("Enter the email of the coordinator or same if it is same as before");
                                                    String chngcrdemail=in.nextLine();
                                                    System.out.println("Enter the mobile of the coordinator or same if it is same as before");
                                                    String chngcrdmob=in.nextLine();
                                                    if (chngcoord.isEmpty()||chngnamcrd.isEmpty()||chngcrdadd.isEmpty()||chngcrdemail.isEmpty()) {
                                                        if (!oldCourse.arrInstructor.isEmpty()) {
                                                            oldCourse.newCoordinator(oldCourse.arrInstructor.remove(0));
                                                        } 
                                                        else 
                                                            System.out.println("Typing an empty string");
                                                    } 
                                                    else 
                                                    {
                                                        
                                                        if(chngcoord.equals("same"))
                                                            chngcoord = oldCourse.courseCoord.dept;
                                                        if(chngnamcrd.equals("same"))
                                                            chngnamcrd = oldCourse.courseCoord.personName;
                                                        if(chngcrdadd.equals("same"))
                                                            chngcrdadd = oldCourse.courseCoord.personAddress;
                                                        if(chngcrdemail.equals("same"))
                                                            chngcrdemail = oldCourse.courseCoord.personEmail;
                                                        if(chngcrdmob.equals("same"))
                                                            chngcrdmob = Long.toString(oldCourse.courseCoord.personMobile);
                                                        Faculty fchngcoord=new Faculty(chngcoord, chngnamcrd, chngcrdadd, chngcrdemail,Long.parseLong(chngcrdmob));
                                                        oldCourse.newCoordinator(fchngcoord);
                                                        if(oldCourse.initDate.getYear() != year)
                                                            throw new Exception("Course is not of current year and cannot be added");
                                                    }
                                                    for (int p = 0; p < instii.assments.get(0).courseArray.size(); p++) {
                                                        if (instii.assments.get(0).courseArray.get(p).equals(altercname)) {
                                                            instii.assments.get(0).courseArray.get(p).initCourse(oldCourse);
                                                        }
                                                    }
                                                    System.out.println("#####Faculty alteration succesful#####");
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                        } 
                                        else 
                                        {
                                            try {
                                                System.out.println("Enter the Faculty dept or same if it is same as before");
                                                String facdep=in.nextLine();
                                                System.out.println("Enter the faculty name or same if it is same as before");
                                                String facnam=in.nextLine();
                                                System.out.println("Enter the faculty address or same if it is same as before");
                                                String facadd=in.nextLine();
                                                System.out.println("Enter the faculty email or same if it is same as before");
                                                String facemail=in.nextLine();
                                                System.out.println("Enter the faculty mobile or same if it is same as before");
                                                String facmob=in.nextLine();
                                                for (int k = 0; k < oldCourse.arrInstructor.size(); k++) {
                                                    if (oldCourse.arrInstructor.get(k).equals(chngfacnam)) {
                                                        if(facdep.equals("same"))
                                                            facdep = oldCourse.arrInstructor.get(k).dept;
                                                        if(facnam.equals("same"))
                                                            facnam = oldCourse.arrInstructor.get(k).personName;
                                                        if(facadd.equals("same"))
                                                            facadd = oldCourse.arrInstructor.get(k).personAddress;
                                                        if(facemail.equals("same"))
                                                            facemail = oldCourse.arrInstructor.get(k).personEmail;
                                                        if(facmob.equals("same"))
                                                            facmob = Long.toString(oldCourse.arrInstructor.get(k).personMobile);
                                                        oldCourse.arrInstructor.set(i, new Faculty(facdep, facnam, facadd, facemail,Long.parseLong(facmob)));
                                                    }
                                                }
                                                for (int n = 0; n < instii.assments.get(0).courseArray.size(); n++) {
                                                    if (instii.assments.get(0).courseArray.get(n).equals(altercname)) {
                                                        instii.assments.get(0).courseArray.set(n, oldCourse);
                                                    }
                                                }
                                                break;
                                            } 
                                            catch (Exception e) {
                                                System.out.println(e.getClass());
                                            }
                                        }
                                    }
                                }
                                else if(str.equals("Participant")) {
                                        System.out.println("These are the arrStudents list present in the course");
                                        oldCourse.arrStudents.forEach(e -> System.out.println(e.personName));
                                        System.out.print("Enter the name of the new participant : ");
                                        String chngParticipant=in.nextLine();
                                            try {
                                                System.out.println("Enter the participants name or type same if the name is as the old one");
                                                String partnam=in.nextLine();
                                                System.out.println("Enter the participants addrress or type same if the name is as the old one");
                                                String partadd=in.nextLine();
                                                System.out.println("Enter the participants mobile or type same if the name is as the old one");
                                                String partmob=in.nextLine();
                                                System.out.println("Enter the participants organizations name or type same if the name is as the old one");
                                                String partorgnam=in.nextLine();
                                                System.out.println("Enter the participants email or type same if the name is as the old one");
                                                String partemail=in.nextLine();
                                                for(int z=0;z<oldCourse.arrStudents.size();z++)
                                                    if(oldCourse.arrStudents.get(z).equals(chngParticipant)) {
                                                        if(partnam.equals("same"))
                                                            partnam = oldCourse.arrStudents.get(z).personName;
                                                        if(partadd.equals("same"))
                                                            partadd = oldCourse.arrStudents.get(z).personAddress;
                                                        if(partmob.equals("same"))
                                                            partmob = Long.toString(oldCourse.arrStudents.get(z).personMobile);
                                                        if(partorgnam.equals("same"))
                                                            partorgnam = oldCourse.arrStudents.get(z).org_name;
                                                        if(partemail.equals("same"))
                                                            partemail = oldCourse.arrStudents.get(z).personEmail;
                                                        Participant p=new Participant(partnam, partadd, Long.parseLong(partmob), partorgnam, partemail);
                                                        oldCourse.arrStudents.set(z,p);
                                                    }
                                                for(int f=0 ; f < instii.assments.get(0).courseArray.size() ; f++)
                                                    if(instii.assments.get(0).courseArray.get(f).equals(altercname))
                                                        instii.assments.get(0).courseArray.get(f).initCourse(oldCourse);
                                                System.out.println("####Particpiants altered succesfully####");
                                            } catch (Exception e) 
                                            {
                                                System.out.println(e.getClass());
                                            }
                                }
                                else 
                                    System.out.println("Wrong Input");
                            
                }
           
                break;

                case 7 : {
                    System.out.println("Enter the option save||read");
                    String input = in.nextLine();
                    if(input.equals("read")) {
                        try {
                            instii.copyInstitute((Institute)ReadData.read(instii, "instii"+Integer.toString(year)));
                            System.out.println("Data reading succesfull");
                        } 
                        catch (Exception e) {
                            System.out.println(e.getClass());
                        }
                    }
                    else if(input.equals("save"))
                    {
                        try
                        {
                            SaveData.save(instii,"instii"+Integer.toString(year));
                            System.out.println("Data saved succesfully");
                        }
                        catch(Exception e) {
                            System.out.println(e.getClass());
                        }                
                    }
                    else {
                        System.out.println("Wrong Input");
                    }
                }
                    break;
                case 8: break first;
                default : System.out.println("Wrong Input");
                    break;
            }
        }
    }
}
