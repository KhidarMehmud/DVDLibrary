/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibraryController;
import com.sg.dvdlibrarydao.DAO;
import com.sg.dvdlibrarydao.DAOException;
import Model.DVD;
import UI.View;
/**
 *
 * @author Khidar
 */
public class DVDLibraryController {
    


    View view;
    DAO dao;
    
// implement a constructor that initializes these members
    // we are going to change View so that it is has its 
    //dependency injected into its constructor. 
    
    public DVDLibraryController (View view, DAO dao) {
	this.view = view;
	this.dao = dao;
    }


    public void App() {
	int userChoice = 0;
	int wrongInputCounter = 0;

	view.displayBannerStart();

	try {
	    while (true) {
		view.displayBannerMenuMain();
		view.displayDVDMenuMain();

		userChoice = view.getCommandDVDMenuMain();

		repeatUserChoice:
		do {
		    switch (userChoice) {
			case 1:
			    addDVD();
			    break;
			case 2:
			    removeDVD();
			    break;
			case 3:
			    editDVD();
			    break;
			case 4:
			    displayDVD();
			    break;
			case 5:
			    displayDVDList();
			    break;
			case 6:
			    view.displayBannerExit();
			    System.exit(0);
			    break;
			default:
			    view.displayMessageUnknownCommand();
			    if (wrongInputCounter >= 4) {
				wrongInputCounter = 0;

				break repeatUserChoice;
			    }
			    else {
				wrongInputCounter++;
			    }
			    userChoice = view.getCommandDVDMenuMain();
			    continue;
		    }

		    if (userChoice >= 1 && userChoice <= 6) {
			view.displayMessageRepeatOption(userChoice);
			String doAgain = view.getCommandRepeatOption();
			if (doAgain.equalsIgnoreCase("y") == false) {
			    break;
			}
		    }
		}
		while (true);
	    }
	}
	catch (DAOException ex) {
	    view.displayMessageError(ex.getMessage());
	}
    }

    public void addDVD() throws DAOException {
	view.displayBannerDVDAdd();
	String title = view.getDataDVDTitleAdd();
	if (dao.getDVDTitles().contains(title)) {
	    view.displayMessageDVDAlreadyExists(title);
	    String userInput = view.getCommandDVDEditExisting(title);
	    if (userInput.equalsIgnoreCase("y")) {
		editDVD();
	    }
	}
	else {
	    DVD dvd = view.getDataDVDAdd(title);
	    dao.addDVD(dvd.getTitle(), dvd);
	    view.displayBannerDVDAddSucess();
	}
    }

    public void removeDVD() throws DAOException {
	view.displayBannerDVDRemove();
	String title = view.getDataDVDTitleRemove();

	if (dao.getDVD(title) == null) {
	    view.displayMessageDVDNotFound();
	}
	else {
	    dao.removeDVD(title);
	    view.displayBannerDVDRemoveSuccess();
	}
    }

    public void editDVD() throws DAOException {
	int userChoice = 0;
	int wrongInputCounter = 0;
	String title;

	view.displayBannerDVDEdit();
	title = view.getDataDVDTitleEdit();
	DVD dvd = dao.getDVD(title);

	if (dvd == null) {
	    view.displayMessageDVDNotFound();
	    return;
	}

	do {
	    view.displayBannerDVDEditMenu();
	    view.displayDVDMenuEdit();
	    userChoice = view.getCommandDVDMenuEdit();
	    if (userChoice == 6) {
		break;
	    }
	    else if (userChoice >= 1 && userChoice <= 5) {
		String newData;
		switch (userChoice) {
		    case 1:
			view.displayBannerDVDEditData(dvd.getReleaseDate());
			newData = view.getDataDVDEdit(dvd, "What is the new release date?");
			dvd.setReleaseDate(newData);
			view.displayBannerDVDEditSuccess();
			break;
		    case 2:
			view.displayBannerDVDEditData(dvd.getMPAARating());
			newData = view.getDataDVDEdit(dvd, "What is the new MPAA rating?");
			dvd.setMPAARating(newData);
			view.displayBannerDVDEditSuccess();
			break;
		    case 3:
			view.displayBannerDVDEditData(dvd.getDirectorName());
			newData = view.getDataDVDEdit(dvd, "What is the new director name?");
			dvd.setDirectorName(newData);
			view.displayBannerDVDEditSuccess();
			break;
		    case 4:
			view.displayBannerDVDEditData(dvd.getStudio());
			newData = view.getDataDVDEdit(dvd, "What is the new studio?");
			dvd.setStudio(newData);
			view.displayBannerDVDEditSuccess();
			break;
		    case 5:
			view.displayBannerDVDEditData(dvd.getUserNote());
			newData = view.getDataDVDEdit(dvd, "What is the new note?");
			dvd.setUserNote(newData);
			view.displayBannerDVDEditSuccess();
			break;
		    default:
			break;
		}
	    }
	    else if (wrongInputCounter >= 5 || userChoice == 6) {
		wrongInputCounter = 0;
		break;
	    }
	    else {
		view.displayMessageUnknownCommand();
		wrongInputCounter++;
	    }
	}
	while (true);

    }

    public void displayDVD() throws DAOException {
	view.displayBannerDVD();
	String title = view.getDataDVDTitle();
	DVD dvd = dao.getDVD(title);

	if (dvd == null) {
	    view.displayMessageDVDNotFound();
	}
	else {
	    view.displayDVD(dvd);
	}
    }

    public void displayDVDList() throws DAOException {
	view.displayBannerDVDList();

	if (dao.getDVDlist().isEmpty()) {
	    view.displayMessageNoDVDsInList();
	}
	else {
	    view.displayDVDList(dao.getDVDlist());
}
}
}