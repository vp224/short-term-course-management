/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.io.Serializable;

public class Faculty extends Person implements Serializable{
    protected String dept = new String();
    public Faculty()
    {
        
    }
    public Faculty(String dept, String name, String address, String email, long mobile) throws Exception
    {
        super(name,mobile,address,email);
            if(dept.isEmpty())
                throw new EmptyDetailException("dept");
            else 
                this.dept = dept;
            
    }
    public boolean equals(Faculty newFaculty) {
        return super.equals(newFaculty) && this.dept.equals(newFaculty.dept);
    }
    @Override
    public String toString() {
        return super.toString()+","+this.dept;
    }
}
