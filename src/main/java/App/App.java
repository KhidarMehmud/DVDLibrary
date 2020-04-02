/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
import DVDLibraryController.DVDLibraryController;
import com.sg.dvdlibrarydao.DAO;
import com.sg.dvdlibrarydao.DAOImpl;
import UI.IO;
import UI.IOImpl;
import UI.View;

/**
 *
 * @author Khidar
 */
//INSTANTIATING the different classes and putting them in the App class so you can run them in one method
public class App {
    public static void main(String[] args) {
	IO io = new IOImpl();
	View view = new View(io);
	DAO dao = new DAOImpl();
	DVDLibraryController controller = new DVDLibraryController(view, dao);
	
	controller.App();
    }
}

