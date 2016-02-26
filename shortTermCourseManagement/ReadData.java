/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class ReadData {
    final static String extension = ".dat";
    public static Object read(Object prev, String strName) {
        try(FileInputStream input = new FileInputStream(strName + ReadData.extension)) {
            ObjectInputStream inStream = new ObjectInputStream(input);
            return inStream.readObject();
        }
        catch(Exception e) {
            System.out.println(e);
            return prev;
        }
    }
}