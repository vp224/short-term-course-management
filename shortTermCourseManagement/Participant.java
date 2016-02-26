/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.io.Serializable;


class EmptyDetailException extends Exception {
    public EmptyDetailException(String detail) {
        super("Participant's " + detail + " is empty");
    }
}
public class Participant extends Person implements Serializable{
    protected String org_name = new String();
    public Participant()
    {
        
    }
    public Participant(String name, String address, long mobile, String org_name, String email) throws Exception
    {
            super(name,mobile,address,email);
            if(!org_name.isEmpty())
                this.org_name = org_name;
            else throw new EmptyDetailException("org_name");
    }
    public boolean equals(Participant newParticipant) {
        return super.equals(newParticipant) && this.org_name.equals(newParticipant.org_name);
    }
    @Override
    public String toString() {
        return super.toString()+","+this.org_name;
    }
}