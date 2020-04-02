/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarydao;
import java.util.List;
import Model.DVD;
/**
 *
 * @author Khidar
 */
public interface DAO {
    //Adds a dvd to the a list
    public void addDVD(String title, DVD dvd) throws DAOException;

    //Removes a dvd from a list
    public void removeDVD(String title) throws DAOException;

    //Edits a dvd in a list
    public void editDVDInfo(String title) throws DAOException;

    //Returns a dvd in a list
    public DVD getDVD(String title) throws DAOException;

    //Returns a list of DVDs
    public List<DVD> getDVDlist() throws DAOException;
    
    //Returns a list of DVD titles
    public List<String> getDVDTitles() throws DAOException;
}


