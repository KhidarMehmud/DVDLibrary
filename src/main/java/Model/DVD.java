/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Khidar
 */
public class DVD {
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String studio;
    private String userNote;
    
    public DVD(String title) {
	this.title = title;
    }

    public String getTitle() {
	return title;
    }

    public String getReleaseDate() {
	return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
	return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
	this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
	return directorName;
    }

    public void setDirectorName(String DirectorName) {
	this.directorName = DirectorName;
    }

    public String getStudio() {
	return studio;
    }

    public void setStudio(String studio) {
	this.studio = studio;
    }

    public String getUserNote() {
	return userNote;
    }

    public void setUserNote(String userNote) {
	this.userNote = userNote;
    }
    
    
}

