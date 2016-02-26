/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.io.Serializable;

class WrongMobileException extends Exception{
    public WrongMobileException()
    {
        super("Invalid mobile number");
    }
}
public class Person  implements Serializable{
    protected String personName,personAddress,personEmail;
    protected long personMobile;
    public Person()
    {
        
    }
    public Person(String name,long mobile,String address,String email) throws Exception
    {
            if(name.isEmpty())
                throw new EmptyDetailException("dept");
            else 
                personName = name;
            if(mobile/1000000000 == 0) 
                throw new WrongMobileException();
            else 
                personMobile = mobile;
            if(address.isEmpty())
                throw new EmptyDetailException("address");
            else 
                personAddress = address;
            if(email.isEmpty())
                throw new EmptyDetailException("email");
            else 
                personEmail = email;
    }
    /*public boolean equals(String personName) {
        return this.name.equals(personName);
    }*/
    public boolean equals(Person newPerson) {
        return this.personName.equals(newPerson.personName)&&this.personAddress.equals(newPerson.personAddress)&&this.personEmail.equals(newPerson.personEmail) &&this.personMobile == (newPerson.personMobile) ;
    }

    
   @Override
    public String toString() {
        return personName+","+personAddress+","+personEmail+","+personMobile;
    }
}