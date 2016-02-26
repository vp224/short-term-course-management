/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.io.*;
public class SaveData {
    public final static String extension = ".dat";
    public static void save(Object p, String objectName) {
        try(FileOutputStream output = new FileOutputStream(objectName + ReadData.extension)) {
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(p);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}